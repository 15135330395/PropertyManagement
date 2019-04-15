package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: TTeacherEntity
 */

import java.sql.Timestamp;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "t_teacher", schema = "test", catalog = "")
public class TTeacherEntity {
    private int tId;
    private String tName;
    private Timestamp tBirthday;
    private Double salary;

    @javax.persistence.Id
    @javax.persistence.Column(name = "t_id")
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "t_name")
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "t_birthday")
    public Timestamp gettBirthday() {
        return tBirthday;
    }

    public void settBirthday(Timestamp tBirthday) {
        this.tBirthday = tBirthday;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTeacherEntity that = (TTeacherEntity) o;
        return tId == that.tId &&
                Objects.equals(tName, that.tName) &&
                Objects.equals(tBirthday, that.tBirthday) &&
                Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tId, tName, tBirthday, salary);
    }
}
