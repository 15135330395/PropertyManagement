package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: StudentDao
 */

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentDao {

    public static void main(String[] args) {


        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();

        Student student=new Student();
        student.setName("李四");
        try {
            student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1991-01-11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        session.save(student);

        transaction.commit();
        session.close();
    }

}
