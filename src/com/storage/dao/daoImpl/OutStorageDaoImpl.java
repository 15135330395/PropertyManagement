package com.storage.dao.daoImpl;


import com.storage.dao.OutStorageDao;
import com.storage.entity.OutStorage;
import com.storage.util.DateUtil;
import com.storage.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:18
 * Description: No Description
 */
public class OutStorageDaoImpl implements OutStorageDao {
    @Override
    public List<OutStorage> findAll() {
        List<OutStorage> list = new ArrayList<>();
        String sql="select * from outstorage order by date DESC";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String goodName= rs.getString("good_name");
                int numbers = rs.getInt("numbers");
                int date = rs.getInt("date");
                String strDate = DateUtil.timeStampToString(date);
                OutStorage diaoBo =  new OutStorage(id,goodName,numbers,strDate);
                list.add(diaoBo);
            }
            return list;
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
            JdbcUtils.close();
        }
        return null;
    }

//    @Override
//    public int update(OutStorage outStorage) {
//        return 0;
//    }

    @Override
    public List<OutStorage> findOne(int id, String goodName) {
        List<OutStorage> list = new ArrayList<>();
        String sql="SELECT * FROM outstorage WHERE id=? AND good_name =?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,goodName);
            rs = ps.executeQuery();
            while (rs.next()){
                int numbers = rs.getInt("numbers");
                int date = rs.getInt("date");
                String strDate = DateUtil.timeStampToString(date);
                OutStorage outStorage =  new OutStorage(id,goodName,numbers,strDate);
                list.add(outStorage);
            }
            return list;
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
            JdbcUtils.close();
        }
        return null;
    }

//    @Override
//    public int deleteById(int id) {
//        return 0;
//    }

    @Override
    public int add(OutStorage outStorage) {
        String sql="insert into outstorage(id,good_name,numbers,date) values (?,?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,outStorage.getId());
            ps.setString(2,outStorage.getGoodName());
            ps.setInt(3,outStorage.getNumbers());
            String date = outStorage.getDate();
            int timeStamp = DateUtil.stringToTimeStamp(date);
            ps.setInt(4,timeStamp);
            int i = ps.executeUpdate();
            return i;
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
            JdbcUtils.close();
        }
        return 0;
    }

    @Override
    public List<OutStorage> queryLimitDate(String startDate, String endDate) {
        int startStamp = DateUtil.stringToTimeStamp(startDate);
        int endStamp = DateUtil.stringToTimeStamp(endDate);
        List<OutStorage> list = new ArrayList<>();
        String sql="select * from outstorage where date between ? and ? order by date DESC;";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,startStamp);
            ps.setInt(2,endStamp);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String goodName = rs.getString("good_name");
                int numbers = rs.getInt("numbers");
                int date = rs.getInt("date");
                String strDate = DateUtil.timeStampToString(date);
                OutStorage outStorage = new OutStorage(id, goodName, numbers, strDate);
                list.add(outStorage);
            }
            return list;
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
            JdbcUtils.close();
        }
        return null;
    }
}
