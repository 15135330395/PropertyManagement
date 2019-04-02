package com.storage.service;


import com.storage.dao.DiaoBoDao;
import com.storage.dao.daoImpl.DiaoBoDaoImpl;
import com.storage.entity.DiaoBo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/27
 * Time: 11:19
 * Description: No Description
 */
public class DiaoBoService {
    public DiaoBoDao diaoBoDao=new DiaoBoDaoImpl();
    public List<DiaoBo> findAll(){
        return  diaoBoDao.findAll();
    }
    //    int update(DiaoBo diaoBo);
    //找到一个物品的所有调拨记录
    public List<DiaoBo> findOne(String goodName){
        return diaoBoDao.findOne(goodName);
    }
    //    int deleteById(int id);
    public int add(DiaoBo diaoBo){
        return diaoBoDao.add(diaoBo);
    }

    public List<DiaoBo> queryLimitDate(String startDate,String endDate){
        return diaoBoDao.queryLimitDate(startDate,endDate);
    }
}
