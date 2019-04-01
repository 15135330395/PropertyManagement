package com.equipment.dao.daoImpl;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import com.entity.PageBean;
import com.equipment.dao.EqumalfunctionDao;
import com.equipment.entity.Equmalfunction;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EqumalfunctionDaoImpl implements EqumalfunctionDao {
  QueryRunner qr=new QueryRunner();
    @Override
    public List<Equmalfunction> findAll() {
        String sql="select * from equmalfunction ";
        List<Equmalfunction> list=new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Equmalfunction.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Equmalfunction equmalfunction) {
        String sql="insert into equmalfunction (ename,eno,mdate,handler,installdetail,operation,maintenance,rejection ) values (?,?,?,?,?,?,?,?)";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, equmalfunction.getEname(),equmalfunction.getEno(), equmalfunction.getMdate(), equmalfunction.getHandler(),
                    equmalfunction.getInstalldetail(), equmalfunction.getOperation(), equmalfunction.getMaintenance(), equmalfunction.getRejection()  );
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Equmalfunction equmalfunction) {
        String sql="update equmalfunction set ename=?,eno=?,mdate=?,handler=?,installdetail=?,operation=?,maintenance=?,rejection=? where mid=? ";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, equmalfunction.getEname(),equmalfunction.getEno(), equmalfunction.getMdate(), equmalfunction.getHandler(),
                    equmalfunction.getInstalldetail(), equmalfunction.getOperation(), equmalfunction.getMaintenance(), equmalfunction.getRejection(), equmalfunction.getMid());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        String sql="delete from equmalfunction where mid=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Equmalfunction> queryPage(PageBean pageBean) {
        String sql="select * from equmalfunction order by mdate desc limit ?,?";
        List<Equmalfunction> list=new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Equmalfunction.class), pageBean.getIndex(), pageBean.getPageCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Equmalfunction findById(int id) {
        String sql="select * from equmalfunction where mid= ? ";
         Equmalfunction equmalfunction =new Equmalfunction();
        try {
            equmalfunction = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Equmalfunction.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equmalfunction;
    }
}
