package com.equipment.entity;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import java.util.Date;

public class Equmalfunction {
    private int mid;
    private String ename;
    private String eno;
    private Date mdate;
    private String handler;
    private String installdetail;
    private String operation;
    private String maintenance;
    private String rejection;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getInstalldetail() {
        return installdetail;
    }

    public void setInstalldetail(String installdetail) {
        this.installdetail = installdetail;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getRejection() {
        return rejection;
    }

    public void setRejection(String rejection) {
        this.rejection = rejection;
    }

    public Equmalfunction(int mid, String ename, String eno, Date mdate, String handler, String installdetail, String operation, String maintenance, String rejection) {
        this.mid = mid;
        this.ename = ename;
        this.eno = eno;
        this.mdate = mdate;
        this.handler = handler;
        this.installdetail = installdetail;
        this.operation = operation;
        this.maintenance = maintenance;
        this.rejection = rejection;
    }

    public Equmalfunction() {
    }

    @Override
    public String toString() {
        return "Equmalfunction{" +
                "mid=" + mid +
                ", ename='" + ename + '\'' +
                ", eno='" + eno + '\'' +
                ", mdate=" + mdate +
                ", handler='" + handler + '\'' +
                ", installdetail='" + installdetail + '\'' +
                ", operation='" + operation + '\'' +
                ", maintenance='" + maintenance + '\'' +
                ", rejection='" + rejection + '\'' +
                '}';
    }
}
