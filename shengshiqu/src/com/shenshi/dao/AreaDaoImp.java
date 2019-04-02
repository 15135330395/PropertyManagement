package com.shenshi.dao;

import com.shenshi.model.Area;
import com.shenshi.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//  数据业务处理，持久化操作
public class AreaDaoImp implements AreaDao {
	
	@Override
	public List<Area> getAreaByParentno(int id) {
		String sql=null;
			if(id!=0){
				sql="select * from city where "+"id!="+id + " and parent_id="+id;//市、县、区
			}else
			sql="select * from city where parent_id="+id;//省、
		Connection conn=JDBCUtil.getConnection();//获取JDBC工具类中的连接数据库的方法
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Area> list=new ArrayList<Area>();
		try {
			ps=conn.prepareStatement(sql);//对sql语句进行预编译
			rs=ps.executeQuery();
			while(rs.next()){
				Area area=new Area();
				area.setName(rs.getString("name"));
				area.setId(rs.getInt("id"));
				list.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps, rs);
		}
		return list;
	}
}
