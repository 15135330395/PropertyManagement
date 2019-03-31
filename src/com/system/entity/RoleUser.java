package com.system.entity;

/**
 * @Description 角色和用户的映射表
 * @Author WYR
 * @CreateTime 2019-03-31 14:19
 */
public class RoleUser {
    private int roleUserId;
    private int roleId;
    private int userId;

    public RoleUser() {
    }

    public int getRoleUserId() {
        return roleUserId;
    }

    public void setRole_user_id(int roleUserId) {
        this.roleUserId = roleUserId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRole_id(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }
}
