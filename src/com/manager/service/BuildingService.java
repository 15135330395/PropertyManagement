package com.manager.service;

import com.manager.dao.BuildingDao;
import com.manager.dao.daoimpl.BuildingDaoImpl;
import com.manager.entity.Building;

import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/27
 */
public class BuildingService {

    BuildingDao dao = new BuildingDaoImpl();

    public List<Building> findAll(){
        return dao.findAll();
    }

    public Building findBuildingById(int buildingId){
        return dao.findBuildingById(buildingId);
    }

    public int addBuilding(Building building){
        return dao.addBuilding(building);
    }

    public int deleteBuilding(int buildingId){
        return dao.deleteBuilding(buildingId);
    }

    public int updateBuilding(Building building){
        return dao.updateBuilding(building);
    }


}
