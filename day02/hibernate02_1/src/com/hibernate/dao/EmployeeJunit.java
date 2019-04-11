package com.hibernate.dao;/*
 * @author :张
 * Date  : 2019/4/9
 * @Description: EmployeeJunit
 */

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class EmployeeJunit {

    @Test
    public void addEmployeeAndDepartment(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Department department=new Department();
        department.setName("研发部");
        session.save(department);


        Employee e1=new Employee();
        e1.setName("研发一号");
        e1.setDepartment(department);

        Employee e2=new Employee();
        e2.setName("研发二号");
        e2.setDepartment(department);

        Employee e3=new Employee();
        e3.setName("研发三号");
        e3.setDepartment(department);

        session.save(e1);
        session.save(e2);
        session.save(e3);

        session.getTransaction().commit();
        session.close();

    }


    @Test
    public void addDepartment(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Department department=new Department();
        department.setName("研发部");
        session.save(department);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void addEmployee(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Employee employee=new Employee();
        employee.setName("研发部");
        session.save(employee);

        session.getTransaction().commit();
        session.close();
    }


}
