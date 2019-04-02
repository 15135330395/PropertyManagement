package com.客户关系管理.entity;

/**
 * @author：Ganlan；
 * @date：2019-04-01；
 */


public class House {

    private int house_id;
    private int building_id;

    public House(int house_id, int building_id) {
        this.house_id = house_id;
        this.building_id = building_id;
    }

    public House() {
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    @Override
    public String toString() {
        return "House{" +
                "house_id=" + house_id +
                ", building_id=" + building_id +
                '}';
    }
}
