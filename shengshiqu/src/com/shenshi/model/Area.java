package com.shenshi.model;
/*封装一个实体类对象
在程序中仅作为数据容器用来持久化存储数据用的*/
public class Area {
	//省市区的名字
	private String name;
	
	private int parent_id;
	
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
