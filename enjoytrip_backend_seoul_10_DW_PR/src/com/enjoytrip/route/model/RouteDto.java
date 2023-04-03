package com.enjoytrip.route.model;

import java.util.List;

import com.enjoytrip.attraction.model.AttractionDto;

public class RouteDto {
	private int routeId;
	private String userId;
	private List<AttractionDto> routeInfo;
	
	public RouteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RouteDto(int routeId, String userId, List<AttractionDto> routeInfo) {
		super();
		this.routeId = routeId;
		this.userId = userId;
		this.routeInfo = routeInfo;
	}

	public int getrouteId() {
		return routeId;
	}

	public void setrouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public List<AttractionDto> getRouteInfo() {
		return routeInfo;
	}

	public void setRoute_info(List<AttractionDto> routeInfo) {
		this.routeInfo = routeInfo;
	}
	
	public String getRouteInfoToString() {
		StringBuilder sb= new StringBuilder();
		for (AttractionDto attractionDto : routeInfo) {
			sb.append(attractionDto.getRouteElement());
		}
		return sb.toString();
	}
	
	
}
