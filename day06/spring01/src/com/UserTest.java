package com;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: UserTest
 */

import com.spring.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        User user =(User) applicationContext.getBean("user");
         user.say();

        User user1 = applicationContext.getBean("user", User.class);
        user1.say();

    }
}
