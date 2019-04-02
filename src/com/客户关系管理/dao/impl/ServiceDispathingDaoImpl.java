package com.客户关系管理.dao.impl;

import com.客户关系管理.dao.ServiceDispathingDao;
import com.客户关系管理.entity.PageBean;
import com.客户关系管理.entity.ServiceDispathing;
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
    public int add(String name,String addr,String feedback,String cphone) {

        String sql = " INSERT INTO `service_dispathing` (c_name,addr,c_phone,things, worker_id, `worker_name`, `start_time`, `end_time`, `w_phone`, `customer_check`, `material`, `service_cost`, `material_cost`, `other_service`) VALUES (?,?, ?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)" ;

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, name,addr,cphone ,feedback);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ServiceDispathing> findAll() {

       String sql = "select * from service_dispathing";

        try {
            List<ServiceDispathing> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(ServiceDispathing.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ServiceDispathing> queryAll(PageBean pageBean) {

       String sql = "select * from service_dispathing limit ?,? ";

        try {
            List<ServiceDispathing> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(ServiceDispathing.class),pageBean.getIndex(),pageBean.getPageCount());
            System.out.println("list"+list);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ServiceDispathing> findByName(String name) {

        String sql = "select * from service_dispathing where c_name like ?";

        try {
            List<ServiceDispathing> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(ServiceDispathing.class), "%"+name+"%");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
