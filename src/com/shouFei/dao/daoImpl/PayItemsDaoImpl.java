package com.shouFei.dao.daoImpl;


import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import com.shouFei.dao.PayItemsDao;
import com.entity.PageBean;
import com.shouFei.entity.PayItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class PayItemsDaoImpl implements PayItemsDao {
    final static String colname="pay_id payId,pay_name payName,pay_type payType,billing_accuracy billingAccuracy,note";
    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<PayItems> findAll() {
        List<PayItems> list = new ArrayList<>();
        //String sql="select * from pay_items";
        String sql="select "+colname+" from pay_items";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                PayItems payItems =  new PayItems();
                int payId = rs.getInt("payId");
                String payName = rs.getString("payName");
                String payType = rs.getString("payType");
                String billingAccuracy=rs.getString("billingAccuracy");
                String note = rs.getString("note");
                payItems.setPayId(payId);
                payItems.setPayName(payName);
                payItems.setPayType(payType);
                payItems.setBillingAccuracy(billingAccuracy);
                payItems.setNote(note);
                list.add(payItems);
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
        return list;
    }

    @Override
    public int addPayItems(PayItems payItems) {
        String sql="insert into pay_items (pay_name,pay_type,billing_accuracy,note) values (?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql,
                    payItems.getPayName(),payItems.getPayType(),payItems.getBillingAccuracy(),payItems.getNote());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deletePayItems(int id) {
        String sql="delete from pay_items where pay_id = ? ";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePayItems(PayItems payItems) {
        String sql="update pay_items set pay_name=?,pay_type=?,billing_accuracy=?,note=? where  pay_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, payItems.getPayName(),
                    payItems.getPayType(),payItems.getBillingAccuracy(),payItems.getNote(),payItems.getPayId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PayItems> queryByPage(PageBean pageBean) {
        List<PayItems> list = new ArrayList<>();
        String sql="select "+colname+" from pay_items limit ?,?";
        //String sql="select * from pay_items limit ?,?  ";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                PayItems payItems =  new PayItems();
                int payId = rs.getInt("payId");
                String payName = rs.getString("payName");
                String payType = rs.getString("payType");
                String billingAccuracy=rs.getString("billingAccuracy");
                String note = rs.getString("note");
                payItems.setPayId(payId);
                payItems.setPayName(payName);
                payItems.setPayType(payType);
                payItems.setBillingAccuracy(billingAccuracy);
                payItems.setNote(note);
                list.add(payItems);
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
        return list;
    }
    @Override
    public PayItems findPayItemsById(int id) {
        PayItems payItems =  new PayItems();
        //String sql="select * from pay_items where pay_id=?";
        String sql="select "+colname+" from pay_items where pay_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int payId = rs.getInt("payId");
                String payName = rs.getString("payName");
                String payType = rs.getString("payType");
                String billingAccuracy=rs.getString("billingAccuracy");
                String note = rs.getString("note");
                payItems.setPayId(payId);
                payItems.setPayName(payName);
                payItems.setPayType(payType);
                payItems.setBillingAccuracy(billingAccuracy);
                payItems.setNote(note);
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
        return payItems;
    }
}
