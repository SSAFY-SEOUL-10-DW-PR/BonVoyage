package com.enjoytrip.service;

import com.enjoytrip.model.MemberDto;

public interface MemberService {

	MemberDto login(String id, String pw) throws Exception;
	
}
