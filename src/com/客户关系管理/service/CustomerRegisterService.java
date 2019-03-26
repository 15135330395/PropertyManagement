package com.客户关系管理.service;

import com.客户关系管理.dao.impl.CustomerRegisterDaoImpl;
import com.客户关系管理.entity.CustomerRegister;

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

    public CustomerRegister find(String name){

        CustomerRegister customerRegister = dao.find(name);
        return customerRegister;
    }
}
