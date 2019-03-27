package com.manager.dao.daoimpl;

import com.manager.dao.HouseDao;
import com.manager.entity.House;
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
public class HouseDaoImpl implements HouseDao {

    private QueryRunner queryRunner =  new QueryRunner();

    @Override
    public List<House> findAll() {
        List<House> list = new ArrayList<>();

        String sql = "select * from house";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                House house = new House();
                house.setHouseId(rs.getInt("house_id"));
                house.setBuildingId(rs.getInt("building_id"));
                house.setAcreage(rs.getString("acreage"));
                house.setUes(rs.getString("use"));
                house.setHouseType(rs.getString("house_type"));
                list.add(house);
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
    public House findHouseById(int id) {
        House house = new House();
        String sql="select * from House where house_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                house.setHouseId(rs.getInt("house_id"));
                house.setBuildingId(rs.getInt("building_id"));
                house.setAcreage(rs.getString("acreage"));
                house.setUes(rs.getString("use"));
                house.setHouseType(rs.getString("house_type"));
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
        return house;
    }

    @Override
    public int addHouse(House house) {
        String sql="insert into property_management.house (building_id,acreage,use,house_type) values (?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, house.getBuildingId() ,house.getAcreage(),house.getUes(),house.getHouseType());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteHouse(int id) {
        String sql="delete from house where house_id = ? ";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateHouse(House house) {
        String sql="update house set house_name=?,acreage=?,use=?,house_type=? where house_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, house.getBuildingId() ,house.getAcreage(),house.getUes(),house.getHouseType(), house.getHouseId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
