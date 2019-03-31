package com.personnel.service;

import com.entity.PageBean;
import com.personnel.dao.AttendanceDao;
import com.personnel.dao.impl.AttendanceDaoImpl;
import com.personnel.entity.Attendance;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
public class AttendanceService {
    private AttendanceDao dao=new AttendanceDaoImpl();
    public List<Attendance> findAll(){return dao.findAll();}
    public List<Attendance> queryPage(PageBean pageBean){return dao.queryPage(pageBean);}
    public int addAttendance(Attendance attendance){return dao.addAttendance(attendance);}
    public int updateAttendance(Attendance attendance){return dao.updateAttendance(attendance);}
    public int deleteAttendance(int attendanceId){return dao.deleteAttendance(attendanceId);}
    public Attendance queryOne(int attendanceId){return dao.queryOne(attendanceId);}
}
