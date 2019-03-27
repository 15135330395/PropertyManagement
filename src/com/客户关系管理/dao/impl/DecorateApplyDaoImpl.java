package com.客户关系管理.dao.impl;

import com.utils.JdbcUtil;
import com.客户关系管理.dao.DecorateApplyDao;
import com.客户关系管理.entity.DecorateApply;
import com.客户关系管理.entity.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
            List<DecorateApply> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(DecorateApply.class),pageBean.getIndex(),pageBean.getPegeCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updata(DecorateApply decorateApply) {

        String sql = "UPDATE decorate_apply t SET t.state = ?, t.refunding = ? WHERE t.id = ?  ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, decorateApply.getState(), decorateApply.getRefunding(), decorateApply.getId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
