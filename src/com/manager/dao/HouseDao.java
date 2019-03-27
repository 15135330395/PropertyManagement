package com.manager.dao;

import com.manager.entity.House;

import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public interface HouseDao {

    public List<House> findAll();

    public House findHouseById(int id);

    public int addHouse(House house);

    public int deleteHouse(int id);

    public int updateHouse(House house);

}
