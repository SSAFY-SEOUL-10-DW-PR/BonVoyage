package com.enjoytrip.service;

import com.enjoytrip.dao.MemberDao;
import com.enjoytrip.dao.MemberDaoImpl;
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
	public MemberDto login(String id, String pw) throws Exception {
		return memberDao.login(id, pw);
	}

}
