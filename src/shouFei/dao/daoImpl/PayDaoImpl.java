package shouFei.dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import shouFei.dao.PayDao;
import shouFei.entity.PageBean;
import shouFei.entity.Pay;
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
public class PayDaoImpl implements PayDao {
    final static String colname="pid,department,staff_id staffId,staff_name staffName,money,reason,transactor,shijian";
    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<Pay> findAll() {
        List<Pay> list = new ArrayList<>();
        String sql="select "+colname+" from pay";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pay pay = new Pay();
                int pid = rs.getInt("pid");
                String department = rs.getString("department");
                int staffId = rs.getInt("staffId");
                String staffName = rs.getString("staffName");
                Double money=rs.getDouble("money");
                String reason = rs.getString("reason");
                String transactor = rs.getString("transactor");
                Date shijian = rs.getDate("shijian");
                pay.setPid(pid);
                pay.setDepartment(department);
                pay.setStaffId(staffId);
                pay.setStaffName(staffName);
                pay.setMonery(money);
                pay.setReason(reason);
                pay.setTransactor(transactor);
                pay.setShijian(shijian);
                list.add(pay);
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
    public List<Pay> queryByPage(PageBean pageBean) {
        List<Pay> list = new ArrayList<>();
        String sql="select "+colname+" from pay limit ?,?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                Pay pay = new Pay();
                int pid = rs.getInt("pid");
                String department = rs.getString("department");
                int staffId = rs.getInt("staffId");
                String staffName = rs.getString("staffName");
                Double money=rs.getDouble("money");
                String reason = rs.getString("reason");
                String transactor = rs.getString("transactor");
                Date shijian = rs.getDate("shijian");
                pay.setPid(pid);
                pay.setDepartment(department);
                pay.setStaffId(staffId);
                pay.setStaffName(staffName);
                pay.setMonery(money);
                pay.setReason(reason);
                pay.setTransactor(transactor);
                pay.setShijian(shijian);
                list.add(pay);
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
    public int deletePay(int id) {
        String sql="delete from pay where pid=? ";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePay(Pay pay) {
        String sql="update pay set department=?,staff_id=?,staff_name=?,money=?,reason=?,transactor=?,shijian=? where pid=?";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql, pay.getDepartment(),pay.getStaffId(),pay.getStaffName(),
                    pay.getMonery(),pay.getReason(),pay.getTransactor(),pay.getShijian(),pay.getPid());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Pay findPayById(int id) {
        Pay pay =  new Pay();
        //String sql="select * from pay where pid=?";
        String sql="select "+colname+" from pay where pid=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt("pid");
                String department = rs.getString("department");
                int staffId = rs.getInt("staffId");
                String staffName = rs.getString("staffName");
                Double money=rs.getDouble("money");
                String reason = rs.getString("reason");
                String transactor = rs.getString("transactor");
                Date shijian = rs.getDate("shijian");
                pay.setPid(pid);
                pay.setDepartment(department);
                pay.setStaffId(staffId);
                pay.setStaffName(staffName);
                pay.setMonery(money);
                pay.setReason(reason);
                pay.setTransactor(transactor);
                pay.setShijian(shijian);
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
        return pay;
    }

    @Override
    public int addPay(Pay pay) {
        String sql="insert into pay (department,staff_id,staff_name,money,reason,transactor,shijian) values (?,?,?,?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtils.getConnection(), sql,
                    pay.getDepartment(),pay.getStaffId(),pay.getStaffName(),
                    pay.getMonery(),pay.getReason(),pay.getTransactor(),pay.getShijian());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
