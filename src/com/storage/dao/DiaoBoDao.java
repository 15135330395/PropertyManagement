package com.storage.dao;



import com.storage.entity.DiaoBo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:11
 * Description: No Description
 */
public interface DiaoBoDao {
    List<DiaoBo> findAll();
//    int update(DiaoBo diaoBo);
    //找到一个物品的所有调拨记录
    List<DiaoBo> findOne(String goodName);
//    int deleteById(int id);
    int add(DiaoBo diaoBo);
    List<DiaoBo> queryLimitDate(String startDate, String endDate);
}
