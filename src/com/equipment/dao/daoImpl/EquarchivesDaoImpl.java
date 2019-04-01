package com.equipment.dao.daoImpl;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import com.entity.PageBean;
import com.equipment.dao.EquarchivesDao;
import com.equipment.entity.Equarchives;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquarchivesDaoImpl implements EquarchivesDao {

    QueryRunner qr=new QueryRunner();
    @Override
    public List<Equarchives> findAll() {
        String sql="select * from equarchives ";
        List<Equarchives> list=new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Equarchives.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Equarchives equarchives) {
        String sql="insert into equarchives (ano,ename,eno,department,record_date,manufacturer,price,place ) values (?,?,?,?,?,?,?,? )";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, equarchives.getAno(),equarchives.getEname(), equarchives.getEno(), equarchives.getDepartment(),
                    equarchives.getRecordDate(), equarchives.getManufacturer(),equarchives.getPrice(),equarchives.getPlace());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Equarchives equarchives) {
        String sql="update equarchives set ano=?,ename=?,eno=?,department=?,record_date=?,manufacturer=?,price=? ,place=? where id=? ";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, equarchives.getAno(),equarchives.getEname(), equarchives.getEno(), equarchives.getDepartment(),
                    equarchives.getRecordDate(), equarchives.getManufacturer(),equarchives.getPrice(),equarchives.getPlace(),equarchives.getId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        String sql="delete from equarchives where id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Equarchives> queryPage(PageBean pageBean) {
        String sql="select * from equarchives order by record_date desc limit ?,?";
        List<Equarchives> list=new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Equarchives.class), pageBean.getIndex(), pageBean.getPageCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Equarchives findById(int id) {
        String sql="select * from equarchives where id= ? ";
        Equarchives equarchives =new Equarchives();
        try {
            equarchives = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Equarchives.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equarchives;
    }
}
