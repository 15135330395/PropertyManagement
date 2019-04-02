package com.storage.dao.daoImpl;


import com.storage.dao.StorageDao;
import com.storage.entity.Storage;
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
public class StorageDaoImpl implements StorageDao {
    @Override
    public List<Storage> findAll() {
        List<Storage> list = new ArrayList<>();
        String sql="select * from storage";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String principal = rs.getString("principal");
                String contactPhone = rs.getString("contact_phone");
                Storage storage =  new Storage(id,principal,contactPhone);
                list.add(storage);
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
    public int update(Storage storage) {
        String sql="update storage set principal=?,contact_phone=? where id=?";
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,storage.getPrincipal());
            ps.setString(2,storage.getContactPhone());
            ps.setInt(3,storage.getId());
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Storage findOne(int id) {
        String sql="SELECT * FROM storage WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                String principal= rs.getString("principal");
                String contactPhone= rs.getString("contact_phone");
                Storage purchaseDeliver =  new Storage(id,principal,contactPhone);
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

//    @Override
//    public int deleteById(int id) {
//        return 0;
//    }

    @Override
    public int add(Storage storage) {
        String sql="insert into storage(id,principal,contact_phone) values (?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,storage.getId());
            ps.setString(2,storage.getPrincipal());
            ps.setString(3,storage.getContactPhone());
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
