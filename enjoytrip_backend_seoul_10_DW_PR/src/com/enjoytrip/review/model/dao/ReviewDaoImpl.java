package com.enjoytrip.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewDaoImpl implements ReviewDao {
	
	private static ReviewDao ReviewDao;
	private DBUtil dbUtil;
	
	private ReviewDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static ReviewDao getReviewDao() {
		if(ReviewDao == null)
			ReviewDao = new ReviewDaoImpl();
		return ReviewDao;
	}

	@Override
	public void writeArticle(ReviewDto ReviewDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into Review (user_id, subject, content) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, ReviewDto.getUserId());
			pstmt.setString(2, ReviewDto.getSubject());
			pstmt.setString(3, ReviewDto.getContent());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<ReviewDto> listArticle(Map<String, Object> param) throws SQLException {
		List<ReviewDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select article_no, user_id, subject, content, hit, register_time \n");
			sql.append("from Review \n");
			String key = (String) param.get("key");
			String word = (String) param.get("word");
			if(!key.isEmpty() && !word.isEmpty()) {
				if("subject".equals(key)) {
					sql.append("where subject like concat('%', ?, '%') \n");
				} else {
					sql.append("where ").append(key).append(" = ? \n");
				}
			}
			sql.append("order by article_no desc \n");
			sql.append("limit ?, ?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if(!key.isEmpty() && !word.isEmpty())
				pstmt.setString(++idx, word);
			pstmt.setInt(++idx, (Integer) param.get("start"));
			pstmt.setInt(++idx, (Integer) param.get("listsize"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDto ReviewDto = new ReviewDto();
				ReviewDto.setArticleNo(rs.getInt("article_no"));
				ReviewDto.setUserId(rs.getString("user_id"));
				ReviewDto.setSubject(rs.getString("subject"));
				ReviewDto.setContent(rs.getString("content"));
				ReviewDto.setHit(rs.getInt("hit"));
				ReviewDto.setRegisterTime(rs.getString("register_time"));
				
				list.add(ReviewDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	@Override
	public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(article_no) \n");
			sql.append("from Review \n");
			String key = (String) param.get("key");
			String word = (String) param.get("word");
			if(!key.isEmpty() && !word.isEmpty()) {
				if("subject".equals(key)) {
					sql.append("where subject like concat('%', ?, '%') \n");
				} else {
					sql.append("where ").append(key).append(" = ? \n");
				}
			}
			pstmt = conn.prepareStatement(sql.toString());
			if(!key.isEmpty() && !word.isEmpty())
				pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return cnt;
	}

	@Override
	public ReviewDto getArticle(int articleNo) throws SQLException {
		ReviewDto ReviewDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select article_no, user_id, subject, content, hit, register_time \n");
			sql.append("from Review \n");
			sql.append("where article_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ReviewDto = new ReviewDto();
				ReviewDto.setArticleNo(rs.getInt("article_no"));
				ReviewDto.setUserId(rs.getString("user_id"));
				ReviewDto.setSubject(rs.getString("subject"));
				ReviewDto.setContent(rs.getString("content"));
				ReviewDto.setHit(rs.getInt("hit"));
				ReviewDto.setRegisterTime(rs.getString("register_time"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return ReviewDto;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update Review \n");
			sql.append("set hit = hit + 1 \n");
			sql.append("where article_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}	
	}

	@Override
	public void modifyArticle(ReviewDto ReviewDto) throws SQLException {
		// TODO : 글번호에 해당하는 제목과 내용 변경.
		
	}

	@Override
	public void deleteArticle(int articleNO) throws SQLException {
		// TODO : 글번호에 해당하는 글삭제
		
	}

}
