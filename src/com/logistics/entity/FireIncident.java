package com.logistics.entity;

import java.sql.Time;
import java.util.Date;

/**
 * @Description 消防事故
 * @Author WYR
 * @CreateTime 2019-03-26 17:29
 */
public class FireIncident {

    private int incidentId;
    private Date alarmTime;
    private String incidentLocale;
    private int[] staffId;
    private String[] staffName;
    private String cause;
    private String loss;

    public FireIncident() {
    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncident_id(int incidentId) {
        this.incidentId = incidentId;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarm_time(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getIncidentLocale() {
        return incidentLocale;
    }

    public void setIncident_locale(String incidentLocale) {
        this.incidentLocale = incidentLocale;
    }

    public int[] getStaffId() {
        return staffId;
    }

    public void setStaff_id(int[] staffId) {
        this.staffId = staffId;
    }

    public String[] getStaffName() {
        return staffName;
    }

    public void setStaff_name(String[] staffName) {
        this.staffName = staffName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }
}
