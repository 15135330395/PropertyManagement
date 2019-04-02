package com.客户关系管理.dao.impl;


import com.客户关系管理.dao.CustomerDao;
import com.客户关系管理.entity.Customer;
import com.客户关系管理.entity.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */

public class CustomerDaoImpl implements CustomerDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public int add(Customer customer) {

        String sql = "INSERT INTO customer (name, customerNature, phone, idCard, car, pet,  addr) VALUES (?, ?, ?, ?, ?, ?,  ?)";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customer.getName(), customer.getCustomerNature(), customer.getPhone(), customer.getIdCard(), customer.getCar(), customer.getPet(), customer.getAddr());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int delete(int id) {

        String sql = "delete from customer  WHERE id = ? ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Customer customer) {

        String sql = "update customer t set name = ?, customerNature = ?, phone = ?,car = ?, pet = ?, addr = ? WHERE  idCard = ? ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customer.getName(), customer.getCustomerNature(), customer.getPhone(), customer.getCar(), customer.getPet(),  customer.getAddr(),customer.getIdCard());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Customer> findAll() {

        String sql = "select * from customer ";
        try {
            List<Customer> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Customer.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findByName(String name, PageBean pageBean) {

        String sql = "SELECT * FROM customer where name like ? limit ?,?";

        try {
            List<Customer> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Customer.class), "%"+name+"%", pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> queryAll(PageBean pageBean) {
        String sql = "SELECT * FROM customer limit ?,?";
        try {
            List<Customer> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Customer.class),pageBean.getIndex(),pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findName(String name) {
        String sql = "SELECT * FROM customer where name like ? ";

        try {
            List<Customer> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Customer.class), "%"+name+"%");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer queryOne(String id) {

        String sql = "select * from customer where idCard = ? ";

        try {
            Customer customer = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Customer.class), id);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
