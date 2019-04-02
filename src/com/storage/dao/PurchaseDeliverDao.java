package com.storage.dao;


import com.storage.entity.PurchaseDeliver;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:15
 * Description: No Description
 */
public interface PurchaseDeliverDao {
    List<PurchaseDeliver> findAll();
    int update(PurchaseDeliver purchaseDeliver);
    PurchaseDeliver findOne(int id, String goodName);
    int delete(int id, String goodName);
    int add(PurchaseDeliver purchaseDeliver);
}
