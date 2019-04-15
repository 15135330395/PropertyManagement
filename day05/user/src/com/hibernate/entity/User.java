package com.hibernate.entity;/*
 * @author :张
 * Date  : 2019/4/12
 * @Description: User
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    private int id;
    private String name;
    private String password;


@Id
@GenericGenerator(name="_native",strategy="native")
@GeneratedValue(generator = "_native")
   @Column(name = "u_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@Column(name = "u_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column(name = "u_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
