package com.logistics.dao.impl;

import com.entity.PageBean;
import com.entity.Staff;
import com.logistics.dao.LogisticsStaffDao;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description LogisticsStaffDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-30 18:08
 */
public class LogisticsStaffDaoImpl implements LogisticsStaffDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Staff> getAllLogisticsStaff() {
        String sql = "select s.*,d.department_name from staff s,department d where s.department_id=d.department_id and  d.department_id>=200 and d.department_id<210";
        try {
            List<Staff> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Staff.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Staff> getAllLogisticsStaffByPage(PageBean pageBean) {
        String sql = "select s.*,d.department_name from staff s,department d where s.department_id=d.department_id and  d.department_id>=200 and d.department_id<210 limit ?,?";
        try {
            List<Staff> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Staff.class), pageBean.getIndex(), pageBean.getPageCount());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Staff findLogisticsStaffById(int staffId) {
        String sql = "select s.*,d.department_name from staff s,department d where s.department_id=d.department_id and  d.department_id>=200 and d.department_id<210 and staff_id=?";
        try {
            Staff query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Staff.class), staffId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateLogisticsStaff(Staff staff) {
        String sql = "update staff set staff_name=? ,age=? where staff_id = ?";
        try {
            Object[] obj = {staff.getStaffName(), staff.getAge(), staff.getStaffId()};
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
