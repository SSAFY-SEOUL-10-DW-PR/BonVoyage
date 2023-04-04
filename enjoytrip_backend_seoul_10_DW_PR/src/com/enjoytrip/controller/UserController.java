package com.enjoytrip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enjoytrip.model.MemberDto;
import com.enjoytrip.service.MemberService;
import com.enjoytrip.service.MemberServiceImpl;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;

	public void init() {
		memberService = MemberServiceImpl.getMemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		String path = "";
		if ("mvlogin".equals(action)) {
			path = "/inner-page.jsp";
			redirect(request, response, path);
		} else if ("login".equals(action)) {
			path = login(request, response);
			forward(request, response, path);
		} else if ("logout".equals(action)) {
			path = logout(request, response);
			forward(request, response, path);
		} else if ("join".equals(action)) {
			path = join(request, response);
			forward(request, response, path);
		}
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		return "";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String user_id = request.getParameter("id");
		String user_pwd = request.getParameter("pw");
		try {
			MemberDto memberDto = memberService.login(user_id, user_pwd);
			if (memberDto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				return "/index.jsp";
			} else {
				request.setAttribute("msg", "아이디 또는 비번 확인!!!!");
				return "/inner-page.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

	private String join(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberDto = new MemberDto();
		memberDto.setId(request.getParameter("uid"));
		memberDto.setPw(request.getParameter("pwd"));
		memberDto.setEmail(request.getParameter("email_id") + "@" + request.getParameter("email_add"));
		memberDto.setName(request.getParameter("uname"));
		memberDto.setBirth(
				request.getParameter("yy") + "." + request.getParameter("mm") + "." + request.getParameter("dd"));
		memberDto.setPhone(request.getParameter("mobile"));
		System.out.println();
		
		try {
			memberService.join(memberDto);
			return "/user?action=mvlogin";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

}
