package com.storage.dao;



import com.storage.entity.OutStorage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:15
 * Description: No Description
 */
public interface OutStorageDao {
    List<OutStorage> findAll();
//    int update(OutStorage outStorage);
    List<OutStorage> findOne(int id, String goodName);
//    int deleteById(int id);
    int add(OutStorage outStorage);
    List<OutStorage> queryLimitDate(String startDate, String endDate);
}
