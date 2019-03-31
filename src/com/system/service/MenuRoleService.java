package com.system.service;

import com.system.dao.MenuRoleDao;
import com.system.dao.impl.MenuRoleDaoImpl;
import com.system.entity.MenuRole;

/**
 * @Description MenuRoleService
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public class MenuRoleService {
    private MenuRoleDao dao = new MenuRoleDaoImpl();

    public int addMenuRole(MenuRole menuRole) {
        return dao.addMenuRole(menuRole);
    }

    public int updateMenuRole(MenuRole menuRole) {
        dao.deleteMenuRole(menuRole.getMenuRoleId());
        return dao.addMenuRole(menuRole);
    }

    public int deleteMenuRole(int menuRoleId) {
        return dao.deleteMenuRole(menuRoleId);
    }
}
