package com.enjoytrip.review.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReviewServiceImpl implements ReviewService {
	
	private static ReviewService ReviewService = new ReviewServiceImpl();
	private ReviewDao ReviewDao;
	
	private ReviewServiceImpl() {
		ReviewDao = ReviewDaoImpl.getReviewDao();
	}

	public static ReviewService getReviewService() {
		return ReviewService;
	}

	@Override
	public void writeArticle(ReviewDto ReviewDto) throws Exception {
		ReviewDao.writeArticle(ReviewDto);
	}

	@Override
	public List<ReviewDto> listArticle(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
//		if("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
		int pgno = Integer.parseInt(map.get("pgno"));
		int start = pgno * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		return ReviewDao.listArticle(param);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
//		if ("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
		int totalCount = ReviewDao.getTotalArticleCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public ReviewDto getArticle(int articleNo) throws Exception {
		return ReviewDao.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		ReviewDao.updateHit(articleNo);
	}

	@Override
	public void modifyArticle(ReviewDto ReviewDto) throws Exception {
		// TODO : ReviewDaoImpl의 modifyArticle 호출
		
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		// TODO : ReviewDaoImpl의 deleteArticle 호출
		
	}

}
