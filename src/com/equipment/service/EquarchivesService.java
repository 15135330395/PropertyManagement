package com.equipment.service;/*
 * @author:张国栋
 * Date  ：2019/4/1
 * */

import com.entity.PageBean;
import com.equipment.dao.EquarchivesDao;
import com.equipment.dao.daoImpl.EquarchivesDaoImpl;
import com.equipment.entity.Equarchives;

import java.util.List;

public class EquarchivesService {

    EquarchivesDao dao =new EquarchivesDaoImpl();
    public List<Equarchives> findAll(){

        return dao.findAll();
    }

    public int add (Equarchives equarchives){
        return dao.add(equarchives);
    }

    public int update(Equarchives equarchives){
        return dao.update(equarchives);
    }

    public int deleteById (int id){
        return dao.deleteById(id);
    }

    public List<Equarchives> queryPage(PageBean pageBean){
        return dao.queryPage(pageBean);
    }

    public Equarchives findById(int id){
        return dao.findById(id);
    }

}
