package com.personnel.dao.impl;

import com.entity.PageBean;
import com.personnel.dao.SalaryDao;
import com.personnel.entity.Salary;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
public class SalaryDaoImpl implements SalaryDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<Salary> findAll() {
        String sql="select *from attendance order by attendance_id";
        try {
            List<Salary> salaryList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Salary.class));
            return  salaryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Salary> queryPage(PageBean pageBean) {
        String sql="select sa.*,s.staff_name,k.evaluate_grade,a.work_day,a.sick_leave,a.affair_leave,a.onduty,a.abnormal,si.*  from salary sa ,staff s,kpi k,security_insurance si,attendance a where sa.attantance_id=a.attendance_id and sa.staff_id=s.staff_id   and sa.kpi_id=k.kpi_id and si.security_insurance_id=sa.security_insurance_id order by sa.salary_id limit ?,?";
        try {
            List<Salary> salaryList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Salary.class), pageBean.getIndex(), pageBean.getPageCount());
            return salaryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addSalary(Salary salary) {
        String sql="insert into salary (staff_id,basic_salary,attantance_id," +
                "kpi_id,security_insurance_id) " +
                "values(?,?,?,?,?)";
        Object[] objs={salary.getStaffId(),salary.getBasicSalary(),
                salary.getAttantanceId(),salary.getKpiId(),
                salary.getSecurityInsuranceId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateSalary(Salary salary) {
        String sql="update salary set staff_id=?,basic_salary=?,attantance_id=? " +
                ",kpi_id=?, security_insurance_id=? where salary_id=?";
        Object[] objs={salary.getStaffId(),salary.getBasicSalary(),
                salary.getAttantanceId(),salary.getKpiId(),
                salary.getSecurityInsuranceId(),salary.getSalaryId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteSalary(int salaryId) {
        String sql="delete from salary  where salary_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, salaryId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Salary queryOne(int salaryId) {
        String sql="select sa.*,s.staff_name,k.evaluate_grade,a.work_day,a.sick_leave,a.affair_leave,a.onduty,a.abnormal,si.*  from salary sa ,staff s,kpi k,security_insurance si,attendance a where sa.attantance_id=a.attendance_id and sa.staff_id=s.staff_id   and sa.kpi_id=k.kpi_id and si.security_insurance_id=sa.security_insurance_id and  sa.salary_id=? ";
        try {
            Salary salary = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Salary.class), salaryId);
            return salary;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Salary queryOneByStaffId(int staffId) {
        String sql="select sa.*,s.staff_name,k.evaluate_grade,a.work_day,a.sick_leave,a.affair_leave,a.onduty,a.abnormal,si.*  from salary sa ,staff s,kpi k,security_insurance si,attendance a where sa.attantance_id=a.attendance_id and sa.staff_id=s.staff_id   and sa.kpi_id=k.kpi_id and si.security_insurance_id=sa.security_insurance_id and  sa.staff_id=? ";
        try {
            Salary salary = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Salary.class), staffId);
            return salary;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
