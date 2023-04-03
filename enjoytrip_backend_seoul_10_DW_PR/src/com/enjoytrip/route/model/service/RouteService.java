package com.enjoytrip.route.model.service;

import com.enjoytrip.route.model.RouteDto;

public interface RouteService {

	RouteDto getRouteByUserId(String userId) throws Exception;
	int modifyRoute(RouteDto routedto) throws Exception;
	int createRoute(RouteDto routedto) throws Exception;
	int deleteRoute(String userId) throws Exception;
}
