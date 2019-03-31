package com.personnel.entity;

/**
 * 薪酬表
 */
public class Salary {
	private int salaryId;
	private int staffId;
	private String staffName;
	private double basicSalary;
	private int attantanceId;
	private int kpiId;
    private int securityInsuranceId;
    private int evaluateGrade;
    private double bonuses;
    private double insurance;
    private double ondutyPay;
    private double abnormalPay;
    private double leavePay;
	private double pay;
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

    public Salary(int staffId, double basicSalary, int attantanceId, int kpiId,int securityInsuranceId) {
        this.staffId = staffId;
        this.basicSalary = basicSalary;
        this.attantanceId = attantanceId;
        this.kpiId = kpiId;
        this.securityInsuranceId = securityInsuranceId;
    }
    public Salary(int staffId, double basicSalary, int attantanceId, int kpiId,double pay) {
        this.staffId = staffId;
        this.basicSalary = basicSalary;
        this.attantanceId = attantanceId;
        this.kpiId = kpiId;
        this.pay=pay;
    }
    public Salary(int salaryId,int staffId, double basicSalary, int attantanceId, int kpiId,int securityInsuranceId) {
        this.salaryId = salaryId;
	    this.staffId = staffId;
        this.basicSalary = basicSalary;
        this.attantanceId = attantanceId;
        this.kpiId = kpiId;
        this.securityInsuranceId = securityInsuranceId;
    }
    public double getPay() {
        return (basicSalary/workDay)*(workDay-sickLeave-affairLeave+onduty-abnormal);
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
    public double getOndutyPay() {
        return (basicSalary/workDay)*onduty*2;
    }

    public void setOndutyPay(double ondutyPay) {
        this.ondutyPay = ondutyPay;
    }

    public double getAbnormalPay() {
        return (basicSalary/workDay)*abnormal*3;
    }

    public void setAbnormalPay(double abnormalPay) {
        this.abnormalPay = abnormalPay;
    }

    public double getLeavePay() {
        return (basicSalary/workDay)*(sickLeave*0.6+affairLeave);
    }

    public void setLeavePay(double leavePay) {
        this.leavePay = leavePay;
    }

    public double getBonuses() {
        return evaluateGrade*0.2*basicSalary;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    public double getInsurance() {
        return basicSalary*(endowmentInsurance*0.08+ medicalInsurance*0.02+
                unemploymentInsurance*0.005+publicHousingFunds*0.07);
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public int getActualAttendance() {

        return workDay-sickLeave-affairLeave+onduty-abnormal;
    }


    public int getSalaryId() {
        return salaryId;
    }

    public void setSalary_id(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getKpiId() {
        return kpiId;
    }

    public void setKpi_id(int kpiId) {
        this.kpiId = kpiId;
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

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasic_salary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getAttantanceId() {
        return attantanceId;
    }

    public void setAttantance_id(int attantanceId) {
        this.attantanceId = attantanceId;
    }

    public int getEndowmentInsurance() {
        return endowmentInsurance;
    }

    public void setEndowment_insurance(int endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance;
    }

    public int getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedical_insurance(int medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public int getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    public void setUnemployment_insurance(int unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    public int getEmploymentInjuryInsurance() {
        return employmentInjuryInsurance;
    }

    public void setEmployment_injury_insurance(int employmentInjuryInsurance) {
        this.employmentInjuryInsurance = employmentInjuryInsurance;
    }

    public int getMaternityInsurance() {
        return maternityInsurance;
    }

    public void setMaternity_insurance(int maternityInsurance) {
        this.maternityInsurance = maternityInsurance;
    }

    public int getPublicHousingFunds() {
        return publicHousingFunds;
    }

    public void setPublic_housing_funds(int publicHousingFunds) {
        this.publicHousingFunds = publicHousingFunds;
    }

    public int getEvaluateGrade() {
        return evaluateGrade;
    }

    public void setEvaluate_grade(int evaluateGrade) {
        this.evaluateGrade = evaluateGrade;
    }

    public int getSecurityInsuranceId() {
        return securityInsuranceId;
    }

    public void setSecurity_insurance_id(int securityInsuranceId) {
        this.securityInsuranceId = securityInsuranceId;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWork_day(int workDay) {
        this.workDay = workDay;
    }

    public void setActual_attendance(int actualAttendance) {
        this.actualAttendance = actualAttendance;
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

    public void setOnduty(int onduty) {
        this.onduty = onduty;
    }

    public int getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(int abnormal) {
        this.abnormal = abnormal;
    }
}

