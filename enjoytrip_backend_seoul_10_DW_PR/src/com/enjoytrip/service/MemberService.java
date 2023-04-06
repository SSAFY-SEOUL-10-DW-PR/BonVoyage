package com.enjoytrip.service;

import java.sql.SQLException;

import com.enjoytrip.model.MemberDto;

public interface MemberService {

	MemberDto login(String user_id, String user_pwd) throws Exception;
	void join(MemberDto memberDto) throws Exception;
	MemberDto findID(String user_id) throws Exception;
	int changePw(String pw, String id) throws SQLException;
	
	String findPwSendEmail(String to) throws Exception;
	int checkCode(String code, String inputCode);
}
