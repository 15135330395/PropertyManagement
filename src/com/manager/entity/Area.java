package com.manager.entity;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public class Area {

    private int areaId;
    private String areaName;

    public Area() {
    }

    public Area(int areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
