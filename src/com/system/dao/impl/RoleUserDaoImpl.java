package com.system.dao.impl;

import com.system.dao.RoleUserDao;
import com.system.entity.Role;
import com.system.entity.RoleUser;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description RoleUserDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-31 15:24
 */
public class RoleUserDaoImpl implements RoleUserDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<RoleUser> getAllRoleUser() {
        String sql = "select * from xtgl_role_user";
        try {
            List<RoleUser> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(RoleUser.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addRoleUser(RoleUser roleUser) {
        String sql = "insert into xtgl_role_user (role_id,user_id) values (?,?)";
        try {
            int i = queryRunner.update(sql, roleUser.getRoleId(), roleUser.getUserId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRoleUser(RoleUser roleUser) {
        String sql = "update xtgl_role_user set role_id=?,user_id=? where role_user_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleUser.getRoleId(), roleUser.getUserId(), roleUser.getRoleUserId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRoleUser(int roleUserId) {
        String sql = "delete from xtgl_role_user where role_user_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleUserId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
