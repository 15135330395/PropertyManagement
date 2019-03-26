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
    private String staffName;
    private String cause;
    private String loss;

    public FireIncident() {
    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getIncidentLocale() {
        return incidentLocale;
    }

    public void setIncidentLocale(String incidentLocale) {
        this.incidentLocale = incidentLocale;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
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
