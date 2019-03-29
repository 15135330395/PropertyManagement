package com.manager.dao;

import com.entity.PageBean;
import com.manager.entity.Building;

import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public interface BuildingDao {

    public List<Building> findAll();

    public Building findBuildingById(int id);

    public int addBuilding(Building building);

    public int deleteBuilding(int id);

    public int updateBuilding(Building building);

    public int findBuildingCountByArea(int areaId);

    public int getConut();

    public List<Building> queryPageList(PageBean pageBean);

    public Building queryOne(int buildingId);

}
