package com.enjoytrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.enjoytrip.model.MemberDto;
import com.enjoytrip.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dBUtil;
	
	private MemberDaoImpl() {
		dBUtil = DBUtil.getInstance();
	}

	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public MemberDto login(String id, String pw) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_id \n");
			sql.append("from user \n");
			sql.append("where user_id = ? and user_pwd = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("user_id"));
			}
		} finally {
			dBUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

}
