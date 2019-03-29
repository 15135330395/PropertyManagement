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
    private String staffNames;
    private String cause;
    private String loss;

    public FireIncident() {
    }

    public FireIncident(Date alarmTime, String incidentLocale, String staffNames, String cause, String loss) {
        this.alarmTime = alarmTime;
        this.incidentLocale = incidentLocale;
        this.staffNames = staffNames;
        this.cause = cause;
        this.loss = loss;
    }

    public FireIncident(int incidentId, Date alarmTime, String incidentLocale, String staffNames, String cause, String loss) {
        this.incidentId = incidentId;
        this.alarmTime = alarmTime;
        this.incidentLocale = incidentLocale;
        this.staffNames = staffNames;
        this.cause = cause;
        this.loss = loss;
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

    public String getStaffNames() {
        return staffNames;
    }

    public void setStaff_names(String staffNames) {
        this.staffNames = staffNames;
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
