package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/8
 * @Description: BookDao
 */


import com.hibernate.entity.Book;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class BookDao {


    public static void main(String[] args) throws  Exception {
      //获取sessionFactory
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();
       //开始一个事物，返回事物
        Transaction transaction = session.beginTransaction();


        Book book=new Book();
        book.setName("你好世界");
        book.setPrice(19.9f);
       /* book.setPublishDate(new Date()); //new Date()显示当前时间*/
        book.setPublishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-04-08 18:50:12"));

//hibernate 提供LogHelper ，去解析文件
        LobHelper lobHelper = session.getLobHelper();
        InputStream is=new FileInputStream("C:\\Users\\Administrator\\Desktop\\图片视频\\lianxi1.jpg");

book.setBookImage(lobHelper.createBlob(is,is.available()));

 session.save(book);

        //事物提交
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
