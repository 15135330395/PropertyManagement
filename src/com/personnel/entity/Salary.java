package com.personnel.entity;

/**
 * 薪酬表
 */
public class Salary {
	private int salaryId;
	private int salaryUuid;
	private int staffId;
	private String staffName;
	private double basicSalary;
	private int attantanceId;
	private double pay;
    //	应工作天数
    private int workDay;
    //	实际出勤天数
    private int actualAttendance;
    //	养老保险
    private int endowmentInsurance;
    //	医疗保险
    private int medicalInsurance;
    //	失业保险
    private int unemploymentInsurance;
    //	工伤保险
    private int employmentInjuryInsurance;
    //	生育保险
    private int maternityInsurance;
    //	住房公积金
    private int publicHousingFunds;

	public Salary(){
	}

    public Salary(int salaryId, int salaryUuid, int staffId, String staffName, double basicSalary, int attantanceId, double pay) {
        this.salaryId = salaryId;
        this.salaryUuid = salaryUuid;
        this.staffId = staffId;
        this.staffName = staffName;
        this.basicSalary = basicSalary;
        this.attantanceId = attantanceId;
        this.pay = pay;
    }

    public double getPay() {
        return (basicSalary/workDay)*actualAttendance-basicSalary*(endowmentInsurance*0.08- medicalInsurance*0.02-
                unemploymentInsurance*0.005-publicHousingFunds*0.07);
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getSalaryUuid() {
        return salaryUuid;
    }

    public void setSalaryUuid(int salaryUuid) {
        this.salaryUuid = salaryUuid;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getAttantanceId() {
        return attantanceId;
    }

    public void setAttantanceId(int attantanceId) {
        this.attantanceId = attantanceId;
    }
}

