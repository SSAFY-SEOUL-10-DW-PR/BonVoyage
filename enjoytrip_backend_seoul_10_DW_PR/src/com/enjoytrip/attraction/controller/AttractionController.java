package com.enjoytrip.attraction.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.enjoytrip.model.MemberDto;
import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.review.model.service.ReviewService;
import com.enjoytrip.review.model.service.ReviewServiceImpl;
import com.enjoytrip.service.MemberService;
import com.enjoytrip.service.MemberServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class AttractionController
 */
@WebServlet("/attraction")
public class AttractionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReviewService reviewService;
	private MemberService memberService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		reviewService = ReviewServiceImpl.getReviewService();
		memberService=MemberServiceImpl.getMemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String path = "";
		if ("detail".equals(action)) {
			path = detail(request, response);
			forward(request, response, path);
		}
//		} else if ("load".equals(action)) {
//			String type = request.getParameter("type");
//			if ("latest".equals(type)) {
//				loadLatesttRoute(request,response);}
////			}else if ("all".equals(type)) {
////				
////			}else if ("certain".equals(type)) {
////				
////			}
//		} else if ("delete".equals(action)) {
//			path = delete(request, response);
//			redirect(request, response, path);
//		} else if ("modify".equals(action)) {
//			path = modify(request, response);
//			redirect(request, response, path);
//		} else {
//			redirect(request, response, path);
//		}
	}
	
	private String detail(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Map<String, Object>> tripImg = gson.fromJson(request.getParameter("tripImg"), new TypeToken<ArrayList<Map<String, Object>>>() {}.getType());
		JSONObject attObject=new JSONObject(new JSONArray(request.getParameter("tripDetail")).get(0).toString());
		int contentId=Integer.parseInt( attObject.getString("contentid"));
		Map tripDetail = gson.fromJson(attObject.toString(),new TypeToken<Map<String,Object>>(){}.getType() );
		request.setAttribute("desc",request.getParameter("desc"));
		request.setAttribute("tripDetail",tripDetail);
		request.setAttribute("tripImg",tripImg);
		
		try {
			List<ReviewDto> reviews=reviewService.getReviewByAttraction(contentId);
			Calendar current = Calendar.getInstance();
	        int currentYear  = current.get(Calendar.YEAR);
	        JSONArray jarray= new JSONArray();
			for (ReviewDto reviewDto : reviews) {
				System.out.println(reviewDto.getUserId());
				MemberDto memberdto= memberService.findMemberInfo(reviewDto.getUserId());
				JSONObject obj=new JSONObject(reviewDto);
				int age=(currentYear-Integer.parseInt(memberdto.getBirth().substring(0, 4))+1)/10*10;
				obj.put("name", memberdto.getName());
				obj.put("age", age);
				obj.put("sex", "woman");
				jarray.put(obj);
			}
			List<Map<String, Object>> reviewers = gson.fromJson(jarray.toString(), new TypeToken<ArrayList<Map<String, Object>>>() {}.getType());
			request.setAttribute("reviewers", reviewers);
			System.out.println(reviewers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/portfolio-details.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws IOException, ServletException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}
}
