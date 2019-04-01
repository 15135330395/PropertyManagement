package com.manager.entity;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public class House {

    private int houseId;
    private int buildingId;
    private String acreage;
    private String purpose;
    private String houseType;

    public House() {
    }

    public House(int buildingId, String acreage, String purpose, String houseType) {
        this.buildingId = buildingId;
        this.acreage = acreage;
        this.purpose = purpose;
        this.houseType = houseType;
    }

    public House(int houseId, int buildingId, String acreage, String purpose, String houseType) {
        this.houseId = houseId;
        this.buildingId = buildingId;
        this.acreage = acreage;
        this.purpose = purpose;
        this.houseType = houseType;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", buildingId=" + buildingId +
                ", acreage='" + acreage + '\'' +
                ", use='" + purpose + '\'' +
                ", houseType='" + houseType + '\'' +
                '}';
    }
}
