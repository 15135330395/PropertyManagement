package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: TStudentEntity
 */

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "t_student", schema = "test", catalog = "")
public class TStudentEntity {
    private int sId;
    private String sName;
    private Integer age;

    @javax.persistence.Id
    @javax.persistence.Column(name = "s_id")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "s_name")
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TStudentEntity that = (TStudentEntity) o;
        return sId == that.sId &&
                Objects.equals(sName, that.sName) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, sName, age);
    }
}
