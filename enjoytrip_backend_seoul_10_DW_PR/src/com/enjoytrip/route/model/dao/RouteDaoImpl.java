package com.enjoytrip.route.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enjoytrip.route.model.RouteDto;
import com.enjoytrip.util.DBUtil;



public class RouteDaoImpl implements RouteDao {
	private static RouteDao routeDao;
	private DBUtil dBUtil;
	@Override
	public void insertOrUpdateRoute(RouteDto routeDto) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public RouteDto selectRouteById(int routeId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteRouteById(int routeId) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	


	

}
