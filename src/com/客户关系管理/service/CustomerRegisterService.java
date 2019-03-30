package com.客户关系管理.service;

import com.entity.PageBean;
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

    public List<CustomerRegister> findAll(PageBean pageBean){

        List<CustomerRegister> list = dao.findAll(pageBean);
        return list;
    }

    public CustomerRegister find(String name,PageBean pageBean){

        CustomerRegister customerRegister = dao.find(name,pageBean);
        return customerRegister;
    }
}
