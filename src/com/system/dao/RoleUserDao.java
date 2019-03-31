package com.system.dao;

import com.system.entity.RoleUser;

import java.util.List;

/**
 * @Description RoleUserDao
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public interface RoleUserDao {

    /**
     * 查询所有的角色和用户映射表
     *
     * @return
     */
    List<RoleUser> getAllRoleUser();

    /**
     * 添加角色和用户映射表
     *
     * @param roleUser
     * @return
     */
    int addRoleUser(RoleUser roleUser);

    /**
     * 修改角色和用户映射表
     *
     * @param roleUser
     * @return
     */
    int updateRoleUser(RoleUser roleUser);

    /**
     * 删除添加角色和用户映射表
     *
     * @param roleUserId
     * @return
     */
    int deleteRoleUser(int roleUserId);
}
