package com.客户关系管理.dao.impl;

import com.utils.JdbcUtil;
import com.客户关系管理.dao.ServiceDispathingDao;
import com.客户关系管理.entity.ServiceDispathing;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public class ServiceDispathingDaoImpl implements ServiceDispathingDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public ServiceDispathing find(int id) {

        String sql = "SELECT * FROM service_dispathing where sd_id = ? ";

        try {
            ServiceDispathing serviceDispathing = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(ServiceDispathing.class), id);
            return serviceDispathing;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updata(ServiceDispathing serviceDispathing) {

        String sql = "UPDATE service_dispathing t SET t.addr = ?, t.things = ? WHERE t.sd_id = ? ";

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, serviceDispathing.getAddr(), serviceDispathing.getThings(), serviceDispathing.getSdId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int add(ServiceDispathing serviceDispathing) {

        String sql = "INSERT INTO service_dispathing (addr, things) VALUES (?, ?)" ;

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, serviceDispathing.getAddr(), serviceDispathing.getThings());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
