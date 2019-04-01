package com.personnel.dao;

import com.entity.PageBean;

import com.personnel.entity.SecurityInsurance;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public interface SecurityInsuranceDao {
    public List<SecurityInsurance> findAll();
    public List<SecurityInsurance> queryPage(PageBean pageBean);
    public int addSecurityInsurance(SecurityInsurance securityInsurance);
    public int updateSecurityInsurance(SecurityInsurance securityInsurance);
    public int deleteSecurityInsurance(int securityInsuranceId);
    public SecurityInsurance queryOne(int securityInsuranceId);

    SecurityInsurance queryOneByStaffId(int staffId);
}
