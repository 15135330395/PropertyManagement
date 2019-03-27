package com.logistics.dao.impl;

import com.entity.PageBean;
import com.logistics.dao.GuardRotaDao;
import com.logistics.entity.GuardRota;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
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
            List<GuardRota> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(GuardRota.class), staffId);
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
        String sql = "insert into guard_rota (rota_start,rota_end,staff_id) values (?,?,?)";
        Object[] obj = {guardRota.getRotaStart(), guardRota.getRotaEnd(), guardRota.getStaffId()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }

    @Override
    public int updateRota(GuardRota guardRota) {
        String sql = "update guard_rota set rota_start=?,rota_end=?,staff_id=?,clock_in=null,clock_out=null where rota_id = ?";
        Object[] obj = {guardRota.getRotaStart(), guardRota.getRotaEnd(), guardRota.getStaffId(), guardRota.getRotaId()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
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

    @Override
    public int clockIn(int rotaId, Date clockInTime) {
        String sql = "update guard_rota set clock_in=? where rota_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, clockInTime, rotaId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }

    @Override
    public int clockOut(int rotaId, Date clockOutTime) {
        String sql = "update guard_rota set clock_out=? where rota_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, clockOutTime, rotaId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }
}
