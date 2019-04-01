package com.equipment.dao;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import com.entity.PageBean;
import com.equipment.entity.Equmaintenance;

import java.util.List;

public interface EqumaintenanceDao {

    public List<Equmaintenance> findAll();

    public int add(Equmaintenance equmaintenance);

    public int update(Equmaintenance equmaintenance);

    public int deleteById(int id);

    public List<Equmaintenance> queryPage(PageBean pageBean);

    public Equmaintenance findById(int id);
}
