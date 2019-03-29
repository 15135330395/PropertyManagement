package com.personnel.service;

import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.dao.StaffDao;
import com.personnel.dao.impl.StaffDaoImpl;

import java.util.Date;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-27 下午 6:18
 */
public class StaffService {
    private StaffDao dao=new StaffDaoImpl();
    public List<Staff> findAll(){return dao.findAll();}
    public List<Staff> queryStaffPage(PageBean pageBean){return dao.queryStaffPage(pageBean);}
    public int addStaff(Staff staff){
//        int id=0;
//        Date date = new Date(System.currentTimeMillis());
//        int year = date.getYear();
//        int month = date.getMonth()+1;
//        int day = date.getDate();
//        String str = ""+year+month+day;
//
//        id=Integer.parseInt(str);
//        System.out.println(id);
//
//        staff.setStaff_id(id);
        return dao.addStaff(staff);
    }
    public int updateStaff(Staff staff){return dao.updateStaff(staff);}
    public int deleteStaff(int staffId){return dao.deleteStaff(staffId);}
    public Staff queryOne(int staffId){return dao.queryOne(staffId);}

    public Staff queryOneStaff(int staffId) {
        return dao.queryOneStaff(staffId);
    }
}
