package com.entity;

/**
 * @Description 所有器材
 * @Author WYR
 * @CreateTime 2019-03-26 11:46
 */
public class Equipment {
    private int equipmentId;
    private String equipmentType;
    private String equipmentName;

    public Equipment() {
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

}
