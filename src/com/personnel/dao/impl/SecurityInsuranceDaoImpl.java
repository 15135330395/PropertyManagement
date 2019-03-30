package com.personnel.dao.impl;

import com.entity.PageBean;
import com.personnel.dao.SecurityInsuranceDao;
import com.personnel.entity.SecurityInsurance;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
public class SecurityInsuranceDaoImpl implements SecurityInsuranceDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<SecurityInsurance> findAll() {

        String sql="select *from security_insurance order by security_insurance_id";
        try {
            List<SecurityInsurance> securityInsuranceList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(SecurityInsurance.class));
            return  securityInsuranceList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SecurityInsurance> queryPage(PageBean pageBean) {
        String sql="select i.* ,s.staff_name ,s.station,s.education,s.city,s.household from staff s, security_insurance i " +
                "where s.staff_id=i.staff_id order by security_insurance_id  limit ?,?";
        try {
            List<SecurityInsurance> securityInsuranceList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(SecurityInsurance.class), pageBean.getIndex(), pageBean.getPageCount());

            return securityInsuranceList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addSecurityInsurance(SecurityInsurance securityInsurance) {
        String sql="insert into security_insurance (staff_id,endowment_insurance,medical_insurance," +
                "unemployment_insurance,employment_injury_insurance,maternity_insurance," +
                "public_housing_funds)values(?,?,?,?,?,?,?)";
        Object[] objs={securityInsurance.getStaffId(),securityInsurance.getEndowmentInsurance(),
                securityInsurance.getMedicalInsurance(),
                securityInsurance.getUnemploymentInsurance(),securityInsurance.getEmploymentInjuryInsurance(),
                securityInsurance.getMaternityInsurance(),securityInsurance.getPublicHousingFunds()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateSecurityInsurance(SecurityInsurance securityInsurance) {
        String sql="update security_insurance set staff_id=?, endowment_insurance=?,medical_insurance=?, unemployment_insurance=?," +
                "employment_injury_insurance=?, maternity_insurance=?, public_housing_funds=? " +
                " where security_insurance_id=?";
        Object[] objs={securityInsurance.getStaffId(),securityInsurance.getEndowmentInsurance(),
                securityInsurance.getMedicalInsurance(),
                securityInsurance.getUnemploymentInsurance(),securityInsurance.getEmploymentInjuryInsurance(),
                securityInsurance.getMaternityInsurance(),securityInsurance.getPublicHousingFunds(),
                securityInsurance.getSecurityInsuranceId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteSecurityInsurance(int securityInsuranceId) {
        String sql="delete from security_insurance  where security_insurance_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, securityInsuranceId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public SecurityInsurance queryOne(int securityInsuranceId) {
        String sql="select i.* ,s.staff_name ,s.station,s.education,s.city,s.household from staff s, security_insurance i " +
                "where s.staff_id=i.staff_id and i.security_insurance_id=?";
        try {
            SecurityInsurance securityInsurance = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(SecurityInsurance.class), securityInsuranceId);
            return securityInsurance;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
