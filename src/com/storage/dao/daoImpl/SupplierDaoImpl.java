package com.storage.dao.daoImpl;


import com.storage.dao.SupplierDao;
import com.storage.entity.Supplier;
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
public class SupplierDaoImpl implements SupplierDao {
    @Override
    public List<Supplier> findAll() {
        List<Supplier> list = new ArrayList<>();
        String sql="select * from supplier";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String contactPerson = rs.getString("contact_person");
                String contactPhone = rs.getString("contact_phone");
                String goodName = rs.getString("good_name");
                int goodPrice = rs.getInt("good_price");
                Supplier supplier =  new Supplier(id,name,contactPerson,contactPhone,goodName,goodPrice);
                list.add(supplier);
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
    public int update(Supplier supplier) {
        String sql="update supplier set name=?,contact_person=?,contact_phone=?,good_name=?,good_price=? where id=?";
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,supplier.getName());
            ps.setString(2,supplier.getContactPerson());
            ps.setString(3,supplier.getContactPhone());
            ps.setString(4,supplier.getGoodName());
            ps.setInt(5,supplier.getGoodPrice());
            ps.setInt(6,supplier.getId());
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Supplier findOne(String supplierName) {
        String sql="SELECT * FROM supplier WHERE name =?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,supplierName);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String contactPerson = rs.getString("contact_person");
                String contactPhone = rs.getString("contact_phone");
                String name = rs.getString("good_name");
                int goodPrice = rs.getInt("good_price");
                Supplier supplier =  new Supplier(id,supplierName,contactPerson,contactPhone,name,goodPrice);
                return supplier;
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
    public int deleteById(int id) {
        String sql="delete from supplier where id=?";
        PreparedStatement ps=null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
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

    @Override
    public int add(Supplier supplier) {
        String sql="insert into supplier(id,name,contact_person,contact_phone,good_name,good_price) values (?,?,?,?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,supplier.getId());
            ps.setString(2,supplier.getName());
            ps.setString(3,supplier.getContactPerson());
            ps.setString(4,supplier.getContactPhone());
            ps.setString(5,supplier.getGoodName());
            ps.setInt(6,supplier.getGoodPrice());
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
}
