package com.system.dao.impl;

import com.system.dao.MenuRoleDao;
import com.system.entity.MenuRole;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @Description MenuRoleDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-31 15:23
 */
public class MenuRoleDaoImpl implements MenuRoleDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public int addMenuRole(MenuRole menuRole) {
        String sql = "insert into xtgl_menu_role (menu_id,role_id) values (?,?)";
        try {
            int i = queryRunner.update(sql, menuRole.getMenuId(), menuRole.getRoleId());
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
}
