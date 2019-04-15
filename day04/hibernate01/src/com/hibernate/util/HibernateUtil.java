package com.hibernate.util;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: HibernateUtil
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory SESSIONFACTORY=null;
    private static Session session=null;

    static{

      /*  StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
        SESSIONFACTORY = new MetadataSources(registry).buildMetadata().buildSessionFactory();*/

        Configuration configuration=new Configuration().configure();
        SESSIONFACTORY = configuration.buildSessionFactory();

    }

   public static SessionFactory getSessionFactory(){

        return SESSIONFACTORY;
   }

   public static Session getSession(){

    Session session = getSessionFactory().openSession();
    return session;
}


}
