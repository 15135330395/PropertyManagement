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

    final static String colname="norm_id normId, pay_id payId, norm_name normName, compute_mode computeMode, "+
            "price, filling_type fillingType, close_end closeEnd, " +
            "custom_formula customFormula, charge_cycle chargeCycle";
    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<PayNorm> findAll() {
        List<PayNorm> list = new ArrayList<>();
        String sql="select "+colname+" from pay_norm";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PayNorm payNorm =  new PayNorm();
                int normId = rs.getInt("normId");
                int payId = rs.getInt("payId");
                String normName = rs.getString("normName");
                String computeMode = rs.getString("computeMode");
                Double price=rs.getDouble("price");
                String fillingType = rs.getString("fillingType");
                int closeEnd = rs.getInt("closeEnd");
                String customFormula = rs.getString("customFormula");
                int chargeCycle = rs.getInt("chargeCycle");
                payNorm.setNormId(normId);
                payNorm.setPayId(payId);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setPrice(price);
                payNorm.setFillingType(fillingType);
                payNorm.setCloseEnd(closeEnd);
                payNorm.setCustomFormula(customFormula);
                payNorm.setChargeCycle(chargeCycle);
                list.add(payNorm);
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
    public List<PayNorm> findByPayId() {
        List<PayNorm> list = new ArrayList<>();
        String sql="select "+colname+" from pay_norm pn,pay_items pi where pn.pay_id=pi.pay_id";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PayNorm payNorm =  new PayNorm();
                int normId = rs.getInt("normId");
               int payId = rs.getInt("payId");
                String normName = rs.getString("normName");
                String computeMode = rs.getString("computeMode");
                Double price=rs.getDouble("price");
                String fillingType = rs.getString("fillingType");
                int closeEnd = rs.getInt("closeEnd");
                String customFormula = rs.getString("customFormula");
                int chargeCycle = rs.getInt("chargeCycle");
                payNorm.setNormId(normId);
                payNorm.setPayId(payId);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setPrice(price);
                payNorm.setFillingType(fillingType);
                payNorm.setCloseEnd(closeEnd);
                payNorm.setCustomFormula(customFormula);
                payNorm.setChargeCycle(chargeCycle);
                list.add(payNorm);
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
    public int addPayNorm(PayNorm payNorm) {
        String sql="insert into pay_norm (pay_id,norm_name,compute_mode,price,filling_type,close_end,custom_formula,charge_cycle) values (?,?,?,?,?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql,
                    payNorm.getPayId(),payNorm.getNormName(),payNorm.getComputeMode(),
                    payNorm.getPrice(),payNorm.getFillingType(),payNorm.getCloseEnd(),
                    payNorm.getCustomFormula(),payNorm.getChargeCycle());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deletePayNorm(int NormId) {
        String sql="delete from pay_norm where norm_id =? ";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, NormId);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePayNorm(PayNorm payNorm) {

        String sql="update pay_norm set pay_id=?,norm_name=?,compute_mode=?,price=?,filling_type=?,close_end=?,custom_formula=?,charge_cycle=? where norm_id =?";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, payNorm.getPayId(),payNorm.getNormName(),payNorm.getComputeMode(),
                    payNorm.getPrice(),payNorm.getFillingType(),payNorm.getCloseEnd(),
                    payNorm.getCustomFormula(),payNorm.getChargeCycle(),payNorm.getNormId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int findPayNormCountById(int normId) {
        String sql="select count(*)  count from pay_norm where norm_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,normId);
            rs = ps.executeQuery();
            while (rs.next()){
                int count = rs.getInt("count");
                return  count;
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
        return 0;
    }


    @Override
    public PayNorm findPayNormById(int NormId) {
        PayNorm payNorm =  new PayNorm();
        String sql="select * from pay_norm where norm_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,NormId);
            rs = ps.executeQuery();
            while (rs.next()){
                int normId = rs.getInt("norm_id");
                int payId = rs.getInt("pay_id");
                String normName = rs.getString("norm_name");
                String computeMode = rs.getString("compute_mode");
                Double price=rs.getDouble("price");
                String fillingType = rs.getString("filling_type");
                int closeEnd = rs.getInt("close_end");
                String customFormula = rs.getString("custom_formula");
                int chargeCycle = rs.getInt("charge_cycle");
                payNorm.setNormId(normId);
                payNorm.setPayId(payId);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setPrice(price);
                payNorm.setFillingType(fillingType);
                payNorm.setCloseEnd(closeEnd);
                payNorm.setCustomFormula(customFormula);
                payNorm.setChargeCycle(chargeCycle);
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
        return payNorm;
    }

    @Override
    public List<PayNorm> queryByPage(PageBean pageBean) {
        List<PayNorm> list = new ArrayList<>();
        String sql="select * from pay_norm limit ?,?  ";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                PayNorm payNorm =  new PayNorm();
                int normId = rs.getInt("norm_id");
                int payId = rs.getInt("pay_id");
                String normName = rs.getString("norm_name");
                String computeMode = rs.getString("compute_mode");
                Double price=rs.getDouble("price");
                String fillingType = rs.getString("filling_type");
                int closeEnd = rs.getInt("close_end");
                String customFormula = rs.getString("custom_formula");
                int chargeCycle = rs.getInt("charge_cycle");
                payNorm.setNormId(normId);
                payNorm.setPayId(payId);
                payNorm.setNormName(normName);
                payNorm.setComputeMode(computeMode);
                payNorm.setPrice(price);
                payNorm.setFillingType(fillingType);
                payNorm.setCloseEnd(closeEnd);
                payNorm.setCustomFormula(customFormula);
                payNorm.setChargeCycle(chargeCycle);
                list.add(payNorm);
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

}
