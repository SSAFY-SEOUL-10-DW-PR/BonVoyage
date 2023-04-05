package com.enjoytrip.route.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enjoytrip.attraction.model.AttractionDto;
import com.enjoytrip.model.MemberDto;
import com.enjoytrip.route.model.RouteDto;
import com.enjoytrip.route.model.service.RouteService;
import com.enjoytrip.route.model.service.RouteServiceImpl;

@WebServlet("/route")
public class RouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RouteService routeService;

	@Override
	public void init() throws ServletException {
		super.init();
		routeService = RouteServiceImpl.getRouteService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String path = "";
		if ("save".equals(action)) {
			path = save(request, response);
			redirect(request, response, path);
		} else if ("load".equals(action)) {
			path = load(request, response);
			forward(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else if ("modify".equals(action)) {
			path = modify(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}

	private String load(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		String type = request.getParameter("type");
		if (memberDto != null) {
			String userId = memberDto.getId();
			try {
				if ("latest".equals(type)) {
					List<RouteDto> routes = routeService.getRouteByUser(userId);
					RouteDto latestroute = routes.get(routes.size() - 1);
					request.setAttribute("route", latestroute);
					return "/index.jsp";
				} else if ("all".equals(type)) {
					List<RouteDto> routes = routeService.getRouteByUser(userId);
					request.setAttribute("routeList", routes);
//TODO path 넣기
					return "";
				} else if ("certain".equals(type)) {
					int routeId = Integer.parseInt(request.getParameter("id"));
					RouteDto route = routeService.getRouteById(routeId);
					request.setAttribute("route", route);
					return "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글목록 출력 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else {
			return "/user/login.jsp";
		}
		return "";
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {

		return null;
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private String save(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			RouteDto routeDto = new RouteDto();
			routeDto.setUserId(memberDto.getId());
			String[] list = request.getParameterValues("routeElements");
			List<AttractionDto> routeList = new ArrayList<>();
			for (String attraction : list) {
				AttractionDto att = new AttractionDto(attraction);
				routeList.add(att);
			}
			routeDto.setRouteInfo(routeList);
			try {
				routeService.createRoute(routeDto);
				return "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/user/login.jsp";

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
