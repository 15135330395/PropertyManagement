package com.spring.entity;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: Person
 */

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {


    private String name;
    private int age;
    private Dog dog=new Dog();
    private List<String> addr;
    private Set<String> love;
    private Map<String,String> address;
    private Properties properties;  //设置jdbc连接的四大属性driverClassName，url，username，password。


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public Set<String> getLove() {
        return love;
    }

    public void setLove(Set<String> love) {
        this.love = love;
    }

    public List<String> getAddr() {
        return addr;
    }

    public void setAddr(List<String> addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Person(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }


}
