package com.enjoytrip.dao;

import java.sql.SQLException;

import com.enjoytrip.model.MemberDto;

public interface MemberDao {

	MemberDto login(String id, String pw) throws SQLException;
	
}
