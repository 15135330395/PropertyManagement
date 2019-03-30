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
    private String amount;

    public Equipment() {
    }

    public Equipment(String equipmentName, String amount) {
        this.equipmentName = equipmentName;
        this.amount = amount;
    }

    public Equipment(int equipmentId, String equipmentName, String amount) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.amount = amount;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipment_id(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipment_type(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipment_name(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
