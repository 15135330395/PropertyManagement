package com.personnel.dao;

import com.entity.PageBean;
import com.personnel.entity.Attendance;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public interface AttendanceDao {
    public List<Attendance> findAll();
    public List<Attendance> queryPage(PageBean pageBean);
    public int addAttendance(Attendance attendance);
    public int updateAttendance(Attendance attendance);
    public int deleteAttendance(int attendanceId);
    public Attendance queryOne(int attendanceId);
}
