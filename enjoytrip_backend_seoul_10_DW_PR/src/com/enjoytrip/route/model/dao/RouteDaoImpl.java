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
	private DBUtil dbUtil;
	
	private RouteDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static RouteDao getRouteDao() {
		if(routeDao == null)
			routeDao = new RouteDaoImpl();
		return routeDao;
	}



	@Override
	public RouteDto selectRouteByUserId(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteRouteByUserId(String userId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pstmt=null;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("delete from route where user_id=?");
			pstmt.setString(1, userId);
		} finally {
			// TODO: handle exception
			dbUtil.close(pstmt,conn);
		}	
	}

	@Override
	public void insertRoute(RouteDto routeDto) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pstmt=null;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("insert into route(user_id, route_info) values(?, ?) on duplicate key update route_info=?");
			pstmt.setString(1, routeDto.getuserId());
			pstmt.setString(2, routeDto.getRouteInfoToString());
			pstmt.setString(3, routeDto.getRouteInfoToString());
		} finally {
			// TODO: handle exception
			dbUtil.close(pstmt,conn);
		}
	}

	

	


	

}
