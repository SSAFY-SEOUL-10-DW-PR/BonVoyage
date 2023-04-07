package com.enjoytrip.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enjoytrip.attraction.model.AttractionDto;
import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.util.DBUtil;

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
	public int insert(ReviewDto reviewDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt=0;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into review (user_id, content_id, content_type_id, review_content,location) \n");
			sql.append("values (?, ?, ?, ?,?) on duplicate key update review_content=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, reviewDto.getUserId());
			pstmt.setInt(2, reviewDto.getContentId());
			pstmt.setInt(3, reviewDto.getContentTypeId());
			pstmt.setString(4, reviewDto.getReviewContent());
			pstmt.setString(5, reviewDto.getLocation());
			pstmt.setString(6, reviewDto.getReviewContent());
			cnt=pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int update(ReviewDto reviewDto) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		int cnt=0;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("update review set content=? where review_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, reviewDto.getReviewContent());
			pstmt.setInt(2,reviewDto.getReviewId());
			cnt=pstmt.executeUpdate();
		} finally {
			// TODO: handle exception
			dbUtil.close(pstmt,conn);
		}
		return cnt;
	}
	
	@Override
	public ReviewDto selectById(int reviewId) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ReviewDto reviewDto=null;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("select review_id, user_id, content_id, content_type_id, review_content, location from review where review_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				reviewDto=new ReviewDto(); 
				reviewDto.setReviewId(rs.getInt("review_id"));
				reviewDto.setUserId(rs.getString("user_id"));
				reviewDto.setContentId(rs.getInt("content_id"));
				reviewDto.setContentTypeId(rs.getInt("content_type_id"));
				reviewDto.setReviewContent(rs.getString("review_content"));
			}
		} finally {
			// TODO: handle exception
			dbUtil.close(rs,pstmt,conn);
		}
		return reviewDto;
	}
	@Override
	public List<ReviewDto> selectByAttraction(int attractionId) throws SQLException {
	
				Connection conn= null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				List<ReviewDto> reviewList= new ArrayList<ReviewDto>();
				try {
					conn=dbUtil.getConnection();
					StringBuilder sql= new StringBuilder();
					sql.append("select review_id, user_id, content_id, content_type_id, review_content, location from review where content_id=?");
					pstmt=conn.prepareStatement(sql.toString());
					pstmt.setInt(1, attractionId);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						ReviewDto reviewDto=new ReviewDto(); 
						reviewDto.setReviewId(rs.getInt("review_id"));
						reviewDto.setUserId(rs.getString("user_id"));
						reviewDto.setContentId(rs.getInt("content_id"));
						reviewDto.setContentTypeId(rs.getInt("content_type_id"));
						reviewDto.setReviewContent(rs.getString("review_content"));
						reviewList.add(reviewDto);
					}
				} finally {
					// TODO: handle exception
					dbUtil.close(rs,pstmt,conn);
				}
				return reviewList;
	}

	@Override
	public List<ReviewDto> selectByUser(String userId) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ReviewDto> reviewList= new ArrayList<ReviewDto>();
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("select review_id, user_id, content_id, content_type_id, review_content, location, write_date from review where user_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ReviewDto reviewDto=new ReviewDto(); 
				reviewDto.setReviewId(rs.getInt("review_id"));
				reviewDto.setUserId(rs.getString("user_id"));
				reviewDto.setContentId(rs.getInt("content_id"));
				reviewDto.setContentTypeId(rs.getInt("content_type_id"));
				reviewDto.setReviewContent(rs.getString("review_content"));
				reviewDto.setWriteDate(rs.getString("write_date"));
				reviewDto.setLocation(rs.getString("location"));
				reviewList.add(reviewDto);
			}
		} finally {
			// TODO: handle exception
			dbUtil.close(rs,pstmt,conn);
		}
		return reviewList;
	}


	@Override
	public int delete(int reviewId) throws SQLException {
	Connection conn= null;
	PreparedStatement pstmt=null;
	int cnt=0;
	try {
		conn=dbUtil.getConnection();
		StringBuilder sql= new StringBuilder();
		sql.append("delete from review where review_id=?");
		pstmt=conn.prepareStatement(sql.toString());
		pstmt.setInt(1, reviewId);
		cnt=pstmt.executeUpdate();
	} finally {
		// TODO: handle exception
		dbUtil.close(pstmt,conn);
	}
	return cnt;
		
	}




}
