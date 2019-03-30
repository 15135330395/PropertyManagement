package com.logistics.dao;

import com.logistics.entity.Cleaner;

import java.util.List;

/**
 * @Description CleanerDao
 * @Author WYR
 * @CreateTime 2019-03-29 18:11
 */
public interface CleanerDao {
    /**
     * 查询所有的Cleaner
     * @return
     */
   List<Cleaner> getAllCleaner();
}
