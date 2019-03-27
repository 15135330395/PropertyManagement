package com.logistics.entity;

import java.util.Date;

/**
 * @Description 保安排班表
 * @Author WYR
 * @CreateTime 2019-03-26 11:12
 */
public class GuardRota {
    private int rotaId;
    private Date rotaStart;
    private Date rotaEnd;
    private int staffId;
    private String staffName;
    private Date clockIn;
    private Date clockOut;

    public GuardRota() {
    }

    public int getRotaId() {
        return rotaId;
    }

    /**
     * 20190326 001
     * 排班表编号：时间+001...004
     *
     * @param rotaId
     */
    public void setRota_id(int rotaId) {
        this.rotaId = rotaId;
    }

    public Date getRotaStart() {
        return rotaStart;
    }

    public void setRota_start(Date rotaStart) {
        this.rotaStart = rotaStart;
    }

    public Date getRotaEnd() {
        return rotaEnd;
    }

    public void setRota_end(Date rotaEnd) {
        this.rotaEnd = rotaEnd;
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

    public Date getClockIn() {
        return clockIn;
    }

    public void setClock_in(Date clockIn) {
        this.clockIn = clockIn;
    }

    public Date getClockOut() {
        return clockOut;
    }

    public void setClock_out(Date clockOut) {
        this.clockOut = clockOut;
    }
}
