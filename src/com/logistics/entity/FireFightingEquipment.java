package com.logistics.entity;

import com.entity.Equipment;

/**
 * @Description 消防器材
 * @Author WYR
 * @CreateTime 2019-03-26 11:45
 */
public class FireFightingEquipment extends Equipment {
    public FireFightingEquipment() {
    }

    public FireFightingEquipment(String equipmentName, String amount) {
        super(equipmentName,amount);
    }
}

