package com.客户关系管理.dao.impl;


import com.客户关系管理.dao.CustomerRegisterDao;
import com.客户关系管理.entity.CustomerRegister;
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

public class CustomerRegisterDaoImpl implements CustomerRegisterDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public int add(CustomerRegister customerRegister) {
        String sql = "INSERT INTO customer_register (name, startTime, phone, addr, checkAccept, keyState) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customerRegister.getName(), customerRegister.getStartTime(), customerRegister.getPhone(), customerRegister.getAddr(), customerRegister.getCheckAccept(), customerRegister.getKeyState());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(CustomerRegister customerRegister) {

        String sql = "UPDATE customer_register t SET t.name = ?, t.phone = ?, t.addr = ?, t.checkAccept = ?, t.keyState = ? WHERE t.addr = ? ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customerRegister.getName(), customerRegister.getPhone(), customerRegister.getAddr(), customerRegister.getCheckAccept(), customerRegister.getKeyState(), customerRegister.getAddr());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CustomerRegister> findAll() {

        String sql = "SELECT * FROM customer_register";

        try {
            List<CustomerRegister> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CustomerRegister.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerRegister find(String name, PageBean pageBean) {

        String sql = "SELECT * FROM customer_register where name like ? limit ?,?";

        try {
            CustomerRegister customerRegister = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(CustomerRegister.class), name,pageBean.getIndex(),pageBean.getPageCount());
            return customerRegister;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerRegister> queryAll(PageBean pageBean) {

        String sql = "SELECT * FROM customer_register limit ?,?";

        try {
            List<CustomerRegister> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CustomerRegister.class), pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CustomerRegister queryOne(String id){

        String sql = "SELECT * FROM customer_register where addr = ? ";

        try {
            CustomerRegister customerRegister = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(CustomerRegister.class), id);
            return customerRegister;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerRegister findByaddr(String addr) {

        String sql = "select * from customer_register where addr = ?";

        try {
            CustomerRegister query = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(CustomerRegister.class), addr);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
