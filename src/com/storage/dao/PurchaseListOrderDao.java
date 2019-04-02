package com.storage.dao;


import com.storage.entity.PurchaseListOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:15
 * Description: No Description
 */
public interface PurchaseListOrderDao {
    List<PurchaseListOrder> findAll();
//    int update(PurchaseListOrder purchaseApply);
    List<PurchaseListOrder> findOne(int id, String goodName);
//    int delete(int id,String goodName);
    int add(PurchaseListOrder purchaseListOrder);
    List<PurchaseListOrder> queryLimitDate(String startDate, String endDate);
}
