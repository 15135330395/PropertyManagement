package shouFei.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import shouFei.dao.ReceiptDao;
import shouFei.entity.PageBean;
import shouFei.entity.Receipt;
import shouFei.framewoek.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
public class ReceiptDaoImpl implements ReceiptDao {
    final static String colname="rid,department,staff_id staffId,staff_name staffName,money,pay_name payName,transactor,shijian";
    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<Receipt> findAll() {
        List<Receipt> list = new ArrayList<>();
        String sql="select "+colname+" from receipt";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Receipt receipt = new Receipt();
                int rid = rs.getInt("rid");
                String department = rs.getString("department");
                int staffId = rs.getInt("staffId");
                String staffName = rs.getString("staffName");
                Double money=rs.getDouble("money");
                String payName = rs.getString("payName");
                String transactor = rs.getString("transactor");
                Date shijian = rs.getDate("shijian");
                receipt.setRid(rid);
                receipt.setDepartment(department);
                receipt.setStaffId(staffId);
                receipt.setStaffName(staffName);
                receipt.setMonery(money);
                receipt.setPayName(payName);
                receipt.setTransactor(transactor);
                receipt.setShijian(shijian);
                list.add(receipt);
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
    public List<Receipt> queryByPage(PageBean pageBean) {
        List<Receipt> list = new ArrayList<>();
        String sql="select "+colname+" from receipt limit ?,?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                Receipt receipt = new Receipt();
                int rid = rs.getInt("rid");
                String department = rs.getString("department");
                int staffId = rs.getInt("staffId");
                String staffName = rs.getString("staffName");
                Double money=rs.getDouble("money");
                String payName = rs.getString("payName");
                String transactor = rs.getString("transactor");
                Date shijian = rs.getDate("shijian");
                receipt.setRid(rid);
                receipt.setDepartment(department);
                receipt.setStaffId(staffId);
                receipt.setStaffName(staffName);
                receipt.setMonery(money);
                receipt.setPayName(payName);
                receipt.setTransactor(transactor);
                receipt.setShijian(shijian);
                list.add(receipt);
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
    public int deleteReceipt(int id) {
        String sql="delete from receipt where rid=? ";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateReceipt(Receipt receipt) {
        String sql="update receipt set department=?,staff_id=?,staff_name=?,money=?,pay_name=?,transactor=?,shijian=? where rid=?";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, receipt.getDepartment(),receipt.getStaffId(),receipt.getStaffName(),
                    receipt.getMonery(),receipt.getPayName(),receipt.getTransactor(),receipt.getShijian(),receipt.getRid());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Receipt findReceiptById(int id) {
        Receipt receipt = new Receipt();
        //String sql="select * from receipt where rid=?";
        String sql="select "+colname+" from receipt where rid=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int rid = rs.getInt("rid");
                String department = rs.getString("department");
                int staffId = rs.getInt("staffId");
                String staffName = rs.getString("staffName");
                Double money=rs.getDouble("money");
                String payName = rs.getString("payName");
                String transactor = rs.getString("transactor");
                Date shijian = rs.getDate("shijian");
                receipt.setRid(rid);
                receipt.setDepartment(department);
                receipt.setStaffId(staffId);
                receipt.setStaffName(staffName);
                receipt.setMonery(money);
                receipt.setPayName(payName);
                receipt.setTransactor(transactor);
                receipt.setShijian(shijian);
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
        return receipt;
    }

    @Override
    public int addReceipt(Receipt receipt) {
        String sql="insert into receipt (department,staff_id,staff_name,money,pay_name,transactor,shijian) values (?,?,?,?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql,
                    receipt.getDepartment(),receipt.getStaffId(),receipt.getStaffName(),
                    receipt.getMonery(),receipt.getPayName(),receipt.getTransactor(),receipt.getShijian());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
