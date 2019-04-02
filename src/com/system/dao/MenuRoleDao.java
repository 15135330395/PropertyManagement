package com.system.dao;

import com.system.entity.MenuRole;

import java.util.List;

/**
 * @Description MenuRoleDao
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public interface MenuRoleDao {

    /**
     * 通过roleId获得权限
     *
     * @param roleId
     * @return
     */
    List<MenuRole> getAllMenuByRoleId(int roleId);

    /**
     * 添加权限用户映射表
     *
     * @param menuRole
     * @return
     */
    int addMenuRole(MenuRole menuRole);

    /**
     * 删除权限用户映射表
     *
     * @param menuRoleId
     * @return
     */
    int deleteMenuRole(int menuRoleId);

    /**
     * 通过roleId删除权限用户映射表
     *
     * @param roleId
     * @return
     */
    int deleteMenuRoleByRoleId(int roleId);
}
