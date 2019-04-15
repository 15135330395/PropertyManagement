package com.spring.entity;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: Dog
 */

public class Dog {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

}
