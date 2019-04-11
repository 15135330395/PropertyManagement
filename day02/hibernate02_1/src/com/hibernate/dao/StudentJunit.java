package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: StudentJunit
 */

import com.hibernate.entity.Classes;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentJunit {

  static  Session session=null;
  static Transaction transaction=null;

    @Before
    public void doBefore(){
         session = HibernateUtil.getSession();
         transaction = session.beginTransaction();
    }

    @After
    public void doAfter(){

        transaction.commit();
        session.close();
    }


    @Test
    public void query(){
        Student student = session.get(Student.class, 1);
        System.out.println(student);

    }

@Test
    public void add(){
        Student student=new Student();
        student.setName("qinghua");

        session.save(student);

}

@Test
    public void addStudentAndClass(){

    Classes classes=new Classes();
    classes.setName("java1班");
   /* session.save(classes);*/

    Student s1=new Student();
    s1.setName("小明");
    s1.setClasses(classes);


    Student s2=new Student();
    s2.setName("小红");
    s2.setClasses(classes);


    session.save(s1);
    session.save(s2);
}


@Test
    public void queryClass(){
    Student s1 = session.get(Student.class, 1);

    String name = s1.getClasses().getName();
    System.out.println(name);

}
}
