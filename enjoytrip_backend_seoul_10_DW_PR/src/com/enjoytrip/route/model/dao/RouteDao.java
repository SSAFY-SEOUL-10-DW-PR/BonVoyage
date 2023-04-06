package com.enjoytrip.route.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.enjoytrip.route.model.RouteDto;



public interface RouteDao {

	int insert(RouteDto routeDto) throws SQLException;
	int update(RouteDto routeDto) throws SQLException;
	RouteDto selectById(int routeId) throws SQLException;
	List<RouteDto> selectRouteByUserId(String userId) throws SQLException;
	int deleteRouteByUserId(String userId) throws SQLException;
	int deleteRouteById(int routeId)throws SQLException;
	
}
