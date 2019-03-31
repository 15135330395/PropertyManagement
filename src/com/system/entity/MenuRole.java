package com.system.entity;

/**
 * @Description 权限和角色的映射表
 * @Author WYR
 * @CreateTime 2019-03-31 14:34
 */
public class MenuRole {
    private int menuRoleId;
    private int menuId;
    private int RoleId;

    public MenuRole() {
    }

    public int getMenuRoleId() {
        return menuRoleId;
    }

    public void setMenu_role_id(int menuRoleId) {
        this.menuRoleId = menuRoleId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenu_id(int menuId) {
        this.menuId = menuId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRole_id(int roleId) {
        RoleId = roleId;
    }
}
