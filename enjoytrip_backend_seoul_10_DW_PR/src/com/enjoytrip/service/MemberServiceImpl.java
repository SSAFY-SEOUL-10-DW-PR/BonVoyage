package com.enjoytrip.service;

import java.sql.SQLException;

import com.enjoytrip.dao.MemberDao;
import com.enjoytrip.dao.MemberDaoImpl;
import com.enjoytrip.model.ForgetPasswordEmail;
import com.enjoytrip.model.MemberDto;

public class MemberServiceImpl implements MemberService {

	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;

	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}

	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public MemberDto login(String user_id, String user_pwd) throws Exception {
		return memberDao.login(user_id, user_pwd);
	}

	@Override
	public void join(MemberDto memberDto) throws Exception {
		memberDao.join(memberDto);
	}
	
	// 비밀번호 찾기 인증 코드 보내기
	public String findPwSendEmail(String to) throws Exception {
		ForgetPasswordEmail email = new ForgetPasswordEmail();
		return email.sendEmail(to);
	}

	// 비밀번호 인증코드 체크
	@Override
	public int checkCode(String code, String inputCode) {
		int result = 0;
		if (code.equals(inputCode)) {
			System.out.println("인증 성공");
			return result = 1;
		} else {
			System.out.println("인증 실패");
			return result = 0;
		}
	}

	// 비밀번호 변경
	@Override
	public int changePw(String pw, String id) throws SQLException {
		return memberDao.updatePw(pw, id);
	}

	@Override
	public MemberDto findID(String user_id) throws Exception {
		return memberDao.findID(user_id);
	}
}
