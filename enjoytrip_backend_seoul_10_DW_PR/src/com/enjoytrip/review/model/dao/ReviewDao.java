package com.enjoytrip.review.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.enjoytrip.review.model.ReviewDto;
;

public interface ReviewDao {

	int insert(ReviewDto reviewDto) throws SQLException;
	List<ReviewDto> selectByAttraction(int attractionId) throws SQLException;
	List<ReviewDto> selectByUser(String userId) throws SQLException;
	ReviewDto selectById(int ReviewId) throws SQLException;
	int update(ReviewDto reviewDto) throws SQLException;
	int delete(int reviewId) throws SQLException;
	
}
