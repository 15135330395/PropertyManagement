package com.equipment.entity;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import java.util.Date;

public class Equmaintenance {
    private int eid;
    private String ename;
    private String eno;
    private String content;
    private String charge;
    private Date edate;
    private String material;
    private int number;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Equmaintenance(int eid, String ename, String eno, String content, String charge, Date edate, String material, int number) {
        this.eid = eid;
        this.ename = ename;
        this.eno = eno;
        this.content = content;
        this.charge = charge;
        this.edate = edate;
        this.material = material;
        this.number = number;
    }

    public Equmaintenance() {
    }

    @Override
    public String toString() {
        return "Equmaintenance{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", eno='" + eno + '\'' +
                ", content='" + content + '\'' +
                ", charge='" + charge + '\'' +
                ", edate=" + edate +
                ", material='" + material + '\'' +
                ", number=" + number +
                '}';
    }
}
