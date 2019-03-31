package com.system.service;

import com.entity.PageBean;
import com.system.dao.UserDao;
import com.system.dao.impl.UserDaoImpl;
import com.system.entity.User;
import com.utils.MD5Util;

import java.util.List;

/**
 * @Description UserService
 * @Author WYR
 * @CreateTime 2019-03-31 14:40
 */
public class UserService {
    private UserDao dao = new UserDaoImpl();

    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    public List<User> getAllUserByPage(PageBean pageBean) {
        return dao.getAllUserByPage(pageBean);
    }

    public User findUserById(int userId) {
        return dao.findUserById(userId);
    }

    public User findUserByUsername(String username) {
        return dao.findUserByUsername(username);
    }

    public int addUser(User user) {
        // MD5 加密
        user.setPassword(MD5Util.MD5Test(user.getUsername() + user.getPassword()));
        return dao.addUser(user);
    }

    public int updateUser(User user) {
        user.setPassword(MD5Util.MD5Test(user.getUsername() + user.getPassword()));
        return dao.updateUser(user);
    }

    public int deleteUser(int userId) {
        return dao.deleteUser(userId);
    }
}
