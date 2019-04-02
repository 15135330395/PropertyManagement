package com.storage.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 14:44
 * Description: 采购分单
 */
public class PurchaseDeliver {
    private int id;
    private String goodName;
    private String supplier1Name;
    private int supplier1Price;
    private int supplier1Numbers;
    private String supplier2Name;
    private int supplier2Price;
    private int supplier2Numbers;
    private int total;

    @Override
    public String toString() {
        return "PurchaseDeliver{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", supplier1Name='" + supplier1Name + '\'' +
                ", supplier1Price=" + supplier1Price +
                ", supplier1Numbers=" + supplier1Numbers +
                ", supplier2Name='" + supplier2Name + '\'' +
                ", supplier2Price=" + supplier2Price +
                ", supplier2Numbers=" + supplier2Numbers +
                ", total=" + total +
                '}';
    }

    public PurchaseDeliver() {
    }

    public PurchaseDeliver(int id, String goodName, String supplier1Name, int supplier1Price, int supplier1Numbers, String supplier2Name, int supplier2Price, int supplier2Numbers, int total) {
        this.id = id;
        this.goodName = goodName;
        this.supplier1Name = supplier1Name;
        this.supplier1Price = supplier1Price;
        this.supplier1Numbers = supplier1Numbers;
        this.supplier2Name = supplier2Name;
        this.supplier2Price = supplier2Price;
        this.supplier2Numbers = supplier2Numbers;
        this.total = total;
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

    public String getSupplier1Name() {
        return supplier1Name;
    }

    public void setSupplier1Name(String supplier1Name) {
        this.supplier1Name = supplier1Name;
    }

    public int getSupplier1Price() {
        return supplier1Price;
    }

    public void setSupplier1Price(int supplier1Price) {
        this.supplier1Price = supplier1Price;
    }

    public int getSupplier1Numbers() {
        return supplier1Numbers;
    }

    public void setSupplier1Numbers(int supplier1Numbers) {
        this.supplier1Numbers = supplier1Numbers;
    }

    public String getSupplier2Name() {
        return supplier2Name;
    }

    public void setSupplier2Name(String supplier2Name) {
        this.supplier2Name = supplier2Name;
    }

    public int getSupplier2Price() {
        return supplier2Price;
    }

    public void setSupplier2Price(int supplier2Price) {
        this.supplier2Price = supplier2Price;
    }

    public int getSupplier2Numbers() {
        return supplier2Numbers;
    }

    public void setSupplier2Numbers(int supplier2Numbers) {
        this.supplier2Numbers = supplier2Numbers;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
