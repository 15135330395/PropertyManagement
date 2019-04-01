package com.system.dao.impl;

import com.system.dao.MenuRoleDao;
import com.system.entity.MenuRole;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description MenuRoleDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-31 15:23
 */
public class MenuRoleDaoImpl implements MenuRoleDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<MenuRole> getAllMenuByRoleId(int roleId) {
        String sql = "select * from xtgl_menu_role where role_id=?";
        try {
            List<MenuRole> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(MenuRole.class), roleId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addMenuRole(MenuRole menuRole) {
        String sql = "insert into xtgl_menu_role (menu_id,role_id) values (?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menuRole.getMenuId(), menuRole.getRoleId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMenuRole(int menuRoleId) {
        String sql = "delete from xtgl_menu_role where menu_role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menuRoleId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMenuRoleByRoleId(int roleId) {
        String sql = "delete from xtgl_menu_role where role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
