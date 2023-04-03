package com.enjoytrip.route.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.enjoytrip.route.model.RouteDto;



public interface RouteDao {

	void insertRoute(RouteDto routeDto) throws SQLException;
	RouteDto selectRouteByUserId(String userId) throws SQLException;
	void deleteRouteByUserId(String userId) throws SQLException;
	
}
