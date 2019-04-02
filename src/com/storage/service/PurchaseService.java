package com.storage.service;


import com.storage.dao.PurchaseDeliverDao;
import com.storage.dao.PurchaseListOrderDao;
import com.storage.dao.daoImpl.PurchaseDeliverDaoImpl;
import com.storage.dao.daoImpl.PurchaseListOrderDaoImpl;
import com.storage.entity.PurchaseDeliver;
import com.storage.entity.PurchaseListOrder;

import java.util.List;

/**
 * author wzh
 * Created on 2019/3/26
 */
public class PurchaseService {
    PurchaseDeliverDao purchaseDeliverDao=new PurchaseDeliverDaoImpl();
    PurchaseListOrderDao purchaseListOrderDao=new PurchaseListOrderDaoImpl();

    //PurchaseDeliver的所有方法
    public List<PurchaseDeliver> PurchaseDeliverfindAll(){
        return purchaseDeliverDao.findAll();
    }

    public int PurchaseDeliverupdate(PurchaseDeliver purchaseDeliver){
        return purchaseDeliverDao.update(purchaseDeliver);
    }

    public PurchaseDeliver PurchaseDeliverfindOne(int id, String goodName){
        return purchaseDeliverDao.findOne(id,goodName);
    }

    public int PurchaseDeliveradd(PurchaseDeliver purchaseDeliver){
        return purchaseDeliverDao.add(purchaseDeliver);
    }

    public int PurchaseDeliverdelete(int id,String goodName){
        return purchaseDeliverDao.delete(id,goodName);
    }

    //PurchaseListOrder的所有方法
    public List<PurchaseListOrder> PurchaseListOrderfindAll(){
        return purchaseListOrderDao.findAll();
    }

    public List<PurchaseListOrder> PurchaseListOrderfindOne(int id, String goodName){
        return purchaseListOrderDao.findOne(id,goodName);
    }

    public int PurchaseListOrderadd(PurchaseListOrder purchaseListOrder){
        return purchaseListOrderDao.add(purchaseListOrder);
    }

    public List<PurchaseListOrder> queryLimitDate(String startDate,String endDate){
        return purchaseListOrderDao.queryLimitDate(startDate,endDate);
    }
}
