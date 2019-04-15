package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: Student
 */

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Date birthday;
    private Classes classes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", classes=" + classes +
                '}';
    }
}
