package com.manager.dao.daoimpl;

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
    public Area findAreaById(int areaId) {
        return null;
    }

    @Override
    public int addArea(Area area) {
        return 0;
    }

    @Override
    public int deleteArea(int id) {
        return 0;
    }

    @Override
    public int updateArea(Area area) {
        return 0;
    }
}
