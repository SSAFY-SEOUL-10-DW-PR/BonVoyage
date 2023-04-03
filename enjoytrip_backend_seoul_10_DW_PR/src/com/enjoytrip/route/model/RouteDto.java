package com.enjoytrip.route.model;

import java.util.List;

import com.enjoytrip.attraction.model.AttractionDto;

public class RouteDto {
	private int routeId;
	private int userId;
	private List<AttractionDto> route_info;
	
	public RouteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RouteDto(int routeId, int userId, List<AttractionDto> route_info) {
		super();
		this.routeId = routeId;
		this.userId = userId;
		this.route_info = route_info;
	}

	public int getrouteId() {
		return routeId;
	}

	public void setrouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public List<AttractionDto> getRoute_info() {
		return route_info;
	}

	public void setRoute_info(List<AttractionDto> route_info) {
		this.route_info = route_info;
	}
	
	
}
