package com.storage.dao;



import com.storage.entity.Goods;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 17:32
 * Description: No Description
 */
public interface GoodsDao {
    List<Goods> findAll();
    int update(Goods goods);
    Goods findOne(int id, String goodName);
    int delete(int id, String goodName);
    int add(Goods goods);
    List<Goods> findByGoodsName(String goodName);
    List<Goods> findWarning();
}
