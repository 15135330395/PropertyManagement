package com.客户关系管理.entity;

import java.util.Date;

/**
 * @author：Ganlan；
 * @date：2019-03-25；
 */

public class ServiceDispathing {

    //派工单编号
    private int sdId;
    //派工地址
    private String addr;
    //派工事由
    private String things;
    // 派工人员姓名
    private String workerName;
    // 编号
    private String workerId;
    // 派工时间
    private Date startTime;
    // 装修结束时间
    private Date endTime;
    // 联系方式
    private String phone;
    // 客户验收
    private String customerCheck;
    // 物料领用记录
    private String material;
    // 服务费用
    private double serviceCost;
    // 物料成本费用
    private double materialCost;
    // 其他增加服务项目
    private String otherService;

    public ServiceDispathing(int sdId, String addr, String things, String workerName, String workerId, Date startTime, Date endTime, String phone, String customerCheck, String material, double serviceCost, double materialCost, String otherService) {
        this.sdId = sdId;
        this.addr = addr;
        this.things = things;
        this.workerName = workerName;
        this.workerId = workerId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.phone = phone;
        this.customerCheck = customerCheck;
        this.material = material;
        this.serviceCost = serviceCost;
        this.materialCost = materialCost;
        this.otherService = otherService;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorker_name(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorker_id(String workerId) {
        this.workerId = workerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStart_time(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEnd_time(Date endTime) {
        this.endTime = endTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerCheck() {
        return customerCheck;
    }

    public void setCustomer_check(String customerCheck) {
        this.customerCheck = customerCheck;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setService_cost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterial_cost(double materialCost) {
        this.materialCost = materialCost;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOther_service(String otherService) {
        this.otherService = otherService;
    }

    public int getSdId() {
        return sdId;
    }

    public void setSd_id(int sdId) {
        this.sdId = sdId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }
}
