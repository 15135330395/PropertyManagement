package com.personnel.dao;

import com.entity.PageBean;
import com.entity.Staff;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-27 上午 11:16
 */
public interface StaffDao {
    public List<Staff> findAll();
    public List<Staff> queryStaffPage(PageBean pageBean);
    public int addStaff(Staff staff);
    public int updateStaff(Staff staff);
    public int deleteStaff(int staffId);
    public Staff queryOne(int staffId);

    public Staff queryOneStaff(int staffId);
    public List<Staff> queryStaffByDepartmentId(int departmentId);
}
