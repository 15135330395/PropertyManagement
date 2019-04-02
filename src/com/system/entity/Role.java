package com.system.entity;

/**
 * @Description 角色表
 * @Author WYR
 * @CreateTime 2019-03-31 14:10
 */
public class Role {

    private int roleId;
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRole_id(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRole_name(String roleName) {
        this.roleName = roleName;
    }
}
