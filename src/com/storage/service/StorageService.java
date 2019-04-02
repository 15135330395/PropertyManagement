package com.storage.service;


import com.storage.dao.StorageDao;
import com.storage.dao.daoImpl.StorageDaoImpl;
import com.storage.entity.Storage;

import java.util.List;

/**
 * author wzh
 * Created on 2019/3/26
 */
public class StorageService {
    StorageDao storageDao=new StorageDaoImpl();

    public List<Storage> findAll(){
        return storageDao.findAll();
    }

    public int update(Storage storage){
        return storageDao.update(storage);
    }

//    int deleteById(int id){
//        return storageDao.deleteById(id);
//    }

    public int add(Storage storage){
        return storageDao.add(storage);
    }

    public Storage findOne(int id){
        return storageDao.findOne(id);
    }
}
