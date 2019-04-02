package com.客户关系管理.service;


import com.客户关系管理.dao.impl.CustomerFeedbackDaoImpl;
import com.客户关系管理.entity.CustomerFeedback;
import com.客户关系管理.entity.PageBean;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public class CustomerFeedbackService {

    CustomerFeedbackDaoImpl dao =  new CustomerFeedbackDaoImpl();

    public List<CustomerFeedback> find (PageBean pageBean){

        List<CustomerFeedback> list = dao.find(pageBean);
        return list;
    }

    public int update(int id ,String state){

        int i = dao.update(id,state);
        return i;
    }

    public List<CustomerFeedback> findAll(){

        List<CustomerFeedback> list = dao.findAll();
        return list;
    }

    public CustomerFeedback findByid(int id) {

        CustomerFeedback customerFeedback = dao.findById(id);
        return customerFeedback;
    }

    public List<CustomerFeedback> findByName(String name) {

        List<CustomerFeedback> list = dao.findByName(name);
        return list;
    }
}
