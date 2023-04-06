package com.enjoytrip.review.model.service;


import java.util.List;
import java.util.Map;

import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.route.model.RouteDto;

public interface ReviewService {

	int createReview(ReviewDto reviewDto) throws Exception;
	List<ReviewDto> getReviewByAttraction(int attractionId) throws Exception;
	List<ReviewDto> getReviewByUser(String userId) throws Exception;
	ReviewDto getReviewByID(int ReviewId) throws Exception;
	int modifyReview(ReviewDto reviewDto) throws Exception;
	int deleteReview(int reviewId) throws Exception;
	
}
