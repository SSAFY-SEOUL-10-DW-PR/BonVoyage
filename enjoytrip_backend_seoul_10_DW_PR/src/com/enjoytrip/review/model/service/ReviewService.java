package com.enjoytrip.review.model.service;

import java.util.List;
import java.util.Map;

public interface ReviewService {

	void writeArticle(ReviewDto ReviewDto) throws Exception;
	List<ReviewDto> listArticle(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	ReviewDto getArticle(int articleNo) throws Exception;
	void updateHit(int articleNo) throws Exception;
	
	void modifyArticle(ReviewDto ReviewDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
	
}
