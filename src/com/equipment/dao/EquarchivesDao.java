package com.equipment.dao;/*
 * @author:张国栋
 * Date  ：2019/3/31
 * */

import com.entity.PageBean;
import com.equipment.entity.Equarchives;

import java.util.List;

public interface EquarchivesDao {

    public List<Equarchives> findAll();

    public int add(Equarchives equarchives);

    public int update(Equarchives equarchives);

    public int deleteById(int id);

    public List<Equarchives> queryPage(PageBean pageBean);

    public Equarchives findById(int id);
}
