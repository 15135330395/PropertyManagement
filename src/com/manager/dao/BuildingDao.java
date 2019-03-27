package com.manager.dao;

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

}
