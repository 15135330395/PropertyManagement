package com.logistics.service;

import com.entity.Equipment;
import com.entity.PageBean;
import com.logistics.dao.EquipmentDao;
import com.logistics.dao.impl.EquipmentDaoImpl;
import com.logistics.entity.FireFightingEquipment;
import com.logistics.entity.SecurityGuardEquipment;

import java.util.List;

/**
 * @Description EquipmentService
 * @Author WYR
 * @CreateTime 2019-03-30 21:15
 */
public class EquipmentService {
    private EquipmentDao dao = new EquipmentDaoImpl();

    public List<FireFightingEquipment> getAllFireFightingEquipment() {
        return dao.getAllFireFightingEquipment();
    }

    public List<SecurityGuardEquipment> getAllSecurityGuardEquipment() {
        return dao.getAllSecurityGuardEquipment();
    }

    public List<FireFightingEquipment> getAllFireFightingEquipmentByPage(PageBean pageBean) {
        return dao.getAllFireFightingEquipmentByPage(pageBean);
    }

    public List<SecurityGuardEquipment> getAllSecurityGuardEquipmentByPage(PageBean pageBean) {
        return dao.getAllSecurityGuardEquipmentByPage(pageBean);
    }

    public Equipment findEquipmentById(int equipmentId) {
        return dao.findEquipmentById(equipmentId);
    }

    public int addFireFightingEquipment(FireFightingEquipment fireFightingEquipment) {
        return dao.addFireFightingEquipment(fireFightingEquipment);
    }

    public int addSecurityGuardEquipment(SecurityGuardEquipment securityGuardEquipment) {
        return dao.addSecurityGuardEquipment(securityGuardEquipment);
    }

    public int updateEquipment(Equipment equipment) {
        return dao.updateEquipment(equipment);
    }

    public int deleteEquipment(int equipmentId) {
        return dao.deleteEquipment(equipmentId);
    }

}
