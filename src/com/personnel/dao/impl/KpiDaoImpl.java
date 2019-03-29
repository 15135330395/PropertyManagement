package com.personnel.dao.impl;

import com.entity.PageBean;
import com.personnel.dao.KpiDao;
import com.personnel.entity.Kpi;
import com.personnel.entity.Recuit;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public class KpiDaoImpl implements KpiDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<Kpi> findAll() {
        String sql="select *from kpi order by kpi_id";
        try {
            List<Kpi> kpiList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Kpi.class));
            return  kpiList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Kpi> queryPage(PageBean pageBean) {
        String sql="select *from kpi order by kpi_id limit ?,?";
        try {
            List<Kpi> kpiList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Kpi.class), pageBean.getIndex(), pageBean.getPageCount());
            return kpiList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addKpi(Kpi kpi) {
        String sql="insert into kpi (staff_id,staff_name,department_name,evaluate_content,evaluate_person,evaluate_grade) " +
                "values(?,?,?,?,?,?)";
        Object[] objs={kpi.getStaffId(),kpi.getStaffName(),kpi.getDepartmentName(),kpi.getEvaluateContent(),kpi.getEvaluatePerson(),kpi.getEvaluateGrade()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateKpi(Kpi kpi) {
        String sql="update kpi set staff_id=?,staff_name=?,department_name=?,evaluate_content=?,evaluate_person=?,evaluate_grade=? " +
                "where kpi_id=?";
        Object[] objs={kpi.getStaffId(),kpi.getStaffName(),kpi.getDepartmentName(),kpi.getEvaluateContent(),kpi.getEvaluatePerson(),kpi.getEvaluateGrade(),kpi.getKpiId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteKpi(int kpiId) {
        String sql="delete from kpi  where kpi_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, kpiId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Kpi queryOne(int kpiId) {
        String sql="select * from kpi  where kpi_id=?";
        try {
            Kpi kpi = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Kpi.class), kpiId);
            return kpi;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
