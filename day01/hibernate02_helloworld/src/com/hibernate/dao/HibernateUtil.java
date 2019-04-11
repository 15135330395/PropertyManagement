package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/8
 * @Description: HibernateUtil
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory SESSIONFACTORY=null;

    static {
        //注册服务
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
        //获取session工厂
        SESSIONFACTORY=new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

   public static SessionFactory getSessionFactory(){
        return SESSIONFACTORY;
}

}
