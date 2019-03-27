package com.logistics.entity;

import java.util.Date;

/**
 * @Description 保安器材的使用记录
 * @Author WYR
 * @CreateTime 2019-03-26 12:05
 */
public class OperatingRecord {
    private int recordId;
    private int staffId;
    private String staffName;
    private String equipmentName;
    private Date borrowingTime;
    private Date returnTime;

    public OperatingRecord() {
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecord_id(int recordId) {
        this.recordId = recordId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaff_id(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaff_name(String staffName) {
        this.staffName = staffName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipment_name(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Date getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowing_time(Date borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturn_time(Date returnTime) {
        this.returnTime = returnTime;
    }
}
