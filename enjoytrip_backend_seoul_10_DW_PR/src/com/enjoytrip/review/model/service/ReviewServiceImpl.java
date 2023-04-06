package com.enjoytrip.review.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enjoytrip.review.model.ReviewDto;
import com.enjoytrip.review.model.dao.ReviewDao;
import com.enjoytrip.review.model.dao.ReviewDaoImpl;


public class ReviewServiceImpl implements ReviewService {
	
	private static ReviewService reviewService = new ReviewServiceImpl();
	private ReviewDao reviewDao;
	
	private ReviewServiceImpl() {
		reviewDao = ReviewDaoImpl.getReviewDao();
	}

	public static ReviewService getReviewService() {
		return reviewService;
	}

	@Override
	public int createReview(ReviewDto reviewDto) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.insert(reviewDto);
	}

	@Override
	public List<ReviewDto> getReviewByAttraction(int attractionId) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.selectByAttraction(attractionId);
	}

	@Override
	public List<ReviewDto> getReviewByUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.selectByUser(userId);
	}

	@Override
	public ReviewDto getReviewByID(int ReviewId) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.selectById(ReviewId);
	}

	@Override
	public int modifyReview(ReviewDto reviewDto) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.update(reviewDto);
	}

	@Override
	public int deleteReview(int reviewId) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.delete(reviewId);
	}



}
