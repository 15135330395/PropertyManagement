package com.manager.dao;


import com.entity.PageBean;
import com.manager.entity.Department;

import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/29
 */
public interface DepartmentDao {

    public List<Department> findAll();

    public Department findDepartmentById(int id);

    public int addDepartment(Department department);

    public int deleteDepartment(int id);

    public int updateDepartment(Department department);

    public List<Department> queryByPage(PageBean pageBean);

}
