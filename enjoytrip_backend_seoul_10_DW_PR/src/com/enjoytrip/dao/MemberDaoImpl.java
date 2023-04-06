package com.enjoytrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.enjoytrip.model.BoardDto;
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
			sql.append("select user_id, user_pwd, email, name, birth, phone, question, answer, authorization \n");
			sql.append("from user \n");
			sql.append("where user_id = ? and user_pwd = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("user_id"));
				memberDto.setPw(rs.getString("user_pwd"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setName(rs.getString("name"));
				memberDto.setBirth(rs.getString("birth"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setQuestion(rs.getString("question"));
				memberDto.setAnswer(rs.getString("answer"));
				memberDto.setAuthorization(rs.getString("authorization"));
			}
		} finally {
			dBUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

	@Override
	public void join(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into user (user_id, user_pwd, email, name, birth, phone, question, answer) \n");
			sql.append("values (?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPw());
			pstmt.setString(3, memberDto.getEmail());
			pstmt.setString(4, memberDto.getName());
			pstmt.setString(5, memberDto.getBirth());
			pstmt.setString(6, memberDto.getPhone());
			pstmt.setString(7, memberDto.getQuestion());
			pstmt.setString(8, memberDto.getAnswer());
			pstmt.executeUpdate();
		} finally {
			dBUtil.close(pstmt, conn);
		}
	}

	// update pw
	public int updatePw(String pw, String id) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dBUtil.getConnection();
			pstmt = conn.prepareStatement("update user set user_pwd = ? where user_id = ?");
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} finally {
			dBUtil.close(pstmt, conn);
		}
		return result;
	}

	@Override
	public MemberDto findID(String user_id) throws SQLException {
			MemberDto memberDto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dBUtil.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("select user_id, question, answer \n");
				sql.append("from user \n");
				sql.append("where user_id = ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, user_id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					memberDto = new MemberDto();
					memberDto.setId(rs.getString("user_id"));
					memberDto.setQuestion(rs.getString("question"));
					memberDto.setAnswer(rs.getString("answer"));
				}
			} finally {
				dBUtil.close(rs, pstmt, conn);
			}
			return memberDto;
			
	}

	@Override
	public void modify(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update user set user_pwd = ?, email = ?, name = ?, birth = ?, phone = ?, question = ?, answer = ? \n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getPw());
			pstmt.setString(2, memberDto.getEmail());
			pstmt.setString(3, memberDto.getName());
			pstmt.setString(4, memberDto.getBirth());
			pstmt.setString(5, memberDto.getPhone());
			pstmt.setString(6, memberDto.getQuestion());
			pstmt.setString(7, memberDto.getAnswer());
			pstmt.setString(8, memberDto.getId());
			pstmt.executeUpdate();
		} finally {
			dBUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public void delete(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from user \n");
			sql.append("where user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getId());
			pstmt.executeUpdate();
		} finally {
			dBUtil.close(pstmt, conn);
		}
		
	}

}
