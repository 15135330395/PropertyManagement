package com.shenshi.dao;

import com.shenshi.model.Area;

import java.util.List;
//dao层接口
public interface AreaDao {
	
	public List<Area> getAreaByParentno(int id);
}
