package com.equipment.dao;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import com.entity.PageBean;
import com.equipment.entity.Equmalfunction;

import java.util.List;

public interface EqumalfunctionDao {

    public List<Equmalfunction> findAll();

    public int add(Equmalfunction equmalfunction);

    public int update(Equmalfunction equmalfunction);

    public int deleteById(int id);

    public List<Equmalfunction> queryPage(PageBean pageBean);

    public Equmalfunction findById(int id);

}
