package com.客户关系管理.service;

import com.entity.PageBean;
import com.客户关系管理.dao.impl.CustomerDaoImpl;
import com.客户关系管理.entity.Customer;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */

public class CustomerService {

    CustomerDaoImpl dao = new CustomerDaoImpl();

    public int add(Customer customer){

        int i = dao.add(customer);
        return i;
    }

    public int delete(int id){

        int i = dao.delete(id);
        return i;
    }

    public int update(Customer customer){

        int i = dao.update(customer);
        return i;
    }

    public List<Customer> findAll(){

        List<Customer> list = dao.findAll();
        return list;
    }

    public List<Customer> findByName(String addr, PageBean pageBean){

        List<Customer> list = dao.findByName(addr, pageBean);
        return list;
    }

    public List<Customer> queryAll(PageBean pageBean){

        List<Customer> list = dao.queryAll(pageBean);
        return list;
    }

    public List<Customer> findName(String name){

        List<Customer> list = dao.findName(name);
        return list;
    }

}
