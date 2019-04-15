package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/11
 * @Description: Role
 */

import java.util.HashSet;
import java.util.Set;

public class Role {

    private Integer id;
    private String name;
    private Set<User> user=new HashSet<User>();

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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }


}
