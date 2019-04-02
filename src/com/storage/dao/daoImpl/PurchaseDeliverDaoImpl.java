package com.storage.dao.daoImpl;


import com.storage.dao.PurchaseDeliverDao;
import com.storage.entity.PurchaseDeliver;
import com.storage.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:18
 * Description: No Description
 */
public class PurchaseDeliverDaoImpl implements PurchaseDeliverDao {
    @Override
    public List<PurchaseDeliver> findAll() {
        List<PurchaseDeliver> list = new ArrayList<>();
        String sql="select * from purchasedeliver";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String goodName= rs.getString("good_name");
                String supplier1Name= rs.getString("supplier1_name");
                int supplier1Price = rs.getInt("supplier1_price");
                int supplier1Numbers = rs.getInt("supplier1_numbers");
                String supplier2Name= rs.getString("supplier2_name");
                int supplier2Price = rs.getInt("supplier2_price");
                int supplier2Numbers = rs.getInt("supplier2_numbers");
                int total = rs.getInt("total");
                PurchaseDeliver purchaseDeliver =  new PurchaseDeliver(id,goodName,supplier1Name,supplier1Price,supplier1Numbers,
                        supplier2Name,supplier2Price,supplier2Numbers,total);
                list.add(purchaseDeliver);
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

    @Override
    public int update(PurchaseDeliver purchaseDeliver) {
        String sql="update purchasedeliver set supplier1_name=?,supplier1_price=?,supplier1_numbers=?,supplier2_name=?,supplier2_price=?,supplier2_numbers=?,total=? where good_name=? and id=?;";
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,purchaseDeliver.getSupplier1Name());
            ps.setInt(2,purchaseDeliver.getSupplier1Price());
            ps.setInt(3,purchaseDeliver.getSupplier1Numbers());
            ps.setString(4,purchaseDeliver.getSupplier2Name());
            ps.setInt(5,purchaseDeliver.getSupplier2Price());
            ps.setInt(6,purchaseDeliver.getSupplier2Numbers());
            ps.setInt(7,purchaseDeliver.getTotal());
            ps.setString(8,purchaseDeliver.getGoodName());
            ps.setInt(9,purchaseDeliver.getId());
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public PurchaseDeliver findOne(int id, String goodName) {
        String sql="SELECT * FROM purchasedeliver WHERE id=? AND good_name =?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,goodName);
            rs = ps.executeQuery();
            while (rs.next()){
                String supplier1Name= rs.getString("supplier1_name");
                int supplier1Price = rs.getInt("supplier1_price");
                int supplier1Numbers = rs.getInt("supplier1_numbers");
                String supplier2Name= rs.getString("supplier2_name");
                int supplier2Price = rs.getInt("supplier2_price");
                int supplier2Numbers = rs.getInt("supplier2_numbers");
                int total = rs.getInt("total");
                PurchaseDeliver purchaseDeliver =  new PurchaseDeliver(id,goodName,supplier1Name,supplier1Price,supplier1Numbers,
                        supplier2Name,supplier2Price,supplier2Numbers,total);
                return purchaseDeliver;
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

    @Override
    public int add(PurchaseDeliver purchaseDeliver) {
        String sql="insert into purchasedeliver(id,good_name,supplier1_name,supplier1_price,supplier1_numbers,supplier2_name,supplier2_price,supplier2_numbers,total) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,purchaseDeliver.getId());
            ps.setString(2,purchaseDeliver.getGoodName());
            ps.setString(3,purchaseDeliver.getSupplier1Name());
            ps.setInt(4,purchaseDeliver.getSupplier1Price());
            ps.setInt(5,purchaseDeliver.getSupplier1Numbers());
            ps.setString(6,purchaseDeliver.getSupplier2Name());
            ps.setInt(7,purchaseDeliver.getSupplier2Price());
            ps.setInt(8,purchaseDeliver.getSupplier2Numbers());
            ps.setInt(9,purchaseDeliver.getTotal());
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

    public int delete(int id,String goodName){
        String sql="delete from purchasedeliver where id=? and good_name=?";
        PreparedStatement ps=null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,goodName);
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return 0;
    }
}
