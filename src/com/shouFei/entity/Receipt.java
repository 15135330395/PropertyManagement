package com.shouFei.entity;

import java.util.Date;

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
public class Receipt {
    private int rid;
    private String department;
    private int staffId;
    private String staffName;
    private double monery;
    private String payName;//原因
    private String transactor;//收款人
    private Date shijian;

    public Receipt() {
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public double getMonery() {
        return monery;
    }

    public void setMonery(double monery) {
        this.monery = monery;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getTransactor() {
        return transactor;
    }

    public void setTransactor(String transactor) {
        this.transactor = transactor;
    }

    public Date getShijian() {
        return shijian;
    }

    public void setShijian(Date shijian) {
        this.shijian = shijian;
    }

    public Receipt(int rid, String department, int staffId, String staffName, double monery, String payName, String transactor, Date shijian) {
        this.rid = rid;
        this.department = department;
        this.staffId = staffId;
        this.staffName = staffName;
        this.monery = monery;
        this.payName = payName;
        this.transactor = transactor;
        this.shijian = shijian;
    }
    public Receipt(String department, int staffId, String staffName, double monery, String payName, String transactor, Date shijian) {
        this.department = department;
        this.staffId = staffId;
        this.staffName = staffName;
        this.monery = monery;
        this.payName = payName;
        this.transactor = transactor;
        this.shijian = shijian;
    }
}
