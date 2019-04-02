package com.storage.dao;


import com.storage.entity.Storage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:11
 * Description: No Description
 */
public interface StorageDao {
    List<Storage> findAll();
    int update(Storage storage);
    Storage findOne(int id);
//    int deleteById(int id);
    int add(Storage storage);
}
