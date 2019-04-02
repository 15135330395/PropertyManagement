package com.storage.service;


import com.storage.dao.OutStorageDao;
import com.storage.dao.daoImpl.OutStorageDaoImpl;
import com.storage.entity.OutStorage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/27
 * Time: 11:28
 * Description: No Description
 */
public class OutStorageService {
    OutStorageDao outStorageDao=new OutStorageDaoImpl();
    public List<OutStorage> findAll(){
        return outStorageDao.findAll();
    }
    //    int update(OutStorage outStorage);
    public List<OutStorage> findOne(int id, String goodName){
        return outStorageDao.findOne(id,goodName);
    }
    //    int deleteById(int id);
    public int add(OutStorage outStorage){
        return outStorageDao.add(outStorage);
    }

    public List<OutStorage> queryLimitDate(String startDate,String endDate){
        return outStorageDao.queryLimitDate(startDate,endDate);
    }
}
