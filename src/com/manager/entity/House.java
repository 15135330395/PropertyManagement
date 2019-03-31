package com.manager.entity;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public class House {

    private int houseId;
    private int buildingId;
    private String acreage;
    private String use;
    private String houseType;

    public House() {
    }

    public House(int buildingId, String acreage, String use, String houseType) {
        this.buildingId = buildingId;
        this.acreage = acreage;
        this.use = use;
        this.houseType = houseType;
    }

    public House(int houseId, int buildingId, String acreage, String use, String houseType) {
        this.houseId = houseId;
        this.buildingId = buildingId;
        this.acreage = acreage;
        this.use = use;
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

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
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
                ", use='" + use + '\'' +
                ", houseType='" + houseType + '\'' +
                '}';
    }
}
