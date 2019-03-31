package com.system.dao;

import com.entity.PageBean;
import com.system.entity.User;

import java.util.List;

/**
 * @Description UserDao
 * @Author WYR
 * @CreateTime 2019-03-31 14:40
 */
public interface UserDao {
    /**
     * 查询所有的用户
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询所有用户的分页
     *
     * @return
     */
    List<User> getAllUserByPage(PageBean pageBean);

    /**
     * 通过ID查找用户
     *
     * @param userId
     * @return
     */
    User findUserById(int userId);

    /**
     * 通过username查找用户
     *
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int deleteUser(int userId);
}
