package com.logistics.dao.impl;

import com.entity.PageBean;
import com.logistics.dao.GuardRotaDao;
import com.logistics.entity.GuardRota;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description GuardRotaDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-26 23:19
 */
public class GuardRotaDaoImpl implements GuardRotaDao {

    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public GuardRota findRotaByRotaId(int rotaId) {
        String sql = "select * from guard_rota where rota_id = ?";
        try {
            GuardRota query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(GuardRota.class), rotaId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<GuardRota> findRotaByStaffId(int staffId) {
        String sql = "select * from guard_rota where staff_id = ?";
        try {
            List<GuardRota> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(GuardRota.class),staffId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<GuardRota> getAllRota() {
        String sql = "select * from guard_rota";
        try {
            List<GuardRota> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(GuardRota.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<GuardRota> getAllRotaByPage(PageBean pageBean) {
        String sql = "select * from guard_rota limit ? ,?";
        try {
            List<GuardRota> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(GuardRota.class), pageBean.getIndex(), pageBean.getPageCount());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public int addRota(GuardRota guardRota) {
          /*
        String sql = "insert into guard_rota () values ()";
        Object[] obj = {guardRota.getRotaId()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        */
        return 0;
    }

    @Override
    public int updateRota(GuardRota guardRota) {
        /*
        String sql = "update guard_rota set    where rota_id = ?";
        Object[] obj = {guardRota.getRotaId()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        */
        return 0;
    }

    @Override
    public int deleteRota(int rotaId) {
        String sql = "delete from guard_rota where rota_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, rotaId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }
}
