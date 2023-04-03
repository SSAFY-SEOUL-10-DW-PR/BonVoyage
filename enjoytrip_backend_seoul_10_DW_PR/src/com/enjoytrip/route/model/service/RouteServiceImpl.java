package com.enjoytrip.route.model.service;

import com.enjoytrip.route.model.RouteDto;
import com.enjoytrip.route.model.dao.RouteDao;
import com.enjoytrip.route.model.dao.RouteDaoImpl;

public class RouteServiceImpl implements RouteService {
	
	private static RouteService routeService = new RouteServiceImpl();
	private RouteDao routeDao;
	
	private RouteServiceImpl() {
		routeDao = RouteDaoImpl.getRouteDao();
	}
	
	public static RouteService getRouteService() {
		return routeService;
	}
	
	@Override
	public RouteDto getRouteByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return routeDao.selectRouteByUserId(userId);
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
