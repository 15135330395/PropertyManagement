package com.equipment.service;/*
 * @author:张国栋
 * Date  ：2019/4/1
 * */

import com.entity.PageBean;
import com.equipment.dao.EqumaintenanceDao;
import com.equipment.dao.daoImpl.EqumaintenanceDaoImpl;
import com.equipment.entity.Equmaintenance;

import java.util.List;

public class EqumaintenanceService {
    EqumaintenanceDao dao=new EqumaintenanceDaoImpl();

    public List<Equmaintenance> findAll(){

        return dao.findAll();
    }

    public int add (Equmaintenance equmaintenance){
        return dao.add (equmaintenance);
    }

    public int update (Equmaintenance equmaintenance){
        return dao.update(equmaintenance);
    }

    public int deleteById(int id){
        return dao.deleteById(id);
    }

    public List<Equmaintenance> queryPage(PageBean pageBean){
        return dao.queryPage(pageBean);
    }

    public Equmaintenance findById(int id){
        return dao.findById(id);
    }

}
