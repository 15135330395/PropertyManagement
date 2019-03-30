package com.logistics.service;

import com.logistics.dao.SecurityGuardDao;
import com.logistics.dao.impl.SecurityGuardDaoImpl;
import com.logistics.entity.SecurityGuard;

import java.util.List;

/**
 * @Description SecurityGuardService
 * @Author WYR
 * @CreateTime 2019-03-30 16:40
 */
public class SecurityGuardService {
    private SecurityGuardDao dao = new SecurityGuardDaoImpl();

    public List<SecurityGuard> getAllGuard() {
        return dao.getAllGuard();
    }
}
