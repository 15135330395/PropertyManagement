package com.personnel.dao.impl;

import com.entity.PageBean;
import com.personnel.dao.LabourContractDao;
import com.personnel.entity.Interview;
import com.personnel.entity.LabourContract;
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
public class LabourContractDaoImpl implements LabourContractDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<LabourContract> findAll() {
        String sql="select *from labour_contract order by labour_contract_id";
        try {
            List<LabourContract> labourContractList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(LabourContract.class));
            return  labourContractList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<LabourContract> queryPage(PageBean pageBean) {
        String sql="select *from labour_contract order by labour_contract_id limit ?,?";
        try {
            List<LabourContract> labourContractList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(LabourContract.class), pageBean.getIndex(), pageBean.getPageCount());
            return labourContractList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addLabourContract(LabourContract labourContract) {
        String sql="insert into labour_contract (company_name,staff_name,job_time,sign_time,basic_salary) " +
                "values(?,?,?,?,?)";
        Object[] objs={labourContract.getCompanyName(),labourContract.getStaffName(),labourContract.getJobTime(),labourContract.getSignTime(),labourContract.getBasicSalary()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateLabourContract(LabourContract labourContract) {
        String sql="update labour_contract set company_name=?,staff_name=?,job_time=?,sign_time=?,basic_salary=? " +
                "where labour_contract_id=?";
        Object[] objs={labourContract.getCompanyName(),labourContract.getStaffName(),
                labourContract.getJobTime(),labourContract.getSignTime(),
                labourContract.getBasicSalary(),labourContract.getLabourContractId()};

        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteLabourContract(int labourContractId) {
        String sql="delete from labour_contract  where labour_contract_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, labourContractId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public LabourContract queryOne(int labourContractId) {
        String sql="select * from labour_contract  where labour_contract_id=?";
        try {
            LabourContract labourContract = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(LabourContract.class), labourContractId);
            return labourContract;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
