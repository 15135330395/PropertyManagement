package com.spring.test;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: ControllerTest
 */

import com.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControllerTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("datebase.xml");
  //userService 中创建了UserDao的set方法，.xml中通过bean注入的方式
//采用xml依赖注入
  //      UserService userService = applicationContext.getBean("userService", UserService.class);
  //    userService.add();
 //.xml头部default-autowire="byName"方式注入   注入属性UserDao。
        //采用xml  byName 依赖 注入
        // UserService userService1 = applicationContext.getBean("userService1", UserService.class);
        //userService1.add();
//.xml头部default-autowire="byType"方式注入属性  UserDao。 改成byType后，只能留一个属性UserDao的bean，多了会报错。
   //采用xml  byType依赖 注入
        UserService userService2 = applicationContext.getBean("userService2", UserService.class);
        userService2.add();

    }


}
