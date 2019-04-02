package com.system.dao.impl;

import com.entity.PageBean;
import com.system.dao.RoleDao;
import com.system.entity.Menu;
import com.system.entity.Role;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description RoleDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-31 15:24
 */
public class RoleDaoImpl implements RoleDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Role> getAllRole() {
        String sql = "select * from xtgl_role";
        try {
            List<Role> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Role.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> getAllRoleByPage(PageBean pageBean) {
        String sql = "select * from xtgl_role limit ?,?";
        try {
            List<Role> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Role.class), pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role findRoleById(int roleId) {
        String sql = "select * from xtgl_role where role_id=?";
        try {
            Role role = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Role.class), roleId);
            return role;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addRole(Role role) {
        String sql = "insert into xtgl_role (role_name) values (?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, role.getRoleName());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRole(Role role) {
        String sql = "update xtgl_role set role_name=? where role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, role.getRoleName(), role.getRoleId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRole(int roleId) {
        String sql = "delete from xtgl_role where role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
