package com.客户关系管理.dao;

import com.客户关系管理.entity.CustomerFeedback;
import com.客户关系管理.entity.PageBean;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public interface CustomerFeedbackDao {

    public List<CustomerFeedback> find (PageBean pageBean);

    public int update(CustomerFeedback customerFeedback);

}
