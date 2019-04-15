package com.spring.entity;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: UserFactory
 */

public class UserFactory {


    public User createUser(){

        User user=new User();
        user.setId(5);
        user.setUsername("admin5");
        user.setPassword("admin55");

        return user;

    }

    public static User createStaticUser(){
        User user=new User();
        user.setId(6);
        user.setUsername("admin6");
        user.setPassword("admin666");

        return user;



    }


}
