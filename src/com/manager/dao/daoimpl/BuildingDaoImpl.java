package com.manager.dao.daoimpl;

import com.manager.dao.BuildingDao;
import com.manager.entity.Building;
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
 */
public class BuildingDaoImpl implements BuildingDao {

    private QueryRunner queryRunner =  new QueryRunner();

    @Override
    public List<Building> findAll() {
        List<Building> list = new ArrayList<>();

        String sql = "select * from building";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Building building = new Building();
                building.setBuildingId(rs.getInt("building_id"));
                building.setBuildingName(rs.getString("building_name"));
                building.setStaffId(rs.getInt("staff_id"));
                building.setAreaId(rs.getInt("area_id"));
                list.add(building);
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
    public Building findBuildingById(int id) {
        Building building = new Building();

        String sql="select b.*,a.area_name,s.staff_name from Building b,area a,staff s " +
                "where b.area_id=a.area_id and b.staff_id=s.staff_id and building_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                building.setBuildingId(rs.getInt("building_id"));
                building.setBuildingName(rs.getString("building_name"));
                building.setStaffId(rs.getInt("staff_id"));
                building.setStaffName(rs.getString("staff_name"));
                building.setAreaId(rs.getInt("area_id"));
                building.setAreaName(rs.getString("area_name"));
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
        return building;
    }

    @Override
    public int addBuilding(Building building) {
//        System.out.println(building.getBuildingName());

        String sql="insert into property_management.building (building_name,staff_id,area_id) values (?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, building.getBuildingName() ,building.getStaffId(),building.getAreaId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteBuilding(int id) {
        String sql="delete from building where building_id = ? ";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateBuilding(Building building) {
        String sql="update building set building_name=?,staff_id=?,area_id=? where building_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, building.getBuildingName(),building.getStaffId(),building.getAreaId(), building.getBuildingId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int findBuildingCountByArea(int areaId) {
        String sql = "select count(*) count from building where area_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,areaId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("count");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return 0;
    }
}
