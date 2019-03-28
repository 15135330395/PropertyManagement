package com.personnel.entity;

/**
 * 面试表
 */
public class Interview {
	private int interviewId;
//	面试申请人
	private String applyName;
	private String applySex;
	private int applyAge;
//	申请岗位
	private String applyPosition;
	private String departmentName;
//	面试官
	private String interviewer;
//	是否录用
	private boolean offer;
	public Interview(){
	}

    public Interview(int interviewId, String applyName, String applySex, int applyAge, String applyPosition, String departmentName, String interviewer, boolean offer) {
        this.interviewId = interviewId;
        this.applyName = applyName;
        this.applySex = applySex;
        this.applyAge = applyAge;
        this.applyPosition = applyPosition;
        this.departmentName = departmentName;
        this.interviewer = interviewer;
        this.offer = offer;
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterview_id(int interviewId) {
        this.interviewId = interviewId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApply_name(String applyName) {
        this.applyName = applyName;
    }

    public String getApplySex() {
        return applySex;
    }

    public void setApply_sex(String applySex) {
        this.applySex = applySex;
    }

    public int getApplyAge() {
        return applyAge;
    }

    public void setApply_age(int applyAge) {
        this.applyAge = applyAge;
    }

    public String getApplyPosition() {
        return applyPosition;
    }

    public void setApply_position(String applyPosition) {
        this.applyPosition = applyPosition;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartment_name(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public boolean isOffer() {
        return offer;
    }

    public void setOffer(boolean offer) {
        this.offer = offer;
    }
}

