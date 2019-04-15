package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: StudentJunit
 */

import com.hibernate.entity.Menu;
import com.hibernate.entity.Role;
import com.hibernate.entity.Role01;
import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserRoleJunit {

   Session session=null;


    @Before
    public void doBefore(){
         session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
    }

    @After
    public void doAfter(){
        session.getTransaction().commit();
        session.close();
    }




@Test
    public void addUserAndRole(){

      User user1=new User("aaa111","aaa111");
      User user2=new User("bbb222","bbb222");

    User user3=new User("ccc333","ccc333");

    Role role1=new Role();
    role1.setName("新闻管理员");

    Role role2=new Role();
    role2.setName("文档管理员");

    user1.getRole().add(role1);
    user1.getRole().add(role2);
    user2.getRole().add(role1);
    user2.getRole().add(role2);
    user3.getRole().add(role1);


  /*  session.save(role1);
    session.save(role2);*/

    session.save(user1);
    session.save(user2);
    session.save(user3);

  /*  session.save(role1);
    session.save(role2);*/

}

@Test
    public void addRole01AndMenu(){

        Menu menu1=new Menu();
        menu1.setName("保安URL");

        Menu menu2=new Menu();
        menu2.setName("管理员URL");

        Role01 role01=new Role01();
    role01.setName("保安");
    role01.getMenu().add(menu1);

    Role01 role02=new Role01();
    role02.setName("管理员");
    role02.getMenu().add(menu1);
    role02.getMenu().add(menu2);

    session.save(role01);
    session.save(role02);

}



}
