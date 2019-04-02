package com.storage.dao.daoImpl;


import com.storage.dao.GoodsDao;
import com.storage.entity.Goods;
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
 * Time: 17:32
 * Description: No Description
 */
public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<Goods> findAll() {
        List<Goods> list = new ArrayList<>();
        String sql="select * from goods";
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
                Goods goods =  new Goods(id,goodName,numbers);
                list.add(goods);
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
    public int update(Goods goods) {
        String sql="update goods set numbers=? where good_name=? and id=?;";
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,goods.getNumbers());
            ps.setString(2,goods.getGoodName());
            ps.setInt(3,goods.getId());
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Goods findOne(int id,String goodName) {
        String sql="SELECT * FROM goods WHERE id=? AND good_name =?";
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
                Goods goods =  new Goods(id,goodName,numbers);
                return goods;
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
    public int delete(int id, String goodName) {
        String sql="delete from goods where id=? and good_name=?";
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

    @Override
    public int add(Goods goods) {
        String sql="insert into goods(id,good_name,numbers) values (?,?,?)";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,goods.getId());
            ps.setString(2,goods.getGoodName());
            ps.setInt(3,goods.getNumbers());
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
    public List<Goods> findByGoodsName(String goodName) {
        List<Goods> list = new ArrayList<>();
        String sql="select * from goods where good_name=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,goodName);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int numbers = rs.getInt("numbers");
                Goods goods =  new Goods(id,goodName,numbers);
                list.add(goods);
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

    public List<Goods> findWarning(){
        List<Goods> list = new ArrayList<>();
        String sql="select * from goods where numbers < 50 order by numbers ASC";
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
                Goods goods =  new Goods(id,goodName,numbers);
                list.add(goods);
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
