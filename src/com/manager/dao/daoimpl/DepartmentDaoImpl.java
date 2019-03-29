package com.manager.dao.daoimpl;

import com.entity.Department;
import com.entity.PageBean;
import com.manager.dao.DepartmentDao;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/29
 */
public class DepartmentDaoImpl implements DepartmentDao {

    private QueryRunner queryRunner =  new QueryRunner();
    @Override
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();

        String sql = "select * from department";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Department department = new Department();
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                department.setDepartmentId(departmentId);
                department.setDepartmentName(departmentName);
                list.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }else if(ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return list;
    }

    @Override
    public Department findDepartmentById(int id) {
        Department department =  new Department();
        String sql="select * from department where department_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                department.setDepartmentId(departmentId);
                department.setDepartmentName(departmentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return department;
    }

    @Override
    public int addDepartment(Department department) {
        String sql="insert into department (department_name) values (?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, department.getDepartmentName());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteDepartment(int id) {
        String sql="delete from department where department_id = ? ";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, id);
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateDepartment(Department department) {
        String sql="update department set department_name=? where  department_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, department.getDepartmentName(), department.getDepartmentId());
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Department> queryByPage(PageBean pageBean) {
        List<Department> list = new ArrayList<>();

        String sql="select * from department limit ?,?  ";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()) {
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");

                Department department =  new Department();
                department.setDepartmentId(departmentId);
                department.setDepartmentName(departmentName);
                list.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return list;
    }
}
