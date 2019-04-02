package com.客户关系管理.service;


import com.客户关系管理.dao.impl.CustomerRegisterDaoImpl;
import com.客户关系管理.entity.CustomerRegister;
import com.客户关系管理.entity.PageBean;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public class CustomerRegisterService {

    CustomerRegisterDaoImpl dao = new CustomerRegisterDaoImpl();

    public int add(CustomerRegister customerRegister){

        int i = dao.add(customerRegister);
        return i;
    }

    public int update(CustomerRegister customerRegister){

        int i = dao.update(customerRegister);
        return i;
    }

    public List<CustomerRegister> findAll(){

        List<CustomerRegister> list = dao.findAll();
        return list;
    }

    public CustomerRegister find(String name, PageBean pageBean){

        CustomerRegister customerRegister = dao.find(name,pageBean);
        return customerRegister;
    }

    public List<CustomerRegister> queryAll(PageBean pageBean) {
        List<CustomerRegister> list = dao.queryAll(pageBean);
        return list;
    }

    public CustomerRegister queryOne(String id) {

        CustomerRegister customerRegister = dao.queryOne(id);
        return customerRegister;
    }

    public CustomerRegister findByaddr(String addr) {

        CustomerRegister customerRegister = dao.findByaddr(addr);
        return customerRegister;
    }
}
