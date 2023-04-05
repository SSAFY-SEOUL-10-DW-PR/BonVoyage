package com.enjoytrip.service;

import com.enjoytrip.model.MemberDto;

public interface MemberService {

	MemberDto login(String user_id, String user_pwd) throws Exception;
	void join(MemberDto memberDto) throws Exception;
	
}
