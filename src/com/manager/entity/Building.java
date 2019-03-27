package com.manager.entity;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public class Building {

    private int buildingId;
    private String buildingName;
    private int staffId;
    private String staffName;
    private int areaId;
    private String areaName;


    public Building() {
    }

    public Building(int buildingId, String buildingName,int staffId,String staffName,int areaId,String areaName) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.staffId = staffId;
        this.staffName = staffName;
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
