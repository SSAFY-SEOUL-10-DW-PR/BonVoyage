package com.enjoytrip.review.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.enjoytrip.model.BoardDto;
import com.enjoytrip.model.MemberDto;
import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.review.model.service.ReviewService;
import com.enjoytrip.review.model.service.ReviewServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private ReviewService reviewService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		reviewService = ReviewServiceImpl.getReviewService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String path = "";
		if ("write".equals(action)) {
			path = write(request, response);
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
	
	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			ReviewDto reviewDto= new ReviewDto();
			reviewDto.setUserId(memberDto.getId());
			reviewDto.setContentId(Integer.parseInt(request.getParameter("contentId")));
			reviewDto.setContentTypeId(Integer.parseInt(request.getParameter("contentTypeId")));
			reviewDto.setReviewContent(request.getParameter("reviewConent"));;
			
			try {
				reviewService.createReview(reviewDto);
				return "/portfolio-details.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/inner-page.jsp";
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
