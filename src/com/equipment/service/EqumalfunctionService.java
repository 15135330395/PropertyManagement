package com.equipment.service;/*
 * @author:张国栋
 * Date  ：2019/4/1
 * */

import com.entity.PageBean;
import com.equipment.dao.EqumalfunctionDao;
import com.equipment.dao.daoImpl.EqumalfunctionDaoImpl;
import com.equipment.entity.Equmalfunction;

import java.util.List;

public class EqumalfunctionService {
    EqumalfunctionDao dao=new EqumalfunctionDaoImpl();

    public List<Equmalfunction> findAll(){

        return dao.findAll();
    }

    public int add (Equmalfunction equmalfunction){
        return dao.add (equmalfunction);
    }

    public int update (Equmalfunction equmalfunction){
        return dao.update(equmalfunction);
    }

    public int deleteById(int id){
        return dao.deleteById(id);
    }

    public List<Equmalfunction> queryPage(PageBean pageBean){
        return dao.queryPage(pageBean);
    }

    public Equmalfunction findById(int id){
        return dao.findById(id);
    }

}
