package com.manager.service;

import com.manager.dao.HouseDao;
import com.manager.dao.daoimpl.HouseDaoImpl;
import com.manager.entity.House;

import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/27
 */
public class HouseService {

    HouseDao dao = new HouseDaoImpl();

    public List<House> findAll(){
        return dao.findAll();
    }

    public House findHouseById(int houseId){
        return dao.findHouseById(houseId);
    }

    public int addHouse(House house){
        return dao.addHouse(house);
    }

    public int deleteHouse(int houseId){
        return dao.deleteHouse(houseId);
    }

    public int updateHouse(House house){
        return dao.updateHouse(house);
    }

}
