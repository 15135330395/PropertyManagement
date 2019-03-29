package com.manager.service;

import com.entity.PageBean;
import com.manager.dao.AreaDao;
import com.manager.dao.daoimpl.AreaDaoImpl;
import com.manager.entity.Area;

import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/27
 */
public class AreaService {

    AreaDao dao = new AreaDaoImpl();

    public List<Area> findAll(){
        return dao.findAll();
    }

    public Area findAreaById(int areaId){
        return dao.findAreaById(areaId);
    }

    public int addArea(Area area){
        return dao.addArea(area);
    }

    public int deleteArea(int areaId){
        return dao.deleteArea(areaId);
    }

    public int updateArea(Area area){
        return  dao.updateArea(area);
    }
    public List<Area> queryByPage(PageBean pageBean){
        return dao.queryByPage(pageBean);
    }
}
