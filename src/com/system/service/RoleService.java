package com.system.service;


import com.entity.PageBean;
import com.system.dao.RoleDao;
import com.system.dao.impl.RoleDaoImpl;
import com.system.entity.Role;

import java.util.List;

/**
 * @Description RoleDao
 * @Author WYR
 * @CreateTime 2019-03-31 14:39
 */
public class RoleService {
    private RoleDao dao = new RoleDaoImpl();

    public List<Role> getAllRole() {
        return dao.getAllRole();
    }
    public List<Role> getAllRoleByPage(PageBean pageBean) {
        return dao.getAllRoleByPage(pageBean);
    }
    public Role findRoleById(int roleId) {
        return dao.findRoleById(roleId);
    }
    public int addRole(Role role) {
        return dao.addRole(role);
    }

    public int updateRole(Role role) {
        return dao.updateRole(role);
    }

    public int deleteRole(int roleId) {
        return dao.deleteRole(roleId);
    }

}
