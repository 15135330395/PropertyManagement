package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/8
 * @Description: StudentJunitTest
 */

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentJunitTest {

    SessionFactory sessionFactory=null;
    Session session=null;

/* 1.该类不能私有化构造方法
2.方法必须是共有的
3.方法是没有返回值
4.方法没有参数
*
*
* */


@Before
    public void doBefore(){
      sessionFactory=HibernateUtil.getSessionFactory();
      session=sessionFactory.openSession();
    session.beginTransaction();

}

@After
    public void doAfter(){
    session.getTransaction().commit();
    session.close();


}
    @Test
    public void add(){

    Student student=new Student();
    student.setName("lisi");
    student.setAge(20);
    session.save(student);

    Student s1=new Student();
    student.setAge(10);
    student.setName("lili");
    session.save(s1);
    }

    @Test
    public void update(){
        Student student = session.get(Student.class, 1);
        student.setName("李四");
        student.setAge(15);
        session.save(student);
    }

   @Test
    public void delete(){
       Student student = session.get(Student.class, 1);
      if(student!=null){
          session.delete(student);
      }
   }

   @Test
   public void delete2(){
    Student student=new Student();
    student.setId(2);
    session.delete(student);
   }


   @Test
    public void query(){
//查询的是数据库表格映射的类对象，而不是数据库表格名称，所以是Student，而不是t_student。
   String hql="from Student";

       Query query = session.createQuery(hql);
       List<Student> list = query.list();
      for(Student s:list){
          System.out.println(s);

      }
   }


}
