package com.system.entity;

/**
 * @Description 用户表
 * @Author WYR
 * @CreateTime 2019-03-31 14:11
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private String roleName;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRole_name(String roleName) {
        this.roleName = roleName;
    }
}
