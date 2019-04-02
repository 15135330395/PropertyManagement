package com.storage.dao.daoImpl;


import com.storage.dao.DiaoBoDao;
import com.storage.entity.DiaoBo;
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
 * Time: 15:17
 * Description: No Description
 */
public class DiaoBoDaoImpl implements DiaoBoDao {
    @Override
    public List<DiaoBo> findAll() {
        List<DiaoBo> list = new ArrayList<>();
        String sql="select * from diaobo order by date DESC";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int outStorage = rs.getInt("out_storage");
                int inStorage = rs.getInt("in_storage");
                String goodName = rs.getString("good_name");
                int numbers = rs.getInt("numbers");
                int date = rs.getInt("date");
                String strdate = DateUtil.timeStampToString(date);
                DiaoBo diaoBo =  new DiaoBo(outStorage,inStorage,goodName,numbers,strdate);
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
//    public int update(DiaoBo diaoBo) {
//        String sql="update diaobo set numbers=? where good_name=? and id=?;";
//        Connection conn = JdbcUtils.getConnection();
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1,goods.getNumbers());
//            ps.setString(2,goods.getGoodName());
//            ps.setInt(3,goods.getId());
//            int i = ps.executeUpdate();
//            return i;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }

    @Override
    public List<DiaoBo> findOne(String goodName) {
        List<DiaoBo> list = new ArrayList<>();
        String sql="select * from diaobo where good_name=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,goodName);
            rs = ps.executeQuery();
            while (rs.next()){
                int outStorage = rs.getInt("out_storage");
                int inStorage = rs.getInt("in_storage");
                int numbers = rs.getInt("numbers");
                int date = rs.getInt("date");
                String strDate = DateUtil.timeStampToString(date);
                DiaoBo diaoBo =  new DiaoBo(outStorage,inStorage,goodName,numbers,strDate);
                list.add(diaoBo);
                return list;
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
            JdbcUtils.close();
        }
        return null;
    }

//    @Override
//    public int deleteById(int id) {
//        return 0;
//    }

    @Override
    public int add(DiaoBo diaoBo) {
        String sql="insert into diaobo(out_storage,in_storage,good_name,numbers,date) values (?,?,?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,diaoBo.getOutStorage());
            ps.setInt(2,diaoBo.getInStorage());
            ps.setString(3,diaoBo.getGoodName());
            ps.setInt(4,diaoBo.getNumbers());
            String date = diaoBo.getDate();
            int timeStamp = DateUtil.stringToTimeStamp(date);
            ps.setInt(5,timeStamp);
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
    public List<DiaoBo> queryLimitDate(String startDate, String endDate) {
        int startStamp = DateUtil.stringToTimeStamp(startDate);
        int endStamp = DateUtil.stringToTimeStamp(endDate);
        List<DiaoBo> list = new ArrayList<>();
        String sql="select * from diaobo where date between ? and ? order by date DESC;";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,startStamp);
            ps.setInt(2,endStamp);
            rs = ps.executeQuery();
            while (rs.next()){
                int outStorage = rs.getInt("out_storage");
                int inStorage = rs.getInt("in_storage");
                String goodName = rs.getString("good_name");
                int numbers = rs.getInt("numbers");
                int date = rs.getInt("date");
                String strDate = DateUtil.timeStampToString(date);
                DiaoBo diaoBo =  new DiaoBo(outStorage,inStorage,goodName,numbers,strDate);
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
}
