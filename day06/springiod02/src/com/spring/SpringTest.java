package com.spring;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: SpringTest
 */

import com.spring.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        User user1 = applicationContext.getBean("user1", User.class);
        System.out.println(user1);

        User user2 = applicationContext.getBean("user2", User.class);
        System.out.println(user2);

        User user3 = applicationContext.getBean("user3", User.class);
        System.out.println(user3);


        User user4 = applicationContext.getBean("user4", User.class);
        System.out.println(user4);

        User user5 = applicationContext.getBean("user5", User.class);
        System.out.println(user5);


        User user6 = applicationContext.getBean("user6", User.class);
        System.out.println(user6);


    }


}
