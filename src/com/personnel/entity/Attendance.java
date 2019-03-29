package com.personnel.entity;

/**
 * 出勤表
 */
public class Attendance {
	private int attendanceId;
	private int staffId;
	private String staffName;
	private String departmentName;
//	应工作天数
	private int workDay;
//	实际出勤天数
	private int actualAttendance;
//	病假
	private int sickLeave;
//	事假
	private int affairLeave;
//	加班
	private int onduty;
//	旷工
	private int abnormal;
	public Attendance(){
	}

    public Attendance(int attendanceId, int staffId, String staffName, String departmentName, int workDay, int actualAttendance, int sickLeave, int affairLeave, int onduty, int abnormal) {
        this.attendanceId = attendanceId;
        this.staffId = staffId;
        this.staffName = staffName;
        this.departmentName = departmentName;
        this.workDay = workDay;
        this.actualAttendance = actualAttendance;
        this.sickLeave = sickLeave;
        this.affairLeave = affairLeave;
        this.onduty = onduty;
        this.abnormal = abnormal;
    }

    public int getActualAttendance() {

	    return workDay-sickLeave-affairLeave+onduty-abnormal;
    }

    public void setActualAttendance(int actualAttendance) {
        this.actualAttendance = actualAttendance;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendance_id(int attendanceId) {
        this.attendanceId = attendanceId;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartment_name(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWork_day(int workDay) {
        this.workDay = workDay;
    }


    public int getSickLeave() {
        return sickLeave;
    }

    public void setSick_leave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    public int getAffairLeave() {
        return affairLeave;
    }

    public void setAffair_leave(int affairLeave) {
        this.affairLeave = affairLeave;
    }

    public int getOnduty() {
        return onduty;
    }

    public int getAbnormal() {
        return abnormal;
    }

    public void setOnduty(int onduty){
		this.onduty=onduty;
	}
	public void setAbnormal(int abnormal){
		this.abnormal=abnormal;
	}
}

