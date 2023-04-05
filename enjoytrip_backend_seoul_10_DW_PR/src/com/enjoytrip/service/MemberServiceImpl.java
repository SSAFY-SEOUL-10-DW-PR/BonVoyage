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
	public MemberDto login(String user_id, String user_pwd) throws Exception {
		return memberDao.login(user_id, user_pwd);
	}

	@Override
	public void join(MemberDto memberDto) throws Exception {
		memberDao.join(memberDto);
	}

}
