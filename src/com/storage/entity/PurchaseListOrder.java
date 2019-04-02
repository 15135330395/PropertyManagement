package com.storage.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 14:49
 * Description:采购订单
 */
public class PurchaseListOrder {
    private int id;
    private String goodName;
    private int numbers;
    private int cost;
    private String date;
    private String listNumber;
    public PurchaseListOrder() {
    }

    @Override
    public String toString() {
        return "PurchaseListOrder{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", numbers=" + numbers +
                ", cost=" + cost +
                ", date='" + date + '\'' +
                ", listNumber='" + listNumber + '\'' +
                '}';
    }

    public PurchaseListOrder(int id, String goodName, int numbers, int cost, String date, String listNumber) {
        this.id = id;
        this.goodName = goodName;
        this.numbers = numbers;
        this.cost = cost;
        this.date = date;
        this.listNumber = listNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getListNumber() {
        return listNumber;
    }

    public void setListNumber(String listNumber) {
        this.listNumber = listNumber;
    }
}
