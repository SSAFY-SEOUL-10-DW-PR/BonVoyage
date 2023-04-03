package com.enjoytrip.route.model.service;

import com.enjoytrip.route.model.RouteDto;
import com.enjoytrip.route.model.dao.RouteDao;

public class RouteServiceImpl implements RouteService {
	
	private static RouteService memberService = new RouteServiceImpl();
	private RouteDao routeDao;
	@Override
	public RouteDto getRouteByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int modifyRoute(RouteDto routedto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int createRoute(RouteDto routedto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteRoute(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
