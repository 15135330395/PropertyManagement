package com.logistics.service;

import com.entity.PageBean;
import com.entity.Staff;
import com.logistics.dao.LogisticsStaffDao;
import com.logistics.dao.impl.LogisticsStaffDaoImpl;

import java.util.List;

/**
 * @Description LogisticsStaffService
 * @Author WYR
 * @CreateTime 2019-03-30 18:12
 */
public class LogisticsStaffService {
    private LogisticsStaffDao dao = new LogisticsStaffDaoImpl();

    public List<Staff> getAllLogisticsStaff() {
        return dao.getAllLogisticsStaff();
    }

    public List<Staff> getAllLogisticsStaffByPage(PageBean pageBean) {
        return dao.getAllLogisticsStaffByPage(pageBean);
    }

    public Staff findLogisticsStaffById(int staffId) {
        return dao.findLogisticsStaffById(staffId);
    }

    public int updateLogisticsStaff(Staff staff) {
        return dao.updateLogisticsStaff(staff);
    }

}
