package com.enjoytrip.controller;

import java.io.IOException;
import java.net.URLEncoder;
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

import com.enjoytrip.model.BoardDto;
import com.enjoytrip.service.BoardService;
import com.enjoytrip.service.BoardServiceImpl;
import com.enjoytrip.model.MemberDto;
import com.enjoytrip.util.PageNavigation;
import com.enjoytrip.util.ParameterCheck;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int pgno;
	private String key;
	private String word;
	private String queryStrig;
	
	private BoardService boardService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		boardService = BoardServiceImpl.getBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		pgno = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		key = ParameterCheck.nullToBlank(request.getParameter("key"));
		word = ParameterCheck.nullToBlank(request.getParameter("word"));
		queryStrig = "?pgno=" + pgno + "&key=" + key + "&word=" + URLEncoder.encode(word, "utf-8");

		String path = "";
		if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if ("mvwrite".equals(action)) {
			path = "/community-write.jsp";
			redirect(request, response, path);
		} else if ("write".equals(action)) {
			path = write(request, response);
//			redirect(request, response, path);
			forward(request, response, path);
		} else if ("mvmodify".equals(action)) {
			path = mvModify(request, response);
			forward(request, response, path);
		} else if ("modify".equals(action)) {
			path = modify(request, response);
			forward(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} 
//		else if ("search".equals(action)) {
//			path = search(request, response);
//			redirect(request, response, path);
//		} 
		else {
			redirect(request, response, path);
		}
	}
	

//	private String search(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		if (memberDto != null) {
//			try {
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("pgno", pgno + "");
//				map.put("key", key);
//				map.put("word", word);
//				
//				List<BoardDto> list = boardService.searchArticle(map);
//				request.setAttribute("articles", list);
//				
//				PageNavigation pageNavigation = boardService.makePageNavigation(map);
//				request.setAttribute("navigation", pageNavigation);
//
//				return "/community-list.jsp" + queryStrig;
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("msg", "글목록 출력 중 문제 발생!!!");
//				return "/error/error.jsp";
//			}
//		} else
//			return "/inner-page.jsp";
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			try {
				Map<String, String> map = new HashMap<String, String>();
				map.put("pgno", pgno + "");
				map.put("key", key);
				map.put("word", word);
				
				List<BoardDto> list = boardService.listArticle(map);
				request.setAttribute("articles", list);
				
				PageNavigation pageNavigation = boardService.makePageNavigation(map);
				request.setAttribute("navigation", pageNavigation);

				return "/community-list.jsp" + queryStrig;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글목록 출력 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/inner-page.jsp";
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			int articleNo = Integer.parseInt(request.getParameter("articleno"));
			try {
				BoardDto boardDto = boardService.getArticle(articleNo);
				boardService.updateHit(articleNo);
				request.setAttribute("article", boardDto);

				return "/community-view.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글내용 출력 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/inner-page.jsp";
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			BoardDto boardDto = new BoardDto();
			boardDto.setUserId(memberDto.getId());
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
//			boardDto.setRegisterTime("now()");
			try {
				boardService.writeArticle(boardDto);
				return "/board?action=list";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/inner-page.jsp";
	}

	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정하고자하는 글의 글번호를 얻는다.
		// TODO : 글번호에 해당하는 글정보를 얻고 글정보를 가지고 modify.jsp로 이동.
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			int articleNo = Integer.parseInt(request.getParameter("articleno"));
			try {
				BoardDto boardDto = boardService.getArticle(articleNo);
				request.setAttribute("article", boardDto);

				return "/community-edit.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 수정 페이지 이동 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/inner-page.jsp";
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정 할 글정보를 얻고 BoardDto에 set.
		// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
		// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		if (memberDto != null) {
			BoardDto boardDto = new BoardDto();
			boardDto.setArticleNo(articleNo);
			boardDto.setSubject(request.getParameter("subject"));
			boardDto.setContent(request.getParameter("content"));
			try {
				boardService.modifyArticle(boardDto);
				request.setAttribute("article", boardDto);
				
				return "/board?action=view&articleno="+articleNo;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글내용 수정 중 문제 발생!!!");
				return "/error/error.jsp";
			}
		} else
			return "/inner-page.jsp";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 삭제할 글 번호를 얻는다.
		// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
		// TODO : 글삭제 완료 후 list.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		try {
			boardService.deleteArticle(articleNo);
			return "/board?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

}
