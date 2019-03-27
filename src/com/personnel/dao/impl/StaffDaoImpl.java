package com.personnel.dao.impl;

import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.dao.StaffDao;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-27 上午 11:18
 */
public class StaffDaoImpl implements StaffDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<Staff> findAll() {
        String sql="select *from staff order by staff_id";
        try {
            List<Staff> staffList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Staff.class));
            return  staffList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Staff> queryStaffPage(PageBean pageBean) {
        String sql="select *from staff order by staff_id  limit ?,?";
        try {
            List<Staff> StaffList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Staff.class), pageBean.getIndex(), pageBean.getPageCount());
            return StaffList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addStaff(Staff staff) {
        String sql="insert into staff (staff_id,staff_name,staff_image,identity_card,age" +
                "sex,address,phone,email,city,household,station,education,department_id," +
                "salary_id,security_insurance_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] objs={staff.getStaffId(),staff.getStaffName(),staff.getStaffImage(),staff.getIdentityCard(),
        staff.getAge(),staff.getSex(),staff.getAddress(),staff.getPhone(),staff.getEmail(),staff.getCity(),
        staff.getHousehold(),staff.getStation(),staff.getEducation(),staff.getDepartmentId(),staff.getStaffId(),staff.getSecurityInsuranceId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateStaff(Staff staff) {
        String sql="update staff set staff_name=? staff_image=? identity_card=? age=?" +
                "sex=? address=? phone=? email=? city=? household=? station=? education=? " +
                "department_id=? salary_id=? security_insurance_id=? where staff_id=?";
        Object[] objs={staff.getStaffName(),staff.getStaffImage(),staff.getIdentityCard(),
                staff.getAge(),staff.getSex(),staff.getAddress(),staff.getPhone(),staff.getEmail(),staff.getCity(),
                staff.getHousehold(),staff.getStation(),staff.getEducation(),staff.getDepartmentId(),staff.getStaffId(),
                staff.getSecurityInsuranceId(),staff.getStaffId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteStaff(int staffId) {
        String sql="delete from staff  where staff_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, staffId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Staff queryOne(int staffId) {
        String sql="select * from staff  where staff_id=?";
        try {
            Staff staff = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Staff.class), staffId);
            return staff;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
