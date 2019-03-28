package com.personnel.entity;

/**
 * 考核表
 */
public class Kpi {
	private int kpiId;
	private String staffName;
	private String departmentName;
//	评价内容
	private String evaluateContent;
//	评级人
	private String evaluatePerson;
//	考核成绩
	private int evaluateGrade;
	public Kpi(){
	}

    public Kpi(int kpiId, String staffName, String departmentName, String evaluateContent, String evaluatePerson, int evaluateGrade) {
        this.kpiId = kpiId;
        this.staffName = staffName;
        this.departmentName = departmentName;
        this.evaluateContent = evaluateContent;
        this.evaluatePerson = evaluatePerson;
        this.evaluateGrade = evaluateGrade;
    }

    public int getKpiId() {
        return kpiId;
    }

    public void setKpi_id(int kpiId) {
        this.kpiId = kpiId;
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

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluate_content(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluatePerson() {
        return evaluatePerson;
    }

    public void setEvaluate_person(String evaluatePerson) {
        this.evaluatePerson = evaluatePerson;
    }

    public int getEvaluateGrade() {
        return evaluateGrade;
    }

    public void setEvaluate_grade(int evaluateGrade) {
        this.evaluateGrade = evaluateGrade;
    }
}

