package com.enjoytrip.service;

import java.sql.SQLException;

import com.enjoytrip.model.MemberDto;

public interface MemberService {

	MemberDto login(String user_id, String user_pwd) throws Exception;
	void join(MemberDto memberDto) throws Exception;
	MemberDto findID(String user_id) throws Exception;
	int changePw(String pw, String id) throws Exception;
	MemberDto findMemberInfo(String userId) throws Exception;
	String findPwSendEmail(String to) throws Exception;
	int checkCode(String code, String inputCode);
	void modify(MemberDto memberDto) throws Exception;
	void delete(MemberDto memberDto) throws Exception;
}
