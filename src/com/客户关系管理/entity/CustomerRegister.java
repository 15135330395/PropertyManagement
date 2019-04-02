package com.客户关系管理.entity;

import java.util.Date;

/**
 * @author：Ganlan；
 * @date：2019-03-25；
 */

public class CustomerRegister {


    // 登记ID
    private int id;
    // 客户姓名
    private String name;
    // 入伙时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 联系方式
    private String phone;
    // 证件号码
    private String addr;
    // 验收情况
    private String checkAccept;
    // 钥匙发放情况
    private String keyState;

    public CustomerRegister( String name, Date startTime, String phone, String addr, String checkAccept, String keyState) {
        this.name = name;
        this.startTime = startTime;
        this.phone = phone;
        this.addr = addr;
        this.checkAccept = checkAccept;
        this.keyState = keyState;
    }

    public CustomerRegister( String name, String phone, String addr, String checkAccept, String keyState) {
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.checkAccept = checkAccept;
        this.keyState = keyState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckAccept() {
        return checkAccept;
    }

    public void setCheckAccept(String checkAccept) {
        this.checkAccept = checkAccept;
    }

    public String getKeyState() {
        return keyState;
    }

    public void setKeyState(String keyState) {
        this.keyState = keyState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerRegister() {
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "CustomerRegister{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                ", checkAccept='" + checkAccept + '\'' +
                ", keyState='" + keyState + '\'' +
                '}';
    }
}
