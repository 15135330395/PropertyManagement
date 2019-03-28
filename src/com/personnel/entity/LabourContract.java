package com.personnel.entity;

import java.util.Date;

/**
 * 劳动合同
 */
public class LabourContract {
	private int labourContractId;
	//合同序号
	private int labourContractUuid;
//	甲方单位名称
	private String companyName;
	private String staffName;
	private String education;
	private String sex;
	private int identiyCard;
	private String address;
//	签订的劳动时间
	private Date jobTime;
//	签订时间
	private Date signTime;
//	基本工资
	private double basicSalary;
	public LabourContract(){
	}

    public LabourContract(int labourContractId, int labourContractUuid, String companyName, String staffName, String education, String sex, int identiyCard, String address, Date jobTime, Date signTime, double basicSalary) {
        this.labourContractId = labourContractId;
        this.labourContractUuid = labourContractUuid;
        this.companyName = companyName;
        this.staffName = staffName;
        this.education = education;
        this.sex = sex;
        this.identiyCard = identiyCard;
        this.address = address;
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

    public int getLabourContractUuid() {
        return labourContractUuid;
    }

    public void setLabour_contract_uuid(int labourContractUuid) {
        this.labourContractUuid = labourContractUuid;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIdentiyCard() {
        return identiyCard;
    }

    public void setIdentiy_card(int identiyCard) {
        this.identiyCard = identiyCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJobTime() {
        return jobTime;
    }

    public void setJob_time(Date jobTime) {
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

