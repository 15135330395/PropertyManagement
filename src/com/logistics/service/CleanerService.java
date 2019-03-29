package com.logistics.service;

import com.logistics.dao.CleanerDao;
import com.logistics.dao.impl.CleanerDaoImpl;
import com.logistics.entity.Cleaner;

import java.util.List;

/**
 * @Description CleanerService
 * @Author WYR
 * @CreateTime 2019-03-29 18:46
 */
public class CleanerService {
    private CleanerDao dao = new CleanerDaoImpl();

    public List<Cleaner> getAllCleaner() {
        return dao.getAllCleaner();
    }
}
