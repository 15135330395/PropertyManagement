package shouFei.dao.daoImpl;


import org.apache.commons.dbutils.QueryRunner;
import shouFei.dao.PayItemsDao;
import shouFei.entity.PageBean;
import shouFei.entity.PayItems;
import shouFei.framewoek.JdbcUtils;

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
    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<PayItems> findAll() {
        List<PayItems> list = new ArrayList<>();
        String sql="select * from pay_items";
        PreparedStatement ps=null;
        ResultSet rs = null;
        //下面try那些可以省略了
        // List<PayItems> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(PayItems.class));
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                PayItems payItems =  new PayItems();
                int payId = rs.getInt("pay_id");
                String payName = rs.getString("pay_name");
                String payType = rs.getString("pay_type");
                String billingAccuracyl=rs.getString("billing_accuracy");
                String note = rs.getString("note");
                payItems.setPayId(payId);
                payItems.setPayName(payName);
                payItems.setPayType(payType);
                payItems.setBillingAccuracy(billingAccuracyl);
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
            JdbcUtils.close();
        }
        return list;
    }

    @Override
    public int addPayItems(PayItems payItems) {
        String sql="insert into pay_items (pay_name,pay_type,billing_accuracy,note) values (?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql,
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
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, id);
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
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, payItems.getPayName(),
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

        String sql="select * from pay_items limit ?,?  ";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                PayItems payItems =  new PayItems();
                int payId = rs.getInt("pay_id");
                String payName = rs.getString("pay_name");
                String payType = rs.getString("pay_type");
                String billingAccuracyl=rs.getString("billing_accuracy");
                String note = rs.getString("note");
                payItems.setPayId(payId);
                payItems.setPayName(payName);
                payItems.setPayType(payType);
                payItems.setBillingAccuracy(billingAccuracyl);
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
            JdbcUtils.close();
        }
        return list;
    }
    @Override
    public PayItems findPayItemsById(int id) {
        PayItems payItems =  new PayItems();
        String sql="select * from pay_items where pay_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int payId = rs.getInt("pay_id");
                String payName = rs.getString("pay_name");
                String payType = rs.getString("pay_type");
                String billingAccuracyl=rs.getString("billing_accuracy");
                String note = rs.getString("note");
                payItems.setPayId(payId);
                payItems.setPayName(payName);
                payItems.setPayType(payType);
                payItems.setBillingAccuracy(billingAccuracyl);
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
            JdbcUtils.close();
        }
        return payItems;
    }
}
