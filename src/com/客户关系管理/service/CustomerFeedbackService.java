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

    public int update(CustomerFeedback customerFeedback){

        int i = dao.update(customerFeedback);
        return i;
    }
}
