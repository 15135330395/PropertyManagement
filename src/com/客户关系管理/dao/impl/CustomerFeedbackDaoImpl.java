package com.客户关系管理.dao.impl;

import com.utils.JdbcUtil;
import com.客户关系管理.dao.CustomerFeedbackDao;
import com.客户关系管理.entity.CustomerFeedback;
import com.客户关系管理.entity.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
            List<CustomerFeedback> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CustomerFeedback.class),pageBean.getIndex(),pageBean.getPegeCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(CustomerFeedback customerFeedback) {

        String sql = "UPDATE customer_feedback t SET t.dispose_time = ?, t.dispose = ? WHERE t.id = ?  ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, customerFeedback.getDisposeTime(), customerFeedback.getDispose(), customerFeedback.getId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
