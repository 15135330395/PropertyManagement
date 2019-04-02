package com.客户关系管理.entity;

/**
 * @author：Ganlan；
 * @date：2019-03-28；
 */


public class Customer {

    //客户ID
    private int id;
    //客户名称
    private String name;
    // 设置客户信息包括的客户性质（租户、现业户、前业主）
    private String customerNature;
    //联系方式
    private String phone;
    //证件号码
    private String idCard;
    // 车辆
    private String car = "无";
    // 宠物
    private String pet = "无";
    // 住户地址
    private String addr;

    public Customer(String name, String customerNature, String phone, String idCard, String car, String pet, String addr) {
        this.name = name;
        this.customerNature = customerNature;
        this.phone = phone;
        this.idCard = idCard;
        this.car = car;
        this.pet = pet;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerNature() {
        return customerNature;
    }

    public void setCustomerNature(String customerNature) {
        this.customerNature = customerNature;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customerNature='" + customerNature + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", car='" + car + '\'' +
                ", pet='" + pet + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
