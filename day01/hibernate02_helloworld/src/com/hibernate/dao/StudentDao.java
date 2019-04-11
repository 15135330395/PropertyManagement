package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/8
 * @Description: StudentDao
 */

import com.hibernate.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentDao {

    public static void main(String[] args) throws HibernateException {
/* 1.注册服务
   2.获取sessionFactory工厂
*  3.获取session对象
*  4.开始事物
*  5.执行程序
*  6.提交事务
*  7.关闭session
*
* */
    /*   //1.注册服务
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder()
                .configure()
                .build();
//2.获取sessionFactory工厂，
        SessionFactory sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
        */
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

 //3.获取session对象
         Session session=sessionFactory.openSession();  //对openSession抛异常，throw
//4.开始事物
        session.beginTransaction();
    /*往数据库添加数据*/
        Student student=new Student();
        student.setName("zhangsan张");
        student.setAge(13);
        session.save(student);

        //执行程序


        //提交事物
        session.getTransaction().commit();

        //关闭session
        session.close();

    }

}
