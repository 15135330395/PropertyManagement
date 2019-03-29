package com.personnel.dao;

import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.entity.Salary;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public interface SalaryDao {
    public List<Salary> findAll();
    public List<Salary> queryPage(PageBean pageBean);
    public int addSalary(Salary salary);
    public int updateSalary(Salary salary);
    public int deleteSalary(int salaryId);
    public Salary queryOne(int salaryId);
}
