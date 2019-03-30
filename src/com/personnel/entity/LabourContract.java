package com.personnel.entity;

import java.util.Date;

/**
 * 劳动合同
 */
public class LabourContract {
	private int labourContractId;
//	甲方单位名称
	private String companyName;
	private String staffName;
//	签订的劳动时间
	private String jobTime;
//	签订时间
	private Date signTime;
//	基本工资
	private double basicSalary;
	public LabourContract(){
	}

    public LabourContract(int labourContractId, String companyName, String staffName,  String jobTime, Date signTime, double basicSalary) {
        this.labourContractId = labourContractId;
        this.companyName = companyName;
        this.staffName = staffName;
        this.jobTime = jobTime;
        this.signTime = signTime;
        this.basicSalary = basicSalary;
    }

    public LabourContract(String companyName, String staffName, String jobTime, Date signTime, double basicSalary) {
        this.companyName = companyName;
        this.staffName = staffName;
        this.jobTime = jobTime;
        this.signTime = signTime;
        this.basicSalary = basicSalary;
    }

    public int getLabourContractId() {
        return labourContractId;
    }

    public void setLabour_contract_id(int labourContractId) {
        this.labourContractId = labourContractId;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompany_name(String companyName) {
        this.companyName = companyName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaff_name(String staffName) {
        this.staffName = staffName;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJob_time(String jobTime) {
        this.jobTime = jobTime;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSign_time(Date signTime) {
        this.signTime = signTime;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasic_salary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
}

