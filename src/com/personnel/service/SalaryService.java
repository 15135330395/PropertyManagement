package com.personnel.service;

import com.entity.PageBean;
import com.personnel.dao.SalaryDao;
import com.personnel.dao.impl.SalaryDaoImpl;
import com.personnel.entity.Salary;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/31
 */
public class SalaryService {
    private SalaryDao dao=new SalaryDaoImpl();
    public List<Salary> findAll(){return dao.findAll();}
    public List<Salary> queryPage(PageBean pageBean){return dao.queryPage(pageBean);}
    public int addSalary(Salary salary){return dao.addSalary(salary);}
    public int updateSalary(Salary salary){return dao.updateSalary(salary);}
    public int deleteSalary(int salaryId){return dao.deleteSalary(salaryId);}
    public Salary queryOne(int salaryId){return dao.queryOne(salaryId);}

    public Salary queryOneByStaffId(int staffId) {
        return dao.queryOneByStaffId(staffId);
    }
}
