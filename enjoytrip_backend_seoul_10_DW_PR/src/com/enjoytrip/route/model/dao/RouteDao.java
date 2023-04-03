package com.enjoytrip.route.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.enjoytrip.route.model.RouteDto;



public interface RouteDao {

	void insertOrUpdateRoute(RouteDto routeDto) throws SQLException;
	RouteDto selectRouteById(int routeId) throws SQLException;
	void deleteRouteById(int routeId) throws SQLException;
	
}
