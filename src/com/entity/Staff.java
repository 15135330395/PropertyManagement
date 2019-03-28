package com.entity;

import java.util.Date;

public class Staff {
    //工号
	private int staffId;
	//员工姓名
	private String staffName;
	//员工照片
	private String staffImage;
	//身份证
	private String identityCard;

	private int age;
	private String sex;
	private String address;
	private String phone;
	private String email;
	//所在城市
	private String city;
	//籍贯
	private String household;
	//职位
	private String station;
	//学历
	private String education;
	//部门号
	private int departmentId;
	private int salaryId;
    //社保号
	private int securityInsuranceId;
	private Date joinTime;
	private String departmentName;

	public Staff(){
	}

    public Staff(String staffName, String staffImage, String identityCard, int age, String sex, String address, String phone, String email, String city, String household, String station, String education, int departmentId, int salaryId, int securityInsuranceId, Date joinTime) {
        this.staffName = staffName;
        this.staffImage = staffImage;
        this.identityCard = identityCard;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.household = household;
        this.station = station;
        this.education = education;
        this.departmentId = departmentId;
        this.salaryId = salaryId;
        this.securityInsuranceId = securityInsuranceId;
        this.joinTime = joinTime;

    }

    public Staff(int staffId, String staffName, String staffImage, String identityCard, int age, String sex, String address, String phone, String email, String city, String household, String station, String education, int departmentId, int salaryId, int securityInsuranceId, Date joinTime) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffImage = staffImage;
        this.identityCard = identityCard;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.household = household;
        this.station = station;
        this.education = education;
        this.departmentId = departmentId;
        this.salaryId = salaryId;
        this.securityInsuranceId = securityInsuranceId;
        this.joinTime = joinTime;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartment_name(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoin_time(Date joinTime) {
        this.joinTime = joinTime;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffImage() {
        return staffImage;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getHousehold() {
        return household;
    }

    public String getStation() {
        return station;
    }

    public String getEducation() {
        return education;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public int getSecurityInsuranceId() {
        return securityInsuranceId;
    }

    public void setStaff_id(int staffId) {
        this.staffId = staffId;
    }

    public void setStaff_name(String staffName) {
        this.staffName = staffName;
    }

    public void setStaff_image(String staffImage) {
        this.staffImage = staffImage;
    }

    public void setIdentity_card(String identityCard) {
        this.identityCard = identityCard;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary_id(int salaryId) {
        this.salaryId = salaryId;
    }

    public void setSecurity_insuranceId(int securityInsuranceId) {
        this.securityInsuranceId = securityInsuranceId;
    }

}

