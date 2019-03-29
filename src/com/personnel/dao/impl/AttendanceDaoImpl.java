package com.personnel.dao.impl;

import com.entity.PageBean;
import com.personnel.dao.AttendanceDao;
import com.personnel.entity.Attendance;
import com.personnel.entity.Recuit;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public class AttendanceDaoImpl implements AttendanceDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<Attendance> findAll() {
        String sql="select *from attendance order by attendance_id";
        try {
            List<Attendance> attendanceList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Attendance.class));
            return  attendanceList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Attendance> queryPage(PageBean pageBean) {
        String sql="select *from attendance order by attendance_id limit ?,?";
        try {
            List<Attendance> attendanceList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Attendance.class), pageBean.getIndex(), pageBean.getPageCount());
            return attendanceList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addAttendance(Attendance attendance) {
        String sql="insert into attendance (staff_id,staff_name,department_name,work_day," +
                "actual_attendance,sick_leave,affair_leave,onduty,abnormal) " +
                "values(?,?,?,?,?,?,?,?,?)";
        Object[] objs={attendance.getStaffId(),attendance.getStaffName(),attendance.getDepartmentName(),
        attendance.getWorkDay(),attendance.getActualAttendance(),attendance.getSickLeave(),
                attendance.getAffairLeave(),attendance.getOnduty(),attendance.getAbnormal()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateAttendance(Attendance attendance) {
        String sql="update attendance set staff_id=?,staff_name=?,department_name=?,work_day=?,actual_attendance=? " +
                ",sick_leave=?, affair_leave=?,onduty=?,abnormal=? where attendance_id=?";
        Object[] objs={attendance.getStaffId(),attendance.getStaffName(),attendance.getDepartmentName(),
                attendance.getWorkDay(),attendance.getActualAttendance(),attendance.getSickLeave(),
                attendance.getAffairLeave(),attendance.getOnduty(),attendance.getAbnormal(),attendance.getAttendanceId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteAttendance(int attendanceId) {
        String sql="delete from attendance  where attendance_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, attendanceId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public Attendance queryOne(int attendanceId) {
        String sql="select * from attendance  where attendance_id=?";
        try {
            Attendance attendance = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Attendance.class), attendanceId);
            return attendance;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
