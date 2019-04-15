package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/12
 * @Description: UserDao
 */

import com.hibernate.entity.User;
import com.hibernate.framework.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

//测试方法
  /*  public static void main(String[] args) {
        UserDao dao=new UserDao();
        dao.queryPage(1,5);
    }*/

   //页码  每页条数
    public List<User> queryPage(int pageIndex, int pageCount){
    List<User> list=new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
    Query<User> query = session.createQuery("from User");
    query.setFirstResult((pageIndex-1)*pageCount);
          query.setMaxResults(pageCount);

        list = query.list();
        session.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        session.getTransaction().rollback();
    }
        /*for (User user:list) {
            System.out.println(user);
        }*/
        session.close();
         return list;
    }

    //总页数
    public int pages(int pageCount){
    int pages=1;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query query = session.createQuery("select count(*) from User");
        Object obj = query.uniqueResult();
         Number num=(Number)obj;
       session.getTransaction().commit();
       session.close();

         pages =( num.intValue()+pageCount-1)/pageCount;//pages写在事物提交之后。
         return pages;

    }
  @Test
    public void add(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
       for(int i=0;i<10;i++){
           User user=new User("admin"+i,"admin"+i);
           session.save(user);
       }
    session.getTransaction().commit();
    session.close();
    }

  public User queryOneById(int id){
      Session session = HibernateUtil.getSession();
      session.beginTransaction();

      User user = session.get(User.class, id);

      session.getTransaction().commit();
      session.close();
      return user;

  }

  public void updateById(User user){

      Session session = HibernateUtil.getSession();
      session.beginTransaction();
      User user1=new User();
      user1 = session.get(User.class, user.getId());
      user1.setName(user.getName());
      user1.setPassword(user.getPassword());
       session.save(user1);
      /* session.update(user1);*/
      session.getTransaction().commit();
      session.close();
  }

  public void add(User user){

      Session session = HibernateUtil.getSession();
      session.beginTransaction();
      User user1=new User();
      user1.setName(user.getName());
      user1.setPassword(user.getPassword());
      session.save(user1);

      session.getTransaction().commit();
      session.close();
  }

  public void delete(int id){
      Session session = HibernateUtil.getSession();
      session.beginTransaction();
      User user = session.get(User.class, id);
      session.delete(user);

      session.getTransaction().commit();
      session.close();

  }
}
