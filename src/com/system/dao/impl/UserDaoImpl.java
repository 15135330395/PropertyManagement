package com.system.dao.impl;

import com.entity.PageBean;
import com.system.dao.UserDao;
import com.system.entity.Role;
import com.system.entity.User;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description UserDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-31 15:24
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<User> getAllUser() {
        String sql = "select * from xtgl_user";
        try {
            List<User> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(User.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUserByPage(PageBean pageBean) {
        String sql = "select * from xtgl_user limit ?,?";
        try {
            List<User> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(User.class), pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserById(int userId) {
        String sql = "select * from xtgl_user where user_id =?";
        try {
            User user = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(User.class), userId);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        String sql = "select * from xtgl_user where username =?";
        try {
            User user = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(User.class), username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into xtgl_user (username,password) values (?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, user.getUsername(), user.getPassword());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update xtgl_user set username=? ,password=? where user_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, user.getUsername(), user.getPassword(), user.getUserId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int userId) {
        String sql = "delete from xtgl_user where user_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, userId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
