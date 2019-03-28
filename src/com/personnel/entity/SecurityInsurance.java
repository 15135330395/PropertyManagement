package com.personnel.entity;

/**
 * 社保表
 */
public class SecurityInsurance {
//    社保号
	private int securityInsuranceId;
	private int staffName;
//	所在城市
	private String city;
//	岗位
	private String station;
//	学历
	private String education;
//	户籍
	private String household;
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
	public SecurityInsurance(){
	}

    public SecurityInsurance(int securityInsuranceId, int staffName, String city, String station, String education, String household, int endowmentInsurance, int medicalInsurance, int unemploymentInsurance, int employmentInjuryInsurance, int maternityInsurance, int publicHousingFunds) {
        this.securityInsuranceId = securityInsuranceId;
        this.staffName = staffName;
        this.city = city;
        this.station = station;
        this.education = education;
        this.household = household;
        this.endowmentInsurance = endowmentInsurance;
        this.medicalInsurance = medicalInsurance;
        this.unemploymentInsurance = unemploymentInsurance;
        this.employmentInjuryInsurance = employmentInjuryInsurance;
        this.maternityInsurance = maternityInsurance;
        this.publicHousingFunds = publicHousingFunds;
    }

    public int getSecurityInsuranceId() {
        return securityInsuranceId;
    }

    public void setSecurity_insuranceId(int securityInsuranceId) {
        this.securityInsuranceId = securityInsuranceId;
    }

    public int getStaffName() {
        return staffName;
    }

    public void setStaff_name(int staffName) {
        this.staffName = staffName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
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
}

