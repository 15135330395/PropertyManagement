package com.equipment.entity;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import java.util.Date;

public class Equarchives {
    private int id;
    private String ano;
    private String ename;
    private String eno;
    private String department;
    private Date recordDate;
    private String manufacturer;
    private Double price;
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecord_date(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Equarchives() {
    }

    public Equarchives(int id, String ano, String ename, String eno, String department, Date recordDate, String manufacturer, Double price, String place) {
        this.id = id;
        this.ano = ano;
        this.ename = ename;
        this.eno = eno;
        this.department = department;
        this.recordDate = recordDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.place = place;
    }

    public Equarchives(String ano, String ename, String eno, String department, Date recordDate, String manufacturer, Double price, String place) {
        this.ano = ano;
        this.ename = ename;
        this.eno = eno;
        this.department = department;
        this.recordDate = recordDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Equarchives{" +
                "id=" + id +
                ", ano='" + ano + '\'' +
                ", ename='" + ename + '\'' +
                ", eno='" + eno + '\'' +
                ", department='" + department + '\'' +
                ", recordDate=" + recordDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", place='" + place + '\'' +
                '}';
    }
}
