package com.system.service;

import com.system.dao.MenuRoleDao;
import com.system.dao.impl.MenuRoleDaoImpl;
import com.system.entity.MenuRole;

import java.util.List;

/**
 * @Description MenuRoleService
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public class MenuRoleService {
    private MenuRoleDao dao = new MenuRoleDaoImpl();

    public List<MenuRole> getAllMenuByRoleId(int roleId) {
        return dao.getAllMenuByRoleId(roleId);
    }

    public int addMenuRole(MenuRole menuRole) {
        return dao.addMenuRole(menuRole);
    }

    public int deleteMenuRole(int menuRoleId) {
        return dao.deleteMenuRole(menuRoleId);
    }

    public int deleteMenuRoleByRoleId(int roleId) {
        return dao.deleteMenuRoleByRoleId(roleId);
    }
}
