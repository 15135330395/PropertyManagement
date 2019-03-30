package com.logistics.dao;

import com.entity.PageBean;
import com.entity.Staff;

import java.util.List;

/**
 * @Description LogisticsStaffDao
 * @Author WYR
 * @CreateTime 2019-03-30 18:07
 */
public interface LogisticsStaffDao {
    /**
     * 查询所有后勤部的员工
     *
     * @return
     */
    List<Staff> getAllLogisticsStaff();

    /**
     * 查询所有后勤部员工的分页
     *
     * @param pageBean
     * @return
     */
    List<Staff> getAllLogisticsStaffByPage(PageBean pageBean);

    /**
     * 通过ID查找员工
     *
     * @param staffId
     * @return
     */
    Staff findLogisticsStaffById(int staffId);

    /**
     * 修改员工部分信息
     *
     * @param staff
     * @return
     */
    int updateLogisticsStaff(Staff staff);
}
