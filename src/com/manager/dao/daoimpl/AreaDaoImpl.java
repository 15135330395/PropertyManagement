package com.manager.dao.daoimpl;

import com.entity.PageBean;
import com.manager.dao.AreaDao;
import com.manager.entity.Area;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/26
 *   对管理区域实现增删改查
 */
public class AreaDaoImpl implements AreaDao {

    private QueryRunner queryRunner =  new QueryRunner();

    @Override
    public List<Area> findAll() {
        List<Area> list = new ArrayList<>();

        String sql = "select * from area";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Area area = new Area();
                int areaId = rs.getInt("area_id");
                String areaName = rs.getString("area_name");
                area.setAreaId(areaId);
                area.setAreaName(areaName);
                list.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }else if(ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return list;
    }

    @Override
    public Area findAreaById(int id) {
        Area area =  new Area();
        String sql="select * from area where area_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int areaId = rs.getInt("area_id");
                String areaName = rs.getString("area_name");
                area.setAreaId(areaId);
                area.setAreaName(areaName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return area;
    }

    @Override
    public int addArea(Area area) {
//        System.out.println(area.getAreaName());
        String sql="insert into area (area_name) values (?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, area.getAreaName());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteArea(int id) {
        String sql="delete from area where area_id = ? ";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateArea(Area area) {
        String sql="update area set area_name=? where  area_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, area.getAreaName(), area.getAreaId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Area> queryByPage(PageBean pageBean) {
        List<Area> list = new ArrayList<>();

        String sql="select * from area limit ?,?  ";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                int areaId = rs.getInt("area_id");
                String areaName = rs.getString("area_name");

                Area area =  new Area();
                area.setAreaId(areaId);
                area.setAreaName(areaName);
                list.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return list;
    }
}
