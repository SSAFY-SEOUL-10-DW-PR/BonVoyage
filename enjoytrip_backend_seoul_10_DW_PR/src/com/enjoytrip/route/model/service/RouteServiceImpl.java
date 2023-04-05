package com.enjoytrip.route.model.service;

import java.util.List;

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
	public int modifyRoute(RouteDto routeDto) throws Exception {
		return routeDao.update(routeDto);
	}
	@Override
	public int createRoute(RouteDto routeDto) throws Exception {
		// TODO Auto-generated method stub
		return routeDao.insert(routeDto);
	}


	@Override
	public List<RouteDto> getRouteByUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return routeDao.selectRouteByUserId(userId);
	}

	@Override
	public RouteDto getRouteById(int routeId) throws Exception {
		return routeDao.selectById(routeId);
	}

	@Override
	public int deleteRouteByUser(String userId) throws Exception {
		return routeDao.deleteRouteByUserId(userId);
	}

	@Override
	public int deleteRouteById(int routeId) throws Exception {
		return routeDao.deleteRouteById(routeId);
	}


}
