package com.enjoytrip.route.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enjoytrip.attraction.model.AttractionDto;
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
	public int insert(RouteDto routeDto) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		int cnt=0;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("insert into route(user_id, route_info) values(?, ?) on duplicate key update route_info=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, routeDto.getUserId());
			pstmt.setString(2, routeDto.getRouteInfoToString());
			pstmt.setString(3, routeDto.getRouteInfoToString());
			cnt=pstmt.executeUpdate();
		} finally {
			// TODO: handle exception
			dbUtil.close(pstmt,conn);
		}
		return cnt;
	}
	

	@Override
	public int update(RouteDto routeDto) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		int cnt=0;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("update route set route_info=? where route_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, routeDto.getRouteInfoToString());
			pstmt.setInt(2,routeDto.getRouteId());
			cnt=pstmt.executeUpdate();
		} finally {
			// TODO: handle exception
			dbUtil.close(pstmt,conn);
		}
		return cnt;
	}

	
	@Override
	public RouteDto selectById(int routeId) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		RouteDto routeDto=null;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("select route_id, user_id, route_info from route where route_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, routeId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				routeDto=new RouteDto(); 
				routeDto.setRouteId(rs.getInt("route_id"));
				routeDto.setUserId(rs.getString("user_id"));
				String[]routes=rs.getString("route_info").split("/");
				List<AttractionDto> routeInfoList=new ArrayList<>();
				for(int i=0;i<routes.length;i++) {
					String[] routeElement=routes[i].split(",");
					routeInfoList.add(new AttractionDto(Integer.parseInt(routeElement[0]),Integer.parseInt(routeElement[1]),routeElement[2],Double.parseDouble(routeElement[3]),Double.parseDouble(routeElement[4])));
				}
				routeDto.setRouteInfo(routeInfoList);
			}
		} finally {
			// TODO: handle exception
			dbUtil.close(rs,pstmt,conn);
		}
		return routeDto;
	}
	
	@Override
	public List<RouteDto> selectRouteByUserId(String userId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<RouteDto> routeList= new ArrayList<RouteDto>();
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("select route_id, user_id, route_info from route where user_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RouteDto routeDto=new RouteDto(); 
				routeDto.setRouteId(rs.getInt("route_id"));
				routeDto.setUserId(rs.getString("user_id"));
				String[]routes=rs.getString("route_info").split("/");
				List<AttractionDto> routeInfoList=new ArrayList<>();
				for(int i=0;i<routes.length;i++) {
					String[] routeElement=routes[i].split(",");
					System.out.println(i);
					System.out.println(routeElement[0]+" "+routeElement[1]+" "+routeElement[2]+" "+routeElement[3]+" "+routeElement[4]);
					routeInfoList.add(new AttractionDto(Integer.parseInt(routeElement[0]),Integer.parseInt(routeElement[1]),routeElement[2],Double.parseDouble(routeElement[3]),Double.parseDouble(routeElement[4])));
				}
				routeDto.setRouteInfo(routeInfoList);
				routeList.add(routeDto);
			}
		} finally {
			// TODO: handle exception
			dbUtil.close(rs,pstmt,conn);
		}
		return routeList;
	}
	



	@Override
	public int deleteRouteByUserId(String userId) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		int cnt=0;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("delete from route where user_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			cnt=pstmt.executeUpdate();
		} finally {
			// TODO: handle exception
			dbUtil.close(pstmt,conn);
		}	
		return cnt;
	}
	
	@Override
	public int deleteRouteById(int routeId) throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		int cnt=0;
		try {
			conn=dbUtil.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append("delete from route where route_id=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, routeId);
			cnt=pstmt.executeUpdate();
		} finally {
			// TODO: handle exception
			dbUtil.close(pstmt,conn);
		}	
		return cnt;
	}

}
