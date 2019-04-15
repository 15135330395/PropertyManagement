package com.spring;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: UserDao
 */

import org.springframework.stereotype.Repository;

//持久层数据访问层DAO
@Repository("userDao")
public class UserDao {
    public void add(){
        System.out.println("UserDao...add");

    }
}
