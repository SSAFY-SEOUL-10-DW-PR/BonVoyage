package com.enjoytrip.review.model;

import java.util.Date;

public class ReviewDto {
	
	private int reviewId;
	private 	String userId;
	private int contentId;
	private int contentTypeId;
	private String reviewContent;
	private String location;
private String writeDate;
	public int getReviewId() {
		return reviewId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String string) {
		this.writeDate = string;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public ReviewDto(int reviewId, String userId, int contentId, int contentTypeId, String reviewContent) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.reviewContent = reviewContent;
	}
	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
