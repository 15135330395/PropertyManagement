package com.客户关系管理.dao.impl;


import com.客户关系管理.dao.CustomerFeedbackDao;
import com.客户关系管理.entity.CustomerFeedback;
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


public class CustomerFeedbackDaoImpl implements CustomerFeedbackDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public List<CustomerFeedback> find(PageBean pageBean) {

        String sql = "select * from customer_feedback limit ?,?";

        try {
            List<CustomerFeedback> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CustomerFeedback.class),pageBean.getIndex(),pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int id,String state) {

        String sql = "UPDATE customer_feedback t SET  t.dispose = ? WHERE t.id = ?  ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, state, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<CustomerFeedback> findAll() {
        String sql = "select * from customer_feedback";

        try {
            List<CustomerFeedback> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CustomerFeedback.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerFeedback findById(int id) {
        String sql = "select * from customer_feedback where id = ? ";

        try {
            CustomerFeedback customerFeedback = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(CustomerFeedback.class), id);
            return customerFeedback;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerFeedback> findByName(String name) {

        String sql = "SELECT * FROM customer_feedback where name like ? ";

        try {
            List<CustomerFeedback> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CustomerFeedback.class), "%"+name+"%");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
