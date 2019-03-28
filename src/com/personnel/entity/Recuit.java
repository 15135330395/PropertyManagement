package com.personnel.entity;


/**
 * @author: LiGX
 * @Date: 2019-03-28 上午 8:46
 * 招聘表
 */
public class Recuit {
    private int recuitId;
//    招聘岗位
    private String recuitPosition;
//    招聘人数
    private int recuitCount;
//    岗位职责
    private String duty;
//    岗位要求
    private String demand;
//    基本工资
    private double basicSalary;

    public Recuit(int recuitId, String recuitPosition, int recuitCount, String duty, String demand, double basicSalary) {
        this.recuitId = recuitId;
        this.recuitPosition = recuitPosition;
        this.recuitCount = recuitCount;
        this.duty = duty;
        this.demand = demand;
        this.basicSalary = basicSalary;
    }

    public Recuit(){
    }

    public int getRecuitId() {
        return recuitId;
    }

    public void setrecuit_id(int recuitId) {
        this.recuitId = recuitId;
    }

    public String getRecuitPosition() {
        return recuitPosition;
    }

    public void setRecuit_position(String recuitPosition) {
        this.recuitPosition = recuitPosition;
    }

    public int getRecuitCount() {
        return recuitCount;
    }

    public void setRecuit_count(int recuitCount) {
        this.recuitCount = recuitCount;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasic_salary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
