package com.客户关系管理.dao;

import com.客户关系管理.entity.Customer;
import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */

public interface CustomerDao {

    public int add(Customer customer);
    public int delete(int id);
    public int update(Customer customer);
    public List<Customer> findAll();
    public Customer findByName(String addr);

}
