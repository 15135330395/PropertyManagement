package com.客户关系管理.entity;

/**
 * @author：Ganlan；
 * @date：2019-04-01；
 */


public class Area {

    private int area_id;
    private String area_name;

    public Area(int area_id, String area_name) {
        this.area_id = area_id;
        this.area_name = area_name;
    }

    public Area() {
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "area_id=" + area_id +
                ", area_name='" + area_name + '\'' +
                '}';
    }

}
