package com.logistics.entity;

import com.entity.Equipment;

/**
 * @Description 安保器材
 * @Author WYR
 * @CreateTime 2019-03-26 11:39
 */
public class SecurityGuardEquipment extends Equipment {
    public SecurityGuardEquipment() {
    }

    public SecurityGuardEquipment(String equipmentName, String amount) {
        super(equipmentName, amount);
    }
}
