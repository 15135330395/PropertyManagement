package com.system.dao;

import com.system.entity.MenuRole;

/**
 * @Description MenuRoleDao
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public interface MenuRoleDao {

    /**
     * 添加权限用户映射表
     * @param menuRole
     * @return
     */
    int addMenuRole(MenuRole menuRole);

    /**
     * 删除权限用户映射表
     * @param menuRoleId
     * @return
     */
    int deleteMenuRole(int menuRoleId);
}
