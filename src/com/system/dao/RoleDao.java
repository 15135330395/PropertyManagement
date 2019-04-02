package com.system.dao;


import com.entity.PageBean;
import com.system.entity.Role;

import java.util.List;

/**
 * @Description RoleDao
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public interface RoleDao {
    /**
     * 查询所有的角色
     *
     * @return
     */
    List<Role> getAllRole();

    /**
     * 查询所有角色的分页
     * @param pageBean
     * @return
     */
    List<Role> getAllRoleByPage(PageBean pageBean);

    /**
     * 通过ID查询角色
     * @param roleId
     * @return
     */
    Role findRoleById(int roleId);

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    int deleteRole(int roleId);

}
