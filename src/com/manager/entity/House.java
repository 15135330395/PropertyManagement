package com.manager.entity;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public class House {

    private int houseId;
    private String acreage;
    private String ues;
    private String houseType;

    public House() {
    }

    public House(int houseId, String acreage, String ues, String houseType) {
        this.houseId = houseId;
        this.acreage = acreage;
        this.ues = ues;
        this.houseType = houseType;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getUes() {
        return ues;
    }

    public void setUes(String ues) {
        this.ues = ues;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
}
