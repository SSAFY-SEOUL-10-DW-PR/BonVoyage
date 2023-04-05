package com.enjoytrip.route.model.service;

import java.util.List;

import com.enjoytrip.route.model.RouteDto;

public interface RouteService {

	List<RouteDto> getRouteByUser(String userId) throws Exception;
	RouteDto getRouteById(int routeId) throws Exception;
	int modifyRoute(RouteDto routedto) throws Exception;
	int createRoute(RouteDto routedto) throws Exception;
	int deleteRouteByUser(String userId) throws Exception;
	int deleteRouteById(int routeId) throws Exception;
}
