package com.shenshi.service;

import com.shenshi.model.Area;

import java.util.List;

public interface AreaService {
	public List<Area> getAreaByParentno(int id);
}
