package com.shenshi.service;

import com.shenshi.dao.AreaDao;
import com.shenshi.dao.AreaDaoImp;
import com.shenshi.model.Area;

import java.util.ArrayList;
import java.util.List;
//业务操作实现类，调用dao层接口
public class AreaServiceImp implements AreaService {
    private AreaDao areacity=new AreaDaoImp();
	@Override
	public List<Area> getAreaByParentno(int id) {
		List<Area> list=new ArrayList<Area>();
		return list=areacity.getAreaByParentno(id);
	}

}
