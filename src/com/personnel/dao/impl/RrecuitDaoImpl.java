package com.personnel.dao.impl;

import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.dao.RecuitDao;
import com.personnel.entity.Recuit;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-28 上午 10:01
 */
public class RrecuitDaoImpl implements RecuitDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<Recuit> findAll() {
        String sql="select *from recuit order by recuit_id";
        try {
            List<Recuit> recuitList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Recuit.class));
            return  recuitList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Recuit> queryRecuitPage(PageBean pageBean) {
        String sql="select *from recuit order by recuit_id limit ?,?";
        try {
            List<Recuit> recuitList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Recuit.class), pageBean.getIndex(), pageBean.getPageCount());
            return recuitList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addRecuit(Recuit recuit) {
        String sql="insert into recuit (recuit_position,recuit_count,duty,demand,basic_salary) " +
                "values(?,?,?,?,?)";
        Object[] objs={recuit.getRecuitPosition(),recuit.getRecuitCount(),recuit.getDuty(),recuit.getDemand(),recuit.getBasicSalary()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRecuit(Recuit recuit) {
        String sql="update recuit set recuit_position=?,recuit_count=?,duty=?,demand=?,basic_salary=? " +
                "where recuit_id=?";
        Object[] objs={recuit.getRecuitPosition(),recuit.getRecuitCount(),recuit.getDuty(),recuit.getDemand(),recuit.getBasicSalary(),recuit.getRecuitId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRecuit(int recuitId) {
        String sql="delete from recuit  where recuit_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, recuitId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Recuit queryOne(int recuitId) {
        String sql="select * from recuit  where recuit_id=?";
        try {
            Recuit recuit = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Recuit.class), recuitId);
            return recuit;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
