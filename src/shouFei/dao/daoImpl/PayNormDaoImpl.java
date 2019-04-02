package shouFei.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import shouFei.dao.PayNormDao;
import shouFei.entity.PageBean;
import shouFei.entity.PayNorm;
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
public class PayNormDaoImpl implements PayNormDao {

    final static String colname = "norm_id normId, pay_name payName, norm_name normName, compute_mode computeMode, charge_cycle chargeCycle";
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<PayNorm> findAll() {
        List<PayNorm> list = new ArrayList<>();
        String sql = "select " + colname + " from pay_norm";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PayNorm payNorm = new PayNorm();
                int normId = rs.getInt("normId");
                String payName = rs.getString("payName");
                String normName = rs.getString("normName");
                String computeMode = rs.getString("computeMode");
                int chargeCycle = rs.getInt("chargeCycle");
                payNorm.setNormId(normId);
                payNorm.setPayName(payName);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setChargeCycle(chargeCycle);
                list.add(payNorm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return list;
    }

    @Override
    public int addPayNorm(PayNorm payNorm) {
        String sql = "insert into pay_norm (pay_name,norm_name,compute_mode,charge_cycle) values (?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql,
                    payNorm.getPayName(), payNorm.getNormName(), payNorm.getComputeMode(), payNorm.getChargeCycle());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deletePayNorm(int NormId) {
        String sql = "delete from pay_norm where norm_id =? ";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, NormId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePayNorm(PayNorm payNorm) {

        String sql = "update pay_norm set pay_name=?,norm_name=?,compute_mode=?,charge_cycle=? where norm_id =?";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, payNorm.getPayName(), payNorm.getNormName(), payNorm.getComputeMode(),
                    payNorm.getChargeCycle(), payNorm.getNormId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int findPayNormCountById(int normId) {
        String sql = "select count(*)  count from pay_norm where norm_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, normId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("count");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return 0;
    }


    @Override
    public PayNorm findPayNormById(int NormId) {
        PayNorm payNorm = new PayNorm();
        String sql = "select * from pay_norm where norm_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, NormId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int normId = rs.getInt("norm_id");
                String payName = rs.getString("pay_name");
                String normName = rs.getString("norm_name");
                String computeMode = rs.getString("compute_mode");
                int chargeCycle = rs.getInt("charge_cycle");
                payNorm.setNormId(normId);
                payNorm.setPayName(payName);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setChargeCycle(chargeCycle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return payNorm;
    }

    @Override
    public List<PayNorm> queryByPage(PageBean pageBean) {
        List<PayNorm> list = new ArrayList<>();
        String sql = "select * from pay_norm limit ?,?  ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pageBean.getIndex());
            ps.setInt(2, pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                PayNorm payNorm = new PayNorm();
                int normId = rs.getInt("norm_id");
                String payName = rs.getString("pay_name");
                String normName = rs.getString("norm_name");
                String computeMode = rs.getString("compute_mode");
                int chargeCycle = rs.getInt("charge_cycle");
                payNorm.setNormId(normId);
                payNorm.setPayName(payName);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setChargeCycle(chargeCycle);
                list.add(payNorm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return list;
    }
    @Override
    public List<PayNorm> queryOne(String payName) {
        List<PayNorm> list = new ArrayList<>();
       // payName = "'" + payName + "'";
       // String sql = "select norm_id,pay_name,norm_name,compute_mode,charge_cycle from pay_norm where pay_name= ?";
        String sql = "select " + colname + " from pay_norm where pay_name= ?";
       // System.out.println(sql);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, payName);
            rs = ps.executeQuery();
            while (rs.next()) {
                PayNorm payNorm = new PayNorm();
                int normId = rs.getInt("normId");
                payName = rs.getString("payName");
                String normName = rs.getString("normName");
                String computeMode = rs.getString("computeMode");
                int chargeCycle = rs.getInt("chargeCycle");
                payNorm.setNormId(normId);
                payNorm.setPayName(payName);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setChargeCycle(chargeCycle);
                list.add(payNorm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.close();
        }
        return list;
    }

//    public static void main(String[] args) {
//        PayNormDaoImpl payNormDao = new PayNormDaoImpl();
//        List<PayNorm> list = payNormDao.queryOne("水电费");
//        for (int i = 0; i < list.size(); i++) {
//
//            System.out.println(list.get(i).getNormName()+list.get(i).getPayName());
//        }
//    }



}
