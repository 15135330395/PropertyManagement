package com.storage.dao.daoImpl;


import com.storage.dao.PurchaseListOrderDao;
import com.storage.entity.PurchaseListOrder;
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
public class PurchaseListOrderDaoImpl implements PurchaseListOrderDao {
    @Override
    public List<PurchaseListOrder> findAll() {
        List<PurchaseListOrder> list = new ArrayList<>();
        String sql="select * from purchaselistorder order by date DESC";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String goodName = rs.getString("good_name");
                int numbers = rs.getInt("numbers");
                int cost = rs.getInt("cost");
                int date = rs.getInt("date");
                String strDate = DateUtil.timeStampToString(date);
                String list_number = rs.getString("list_number");
                PurchaseListOrder purchaseListOrder =  new PurchaseListOrder(id,goodName,numbers,cost,strDate,list_number);
                list.add(purchaseListOrder);
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
//    public int update(PurchaseListOrder purchaseApply) {
//        return 0;
//    }

    @Override
    public List<PurchaseListOrder> findOne(int id, String goodName) {
        List<PurchaseListOrder> list = new ArrayList<>();
        String sql="SELECT * FROM purchaselistorder WHERE id=? AND good_name =?";
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
                int cost = rs.getInt("cost");
                int date = rs.getInt("date");
                String strDate = DateUtil.timeStampToString(date);
                String list_number = rs.getString("list_number");
                PurchaseListOrder purchaseListOrder =  new PurchaseListOrder(id,goodName,numbers,cost,strDate,list_number);
                list.add(purchaseListOrder);
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
//    public int delete(int id, String goodName) {
//        return 0;
//    }

    @Override
    public int add(PurchaseListOrder purchaseListOrder) {
        String sql="insert into purchaselistorder(id,good_name,numbers,cost,date,list_number) values (?,?,?,?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,purchaseListOrder.getId());
            ps.setString(2,purchaseListOrder.getGoodName());
            ps.setInt(3,purchaseListOrder.getNumbers());
            ps.setInt(4,purchaseListOrder.getCost());
            String date = purchaseListOrder.getDate();
            int timeStamp = DateUtil.stringToTimeStamp(date);
            ps.setInt(5,timeStamp);
            ps.setString(6,purchaseListOrder.getListNumber());
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
    public List<PurchaseListOrder> queryLimitDate(String startDate, String endDate) {
        int startStamp = DateUtil.stringToTimeStamp(startDate);
        int endStamp = DateUtil.stringToTimeStamp(endDate);
        List<PurchaseListOrder> list = new ArrayList<>();
        String sql="select * from purchaselistorder where date between ? and ? order by date DESC;";
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
                int cost = rs.getInt("cost");
                int date = rs.getInt("date");
                String listNumber = rs.getString("list_number");
                String strDate = DateUtil.timeStampToString(date);
                PurchaseListOrder purchaseListOrder = new PurchaseListOrder(id, goodName, numbers, cost, strDate, listNumber);
                list.add(purchaseListOrder);
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
