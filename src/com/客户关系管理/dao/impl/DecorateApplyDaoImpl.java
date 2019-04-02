package com.客户关系管理.dao.impl;


import com.客户关系管理.dao.DecorateApplyDao;
import com.客户关系管理.entity.DecorateApply;
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


public class DecorateApplyDaoImpl implements DecorateApplyDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public List<DecorateApply> find(PageBean pageBean) {

        String sql = "select * from decorate_apply limit ?,?";

        try {
            List<DecorateApply> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(DecorateApply.class),pageBean.getIndex(),pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updata(int id , String state) {

        String sql = "UPDATE decorate_apply t SET t.state = ? WHERE t.id = ?  ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql,state, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<DecorateApply> findAll() {

        String sql = "select * from decorate_apply ";

        try {
            List<DecorateApply> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(DecorateApply.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public DecorateApply findById(int id) {

        String sql = "select * from decorate_apply where id = ?";

        try {
            DecorateApply decorateApply = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(DecorateApply.class), id);
            return decorateApply;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public List<DecorateApply> findByName(String name) {

       String sql = "SELECT * FROM decorate_apply where name like ? ";

        try {
            List<DecorateApply> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(DecorateApply.class), "%" + name + "%");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
