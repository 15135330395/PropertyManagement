package com.客户关系管理.dao.impl;

import com.entity.PageBean;
import com.utils.JdbcUtil;
import com.客户关系管理.dao.CustomerDao;
import com.客户关系管理.entity.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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

        String sql = "INSERT INTO customer (name, customerNature, phone, idCard, car, pet, extraDemand, addr) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customer.getName(), customer.getCustomerNature(), customer.getPhone(), customer.getIdCard(), customer.getCar(), customer.getPet(), customer.getExtraDemand(), customer.getAddr());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int delete(int id) {

        String sql = "delete from customer t WHERE t.id = ? ";

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

        String sql = "UPDATE customer t SET t.name = ?, t.customerNature = ?, t.phone = ?, t.idCard = ?, t.car = ?, t.pet = ?, t.extraDemand = ?,t.addr = ? WHERE t.id = ? ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customer.getName(), customer.getCustomerNature(), customer.getPhone(), customer.getIdCard(), customer.getCar(), customer.getPet(), customer.getExtraDemand(), customer.getAddr(),customer.getId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Customer> findAll() {

        String sql = "SELECT * FROM customer";
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
            List<Customer> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Customer.class), name, pageBean.getIndex(), pageBean.getPageCount());
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
            List<Customer> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Customer.class), name);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
