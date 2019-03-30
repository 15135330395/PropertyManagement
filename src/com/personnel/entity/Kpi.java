package com.personnel.entity;

/**
 * 考核表
 */
public class Kpi {
	private int kpiId;
    private int staffId;
	private String staffName;
//	评价内容
	private String evaluateContent;
//	评级人
	private String evaluatePerson;
//	考核成绩
	private int evaluateGrade;
	public Kpi(){
	}

    public Kpi(int kpiId,int evaluateGrade) {
        this.kpiId = kpiId;
        this.evaluateGrade = evaluateGrade;
    }

    public Kpi(int kpiId, int staffId, String evaluateContent, String evaluatePerson) {
        this.kpiId = kpiId;
        this.staffId = staffId;


        this.evaluateContent = evaluateContent;
        this.evaluatePerson = evaluatePerson;
    }

    public Kpi(int staffId, String staffName,  String evaluateContent, String evaluatePerson, int evaluateGrade) {
        this.staffId = staffId;
        this.staffName = staffName;

        this.evaluateContent = evaluateContent;
        this.evaluatePerson = evaluatePerson;
        this.evaluateGrade = evaluateGrade;
    }

    public Kpi(int kpiId, int staffId, String staffName, String evaluateContent, String evaluatePerson, int evaluateGrade) {
        this.kpiId = kpiId;
        this.staffId = staffId;
        this.staffName = staffName;

        this.evaluateContent = evaluateContent;
        this.evaluatePerson = evaluatePerson;
        this.evaluateGrade = evaluateGrade;
    }

    public Kpi(int staffId,  String evaluateContent, String evaluatePerson) {
        this.staffId = staffId;

        this.evaluateContent = evaluateContent;
        this.evaluatePerson = evaluatePerson;
    }


    public int getStaffId() {
        return staffId;
    }

    public void setStaff_id(int staffId) {
        this.staffId = staffId;
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

