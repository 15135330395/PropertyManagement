package com.spring.service;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: UserService
 */

import com.spring.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//业务层
@Service
public class UserService {
    /*UserDao dao=new UserDao();
    public void add(){

    }*/
  //Resource 通过byName赋值，  autowire的通过byType赋值
@Autowired
    private UserDao userDao;

//       public void setUserDao(UserDao userDao) {
//           this.userDao = userDao;
//       }

       public void add(){
        System.out.println("UserService...add");
        userDao.add();

    }


}
