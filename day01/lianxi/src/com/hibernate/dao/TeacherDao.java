package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/8
 * @Description: TeacherDao
 */

import com.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;

public class TeacherDao {
    public static void main(String[] args) throws Exception {

 /*
 * 1.注册服务
 * 2.获取sessionFactory工厂
 * 3.获取session
 * 4.开始事物
 * 5.执行事物
 * 6.提交事物
 * 7.关闭session

 * */

       /* StandardServiceRegistry registry=new StandardServiceRegistryBuilder()
                .configure()
                .build();

                SessionFactory sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
*/
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Teacher teacher=new Teacher();
        teacher.setName("zhang");
        teacher.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-04-08 20:00:01"));
        teacher.setSalary(3555.5);

        session.save(teacher);

        session.getTransaction().commit();

        session.close();

    }




}
