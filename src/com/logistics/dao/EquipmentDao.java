package com.logistics.dao;

import com.entity.Equipment;
import com.entity.PageBean;
import com.logistics.entity.FireFightingEquipment;
import com.logistics.entity.SecurityGuardEquipment;

import java.util.List;

/**
 * @Description EquipmentDao
 * @Author WYR
 * @CreateTime 2019-03-30 21:07
 */
public interface EquipmentDao {

    /**
     * 查询所有的消防器材
     *
     * @return
     */
    List<FireFightingEquipment> getAllFireFightingEquipment();

    /**
     * 查询所有的安保设备
     *
     * @return
     */
    List<SecurityGuardEquipment> getAllSecurityGuardEquipment();

    /**
     * 查询所有消防器材的分页
     *
     * @param pageBean
     * @return
     */
    List<FireFightingEquipment> getAllFireFightingEquipmentByPage(PageBean pageBean);

    /**
     * 查询所有安保设备的分页
     *
     * @param pageBean
     * @return
     */
    List<SecurityGuardEquipment> getAllSecurityGuardEquipmentByPage(PageBean pageBean);

    /**
     * 通过ID查找器材
     *
     * @param equipmentId
     * @return
     */
    Equipment findEquipmentById(int equipmentId);

    /**
     * 添加消防器材
     *
     * @param fireFightingEquipment
     * @return
     */
    int addFireFightingEquipment(FireFightingEquipment fireFightingEquipment);

    /**
     * 添加安保设备
     *
     * @param securityGuardEquipment
     * @return
     */
    int addSecurityGuardEquipment(SecurityGuardEquipment securityGuardEquipment);

    /**
     * 修改器材
     *
     * @param equipment
     * @return
     */
    int updateEquipment(Equipment equipment);

    /**
     * 删除器材
     *
     * @param equipmentId
     * @return
     */
    int deleteEquipment(int equipmentId);
}
