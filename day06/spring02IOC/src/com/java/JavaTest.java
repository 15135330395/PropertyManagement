package com.java;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: JavaTest
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaTest {

    //将控制权交给主管
    public static void main(String[] args) {
         JavaWork javaWork=new JavaWork();
         javaWork.setTester(new ZhangSan());
         javaWork.doTest();

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        JavaWork javaWork1 = applicationContext.getBean("javaWork", JavaWork.class);
        javaWork1.doTest();


    }
}
