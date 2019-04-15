package com.hibernate.framework;/*
 * @author :张
 * Date  : 2019/4/12
 * @Description: Hibernate
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory SESSIONFACTORY=null;
    private static Session session=null;

    static{

        Configuration configuration=new Configuration().configure();
        SESSIONFACTORY = configuration.buildSessionFactory();

    }

    public static SessionFactory getSessionFactory(){
        return SESSIONFACTORY;

    }

    public static Session getSession(){
        session = getSessionFactory().openSession();
        return session;
    }


}
