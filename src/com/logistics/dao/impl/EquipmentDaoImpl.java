package com.logistics.dao.impl;

import com.entity.Equipment;
import com.entity.PageBean;
import com.logistics.dao.EquipmentDao;
import com.logistics.entity.FireFightingEquipment;
import com.logistics.entity.SecurityGuardEquipment;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description EquipmentDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-30 21:15
 */
public class EquipmentDaoImpl implements EquipmentDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<FireFightingEquipment> getAllFireFightingEquipment() {
        String sql = "select * from equipment where equipment_type='消防器材'";
        try {
            List<FireFightingEquipment> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(FireFightingEquipment.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SecurityGuardEquipment> getAllSecurityGuardEquipment() {
        String sql = "select * from equipment where equipment_type='安保器材'";
        try {
            List<SecurityGuardEquipment> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(SecurityGuardEquipment.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FireFightingEquipment> getAllFireFightingEquipmentByPage(PageBean pageBean) {
        String sql = "select * from equipment where equipment_type='消防器材' limit ?,?";
        try {
            List<FireFightingEquipment> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(FireFightingEquipment.class), pageBean.getIndex(), pageBean.getPageCount());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SecurityGuardEquipment> getAllSecurityGuardEquipmentByPage(PageBean pageBean) {
        String sql = "select * from equipment where equipment_type='安保器材' limit ?,?";
        try {
            List<SecurityGuardEquipment> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(SecurityGuardEquipment.class), pageBean.getIndex(), pageBean.getPageCount());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Equipment findEquipmentById(int equipmentId) {
        String sql = "select * from equipment where equipment_id =?";
        try {
            Equipment query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Equipment.class), equipmentId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addFireFightingEquipment(FireFightingEquipment fireFightingEquipment) {
        String sql = "insert into equipment (equipment_type,equipment_name,amount) values ('消防器材',?,?)";
        Object[] obj = {fireFightingEquipment.getEquipmentName(), fireFightingEquipment.getAmount()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addSecurityGuardEquipment(SecurityGuardEquipment securityGuardEquipment) {
        String sql = "insert into equipment (equipment_type,equipment_name,amount) values ('安保器材',?,?)";
        Object[] obj = {securityGuardEquipment.getEquipmentName(), securityGuardEquipment.getAmount()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateEquipment(Equipment equipment) {
        String sql = "update equipment set equipment_name=?,amount=? where equipment_id=?";
        Object[] obj = {equipment.getEquipmentName(), equipment.getAmount(), equipment.getEquipmentId()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEquipment(int equipmentId) {
        String sql = "delete from equipment where equipment_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, equipmentId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
