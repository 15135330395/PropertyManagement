package com.客户关系管理.dao;


import com.客户关系管理.entity.CustomerRegister;
import com.客户关系管理.entity.PageBean;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public interface CustomerRegisterDao {

    public int add(CustomerRegister customerRegister);
    public int update(CustomerRegister customerRegister);
    public List<CustomerRegister> findAll();
    public CustomerRegister find(String name, PageBean pageBean);
    public List<CustomerRegister> queryAll(PageBean pageBean);
    public CustomerRegister queryOne(String id);

    public CustomerRegister findByaddr(String addr);
}
