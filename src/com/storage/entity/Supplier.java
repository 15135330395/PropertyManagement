package com.storage.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 14:53
 * Description: 供应商信息
 */
public class Supplier {
    private int id;
    private String name;
    private String contactPerson;
    private String contactPhone;
    private String goodName;
    private int goodPrice;

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                '}';
    }

    public Supplier(int id, String name, String contactPerson, String contactPhone, String goodName, int goodPrice) {
        this.id = id;
        this.name = name;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(int goodPrice) {
        this.goodPrice = goodPrice;
    }
}
