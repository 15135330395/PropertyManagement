package com.客户关系管理.entity;

import java.util.Date;

/**
 * @author：Ganlan；
 * @date：2019-03-25；
 */

public class DecorateApply {


    //装修申请ID
    private int id;
    //住户名字
    private String name;
    // 住户地址
    private String addr;
    // 联系方式
    private String phone;
    // 处理与未处理
    private String state;
    // 申请时间
    private Date applyTime;
    // 二次装修内容
    private String secondaryDecorate;
    // 退装修押金
    private double refunding;

    public DecorateApply(int id,String name, String addr, String phone, String state, Date applyTime, String secondaryDecorate, double refunding) {
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.state = state;
        this.applyTime = applyTime;
        this.secondaryDecorate = secondaryDecorate;
        this.refunding = refunding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApply_time(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getSecondaryDecorate() {
        return secondaryDecorate;
    }

    public void setSecondary_decorate(String secondaryDecorate) {
        this.secondaryDecorate = secondaryDecorate;
    }

    public double getRefunding() {
        return refunding;
    }

    public void setRefunding(double refunding) {
        this.refunding = refunding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
