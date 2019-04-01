package com.equipment.dao.daoImpl;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import com.entity.PageBean;
import com.equipment.dao.EqumaintenanceDao;
import com.equipment.entity.Equmaintenance;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EqumaintenanceDaoImpl implements EqumaintenanceDao {

    QueryRunner qr=new QueryRunner();
    @Override
    public List<Equmaintenance> findAll() {
        String sql="select * from Equmaintenance ";
        List<Equmaintenance> list=new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Equmaintenance.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Equmaintenance equmaintenance) {
        String sql="insert into equmaintenance (ename,eno,content,charge,edate,material,number ) values (?,?,?,?,?,?,? )";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, equmaintenance.getEname(),equmaintenance.getEno(), equmaintenance.getContent(), equmaintenance.getCharge(),
                    equmaintenance.getEdate(), equmaintenance.getMaterial(),equmaintenance.getNumber());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Equmaintenance equmaintenance) {
        String sql="update equmaintenance set ename=?,eno=?,content=?,charge=?,edate=?,material=?,number=? where eid=? ";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, equmaintenance.getEname(),equmaintenance.getEno(), equmaintenance.getContent(), equmaintenance.getCharge(),
                    equmaintenance.getEdate(), equmaintenance.getMaterial(),equmaintenance.getNumber(),equmaintenance.getEid());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        String sql="delete from equmaintenance where eid=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Equmaintenance> queryPage(PageBean pageBean) {
        String sql="select * from equmaintenance order by edate desc limit ?,?";
        List<Equmaintenance> list=new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Equmaintenance.class), pageBean.getIndex(), pageBean.getPageCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Equmaintenance findById(int id) {
        String sql="select * from equmaintenance where eid= ? ";
        Equmaintenance equmaintenance =new Equmaintenance();
        try {
            equmaintenance = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Equmaintenance.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equmaintenance;
    }
}
