package com.客户关系管理.dao.impl;

import com.entity.PageBean;
import com.utils.JdbcUtil;
import com.客户关系管理.dao.CustomerRegisterDao;
import com.客户关系管理.entity.CustomerRegister;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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
        String sql = "INSERT INTO customer_register (name, startTime, endTime, phone, idCard, checkAccept, keyState) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customerRegister.getName(), customerRegister.getStartTime(), customerRegister.getEndTime(), customerRegister.getPhone(), customerRegister.getIdCard(), customerRegister.getCheckAccept(), customerRegister.getKeyState());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(CustomerRegister customerRegister) {

        String sql = "UPDATE customer_register t SET t.name = ?, t.startTime = ?, t.endTime = ?, t.phone = ?, t.idCard = ?, t.checkAccept = ?, t.keyState = ? WHERE t.id = ? ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customerRegister.getName(), customerRegister.getStartTime(), customerRegister.getEndTime(), customerRegister.getPhone(), customerRegister.getIdCard(), customerRegister.getCheckAccept(), customerRegister.getKeyState(), customerRegister.getId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CustomerRegister> findAll(PageBean pageBean) {

        String sql = "SELECT * FROM customer_register";

        try {
            List<CustomerRegister> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CustomerRegister.class),pageBean.getIndex(),pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerRegister find(String name,PageBean pageBean) {

        String sql = "SELECT * FROM customer_register where name like ? limit ?,?";

        try {
            CustomerRegister customerRegister = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(CustomerRegister.class), name,pageBean.getIndex(),pageBean.getPageCount());
            return customerRegister;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
