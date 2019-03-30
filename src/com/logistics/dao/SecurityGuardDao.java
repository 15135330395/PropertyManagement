package com.logistics.dao;

import com.logistics.entity.SecurityGuard;

import java.util.List;

/**
 * @Description SecurityGuardDao
 * @Author WYR
 * @CreateTime 2019-03-30 16:35
 */
public interface SecurityGuardDao {

    /**
     * 查询所有的Guard
     * @return
     */
    List<SecurityGuard> getAllGuard();
}
