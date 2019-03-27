package com.personnel.service;

import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.dao.StaffDao;
import com.personnel.dao.impl.StaffDaoImpl;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-27 下午 6:18
 */
public class StaffService {
    private StaffDao dao=new StaffDaoImpl();
    public List<Staff> findAll(){return dao.findAll();}
    public List<Staff> queryStaffPage(PageBean pageBean){return dao.queryStaffPage(pageBean);}
    public int addStaff(Staff staff){return dao.addStaff(staff);}
    public int updateStaff(Staff staff){return dao.updateStaff(staff);}
    public int deleteStaff(int staffId){return dao.deleteStaff(staffId);}
    public Staff queryOne(int staffId){return dao.queryOne(staffId);}
}
