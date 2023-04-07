package com.enjoytrip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enjoytrip.model.MemberDto;
import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.review.model.service.ReviewService;
import com.enjoytrip.review.model.service.ReviewServiceImpl;
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
		} else if ("mvmypage".equals(action)) {
			path = mvmypage(request, response);
			redirect(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else if ("login".equals(action)) {
			path = login(request, response);
			forward(request, response, path);
		} else if ("logout".equals(action)) {
			path = logout(request, response);
			forward(request, response, path);
		} else if ("join".equals(action)) {
			path = join(request, response);
			redirect(request, response, path);
		} else if ("modify".equals(action)) {
			path = modify(request, response);
			forward(request, response, path);
		} else if ("findID".equals(action)) {
			path = findID(request, response);
			redirect(request, response, path);
		} else if ("checkQuestion".equals(action)) {
			path = checkQuestion(request, response);
			forward(request, response, path);
		} else if ("changepw".equals(action)) {
			path = changepw(request, response);
			forward(request, response, path);
		}
//		else if ("findPwSendEmail".equals(action)) {
//			findPwSendEmail(request, response);
//		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");

		try {
			memberService.delete(memberDto);
			session.removeAttribute("userinfo");
			return "/inner-page.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		memberDto.setPw(request.getParameter("pwd"));
		memberDto.setEmail(request.getParameter("email_id"));
		memberDto.setName(request.getParameter("uname"));
		memberDto.setBirth(request.getParameter("birth"));
		memberDto.setPhone(request.getParameter("mobile"));
		memberDto.setQuestion(request.getParameter("question"));
		memberDto.setAnswer(request.getParameter("answer"));

		session.setAttribute("userinfo", memberDto);

		try {
			memberService.modify(memberDto);
			return mvmypage(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			return "/modify-member-info.jsp";
		}
	}

	private String mvmypage(HttpServletRequest request, HttpServletResponse response) {

		return "/modify-member-info.jsp";
	}

	private String findID(HttpServletRequest request, HttpServletResponse response) {
		String user_id = request.getParameter("id");
		HttpSession session = request.getSession();
		try {
			MemberDto memberDto = memberService.findID(user_id);
			if (memberDto != null) {
				System.out.println(memberDto.getId() + " " + memberDto.getAnswer() + " " + memberDto.getQuestion());
				session.setAttribute("findUser", memberDto);
				session.setAttribute("findFlag", true);
			} else {
				session.setAttribute("IdNotFound", "해당 아이디는 존재하지 않습니다.");
			}
			return "/inner-page.jsp";
		} catch (Exception e) {
			return "/error/error.jsp";
		}
	}

	private String checkQuestion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("findUser");
		if (memberDto.getQuestion() != null && memberDto.getAnswer() != null)
			if (memberDto.getQuestion().equals(request.getParameter("findQuestion"))
					&& memberDto.getAnswer().equals(request.getParameter("findAnswer")))
				session.setAttribute("checkFlag", 1);
			else
				session.setAttribute("questionError", "비밀번호 확인 질문 또는 답변이 틀렸습니다.");
		return "/inner-page.jsp";
	}

	private String changepw(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("findUser");
		session.removeAttribute("findUser");
		String id = memberDto.getId();
		String pw = request.getParameter("newPassword");
		int result = 0;
		try {
			result = memberService.changePw(pw, id);
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		request.setAttribute("result", result);
		return "/inner-page.jsp";
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("userinfo");
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
				session.setAttribute("userinfo", memberDto);
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
		memberDto.setQuestion(request.getParameter("question"));
		memberDto.setAnswer(request.getParameter("answer"));

		try {
			if (memberService.join(memberDto) == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("duplicateMsg", "아이디 중복!!");
				return "/inner-page.jsp";
			}
			return "/user?action=mvlogin";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

}

//	private void findPwSendEmail(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			memberService.findPwSendEmail(request.getParameter("email"));
//			System.out.println("aag");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// 비밀번호 인증코드 인증
//	public void authenticate(HttpServletRequest request, HttpServletResponse response) {
//		int result = 0;
//		String inputCode = request.getParameter("inputCode");
//		String code = request.getParameter("code");
//		String id = request.getParameter("id");
//		result = memberService.checkCode(code, inputCode);
//		request.setAttribute("result", result);
//		request.setAttribute("id", id);
//	}
//
//	// 비밀번호 변경
//	public void changepw(HttpServletRequest request, HttpServletResponse response) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		int result = 0;
//		try {
//			System.out.println("변경할 pw:" + pw);
//			result = memberService.changePw(pw, id);
//			System.out.println("변경 완료");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("변경 실패");
//		}
//		request.setAttribute("result", result);
//	}
