package com.storage.service;


import com.storage.dao.GoodsDao;
import com.storage.dao.daoImpl.GoodsDaoImpl;
import com.storage.entity.Goods;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/27
 * Time: 11:25
 * Description: No Description
 */
public class GoodsService {
    public GoodsDao goodsDao=new GoodsDaoImpl();
    public List<Goods> findAll(){
        return goodsDao.findAll();
    }

    public int update(Goods goods){
        return goodsDao.update(goods);
    }

    public Goods findOne(int id, String goodName){
        return goodsDao.findOne(id,goodName);
    }

    public int add(Goods goods){
        return goodsDao.add(goods);
    }

    public List<Goods> findByGoodsName(String goodName){
        return goodsDao.findByGoodsName(goodName);
    }

    public int delete(int id,String goodName){
        return goodsDao.delete(id,goodName);
    }

    public List<Goods> findWarning(){
        return goodsDao.findWarning();
    }
}
