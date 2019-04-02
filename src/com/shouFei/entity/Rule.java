package com.shouFei.entity;

import java.util.Date;

/**
 * @Acthor:孙琪; date:2019/4/1;
 */
public class Rule {
    //常规费用    房租 物业费
    private int ruleId;//抄表id
    private String plotName;//小区名
    private String roomNumber;//房间号
    private String payName;//收费项目名称
    private String normName;//收费标准名称
    private double price;
    private double area;
    private int closeEnd;
    private Date riqi;
    private double money;//==price*area  房租
    private double money2;//停车费
    private double moneysum;//总金额

    public int getCloseEnd() {
        return closeEnd;
    }

    public void setCloseEnd(int closeEnd) {
        this.closeEnd = closeEnd;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getNormName() {
        return normName;
    }

    public void setNormName(String normName) {
        this.normName = normName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Date getRiqi() {
        return riqi;
    }

    public void setRiqi(Date riqi) {
        this.riqi = riqi;
    }

    public double getMoney() {
        return price*area;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney2() {
        return money2;
    }

    public void setMoney2(double money2) {
        this.money2 = money2;
    }

    public double getMoneysum() {
        return price*area+closeEnd+money2;
    }

    public void setMoneysum(double moneysum) {
        this.moneysum = moneysum;
    }

    public Rule() {
    }

    public Rule(int ruleId, String plotName, String roomNumber, String payName, String normName, double price, double area, int closeEnd, Date riqi, double money, double money2, double moneysum) {
        this.ruleId = ruleId;
        this.plotName = plotName;
        this.roomNumber = roomNumber;
        this.payName = payName;
        this.normName = normName;
        this.price = price;
        this.area = area;
        this.closeEnd = closeEnd;
        this.riqi = riqi;
        this.money = money;
        this.money2 = money2;
        this.moneysum = moneysum;
    }
    public Rule( String plotName, String roomNumber, String payName, String normName, double price, double area, int closeEnd, Date riqi, double money, double money2, double moneysum) {
        this.plotName = plotName;
        this.roomNumber = roomNumber;
        this.payName = payName;
        this.normName = normName;
        this.price = price;
        this.area = area;
        this.closeEnd = closeEnd;
        this.riqi = riqi;
        this.money = money;
        this.money2 = money2;
        this.moneysum = moneysum;
    }
    public Rule(int ruleId,String plotName, String roomNumber, String payName, String normName, double price, double area, int closeEnd, Date riqi, double money2) {
        this.ruleId = ruleId;
        this.plotName = plotName;
        this.roomNumber = roomNumber;
        this.payName = payName;
        this.normName = normName;
        this.price = price;
        this.area = area;
        this.closeEnd = closeEnd;
        this.riqi = riqi;
        this.money2 = money2;
    }
    public Rule(String plotName, String roomNumber, String payName, String normName, double price, double area, int closeEnd, Date riqi, double money2) {
        this.plotName = plotName;
        this.roomNumber = roomNumber;
        this.payName = payName;
        this.normName = normName;
        this.price = price;
        this.area = area;
        this.closeEnd = closeEnd;
        this.riqi = riqi;
        this.money2 = money2;
    }
}
