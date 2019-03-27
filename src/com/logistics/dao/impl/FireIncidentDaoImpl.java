package com.logistics.dao.impl;

import com.entity.PageBean;
import com.logistics.dao.FireIncidentDao;
import com.logistics.entity.FireIncident;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description FireIncidentDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-26 23:12
 */
public class FireIncidentDaoImpl implements FireIncidentDao {

    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<FireIncident> getAllIncident() {
        String sql = "select * from fire_incident";
        try {
            List<FireIncident> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(FireIncident.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<FireIncident> getAllIncidentByPage(PageBean pageBean) {
        String sql = "select * from fire_incident limit ? ,?";
        try {
            List<FireIncident> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(FireIncident.class), pageBean.getIndex(), pageBean.getPageCount());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public FireIncident findIncidentById(int incidentId) {
        String sql = "select * from fire_incident where incident_id = ?";
        try {
            FireIncident query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(FireIncident.class), incidentId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public int addIncident(FireIncident fireIncident) {
        String sql = "insert into fire_incident (alarm_time,incident_locale,staff_id,cause,loss) values (?,?,?,?,?)";
        Object[] obj = {fireIncident.getAlarmTime(), fireIncident.getIncidentLocale(), fireIncident.getStaffId(), fireIncident.getCause(), fireIncident.getLoss()};
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
    public int updateIncident(FireIncident fireIncident) {
        String sql = "update fire_incident set alarm_time=?,incident_locale=?,staff_id=?,cause=?,loss=? where incident_id = ?";
        Object[] obj = {fireIncident.getAlarmTime(), fireIncident.getIncidentLocale(), fireIncident.getStaffId(), fireIncident.getCause(), fireIncident.getLoss(), fireIncident.getIncidentId()};
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
    public int deleteIncident(int incidentId) {
        String sql = "delete from fire_incident where incident_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, incidentId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }
}
