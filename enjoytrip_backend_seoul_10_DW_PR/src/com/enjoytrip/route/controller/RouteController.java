package com.enjoytrip.route.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enjoytrip.route.model.service.RouteService;
import com.enjoytrip.route.model.service.RouteServiceImpl;


@WebServlet("/route")
public class RouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RouteService routeService;

	@Override
	public void init() throws ServletException {
		super.init();
		routeService= RouteServiceImpl.getRouteService();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String path = "";
		if("save".equals(action)) {
			path = save(request, response);
			redirect(request, response, path);
		}  else if("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		}  else if("detail".equals(action)) {
			path = detail(request, response);
			forward(request, response, path);
		}  else if("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}


	private String save(HttpServletRequest request, HttpServletResponse response) {
		String path="";
		List
		return path;
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

}
