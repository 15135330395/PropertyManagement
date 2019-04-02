package com.客户关系管理.entity;

import java.util.Date;

/**
 * @author：Ganlan；
 * @date：2019-03-25；
 */

public class CustomerFeedback {

    // 反馈编号
    private int id;
    // 住户名字
    private String name;
    // 住户地址
    private String addr;
    // 联系方式
    private String phone;
    // 反馈时间
    private Date feedbackTime;
    // 处理时间
    private Date disposeTime;
    // 反馈内容
    private String feedback;
    // 状态
    private String dispose = "未处理";

    public CustomerFeedback(int id,String name, String addr, String phone, Date feedbackTime, Date disposeTime, String feedback, String dispose) {
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.feedbackTime = feedbackTime;
        this.disposeTime = disposeTime;
        this.feedback = feedback;
        this.dispose = dispose;
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

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedback_time(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Date getDisposeTime() {
        return disposeTime;
    }

    public void setDispose_time(Date disposeTime) {
        this.disposeTime = disposeTime;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDispose() {
        return dispose;
    }

    public void setDispose(String dispose) {
        this.dispose = dispose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerFeedback() {
    }


    @Override
    public String toString() {
        return "CustomerFeedback{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                ", feedbackTime=" + feedbackTime +
                ", disposeTime=" + disposeTime +
                ", feedback='" + feedback + '\'' +
                ", dispose='" + dispose + '\'' +
                '}';
    }
}
