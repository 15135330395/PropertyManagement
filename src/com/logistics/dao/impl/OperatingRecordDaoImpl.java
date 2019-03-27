package com.logistics.dao.impl;

import com.entity.PageBean;
import com.logistics.dao.OperatingRecordDao;
import com.logistics.entity.OperatingRecord;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Description OperatingRecordDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-26 23:26
 */
public class OperatingRecordDaoImpl implements OperatingRecordDao {

    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<OperatingRecord> getAllRecord() {
        String sql = "select * from operating_record";
        try {
            List<OperatingRecord> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(OperatingRecord.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<OperatingRecord> getAllRecordByPage(PageBean pageBean) {
        String sql = "select * from operating_record limit ? ,?";
        try {
            List<OperatingRecord> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(OperatingRecord.class), pageBean.getIndex(), pageBean.getPageCount());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public OperatingRecord findRecordByRecordId(int recordId) {
        String sql = "select * from operating_record where record_id = ?";
        try {
            OperatingRecord query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(OperatingRecord.class), recordId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<OperatingRecord> findRecordByStaffId(int staffId) {
        String sql = "select * from operating_record where staff_id = ?";
        try {
            List<OperatingRecord> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(OperatingRecord.class), staffId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public int addRecord(OperatingRecord operatingRecord) {
        String sql = "insert into operating_record (staff_id,equipment_id,borrowing_time) values (?,?,?)";
        Object[] obj = {operatingRecord.getStaffId(), operatingRecord.getEquipmentName(), operatingRecord.getBorrowingTime()};
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
    public int updateRecord(OperatingRecord operatingRecord) {
        String sql = "update operating_record set staff_id=?,equipment_id=?,borrowing_time=?  where record_id = ?";
        Object[] obj = {operatingRecord.getStaffId(), operatingRecord.getEquipmentName(), operatingRecord.getBorrowingTime(), operatingRecord.getRecordId()};
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
    public int deleteRecord(int recordId) {
        String sql = "delete from operating_record where record_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, recordId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }

    @Override
    public int returnEquipment(int recordId, Date returnTime) {
        String sql = "update operating_record set return_time=? where record_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, returnTime, recordId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }
}
