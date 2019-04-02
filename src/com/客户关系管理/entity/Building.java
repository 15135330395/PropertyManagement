package com.客户关系管理.entity;

/**
 * @author：Ganlan；
 * @date：2019-04-01；
 */


public class Building {

    private int building_id;
    private String building_name;
    private int area_id;

    public Building(int building_id, String building_name, int area_id) {
        this.building_id = building_id;
        this.building_name = building_name;
        this.area_id = area_id;
    }

    public Building() {
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    @Override
    public String toString() {
        return "Building{" +
                "building_id=" + building_id +
                ", building_name='" + building_name + '\'' +
                ", area_id=" + area_id +
                '}';
    }
}
