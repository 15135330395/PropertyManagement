package com.manager.dao;

import com.entity.PageBean;
import com.manager.entity.Area;

import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/26
 */
public interface AreaDao {

    public List<Area> findAll();

    public Area findAreaById(int id);

    public int addArea(Area area);

    public int deleteArea(int id);

    public int updateArea(Area area);

    public List<Area> queryByPage(PageBean pageBean);


}
