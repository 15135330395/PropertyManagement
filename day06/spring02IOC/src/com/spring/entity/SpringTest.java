package com.spring.entity;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: SpringTest
 */

import com.java.JavaWork;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        JavaWork javaWork = applicationContext.getBean("javaWork", JavaWork.class);
        //System.out.println(javaWork);
        javaWork.doTest();
    }

}
