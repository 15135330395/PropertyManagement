package com.system.service;

import com.system.dao.RoleUserDao;
import com.system.dao.impl.RoleUserDaoImpl;
import com.system.entity.RoleUser;

import java.util.List;

/**
 * @Description RoleUserService
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public class RoleUserService {
    private RoleUserDao dao = new RoleUserDaoImpl();

    public List<RoleUser> getAllRoleUser() {
        return dao.getAllRoleUser();
    }

    public RoleUser findRoleUserByUserId(int userId) {
        return dao.findRoleUserByUserId(userId);
    }

    public int addRoleUser(RoleUser roleUser) {
        dao.deleteByUserId(roleUser.getUserId());
        return dao.addRoleUser(roleUser);
    }

    public int deleteRoleUser(int roleUserId) {
        return dao.deleteRoleUser(roleUserId);
    }
}
