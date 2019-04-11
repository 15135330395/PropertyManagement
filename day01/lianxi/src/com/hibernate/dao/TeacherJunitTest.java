package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/8
 * @Description: TeacherJunitTest
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeacherJunitTest {


    @Before
    public void doBefore(){
        System.out.println("qian");
    }

    @After
    public void doAfter(){
        System.out.println("hou");

    }


      @Test
      public void add(){
          System.out.println("111");
        }






}
