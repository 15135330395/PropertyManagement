package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: Classes
 */

import java.util.HashSet;
import java.util.Set;

public class Classes {

    private int id;
    private String name;
    private Set student=new HashSet();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getStudent() {
        return student;
    }

    public void setStudent(Set student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }


}
