package com.enjoytrip.dao;

import java.sql.SQLException;

import com.enjoytrip.model.MemberDto;

public interface MemberDao {

	MemberDto login(String user_id, String user_pwd) throws SQLException;
	void join(MemberDto memberDto) throws SQLException;
	int updatePw(String pw, String id) throws SQLException;
	MemberDto findID(String user_id) throws SQLException;
	void modify(MemberDto memberDto) throws SQLException;
	void delete(MemberDto memberDto) throws SQLException;
	MemberDto getUserInfo(String userId) throws SQLException;
}
