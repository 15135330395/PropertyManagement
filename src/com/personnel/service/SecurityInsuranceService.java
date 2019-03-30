package com.personnel.service;

import com.entity.PageBean;
import com.personnel.dao.SecurityInsuranceDao;
import com.personnel.dao.impl.SecurityInsuranceDaoImpl;
import com.personnel.entity.SecurityInsurance;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
public class SecurityInsuranceService {
    private SecurityInsuranceDao dao=new SecurityInsuranceDaoImpl();
    public List<SecurityInsurance> findAll(){return dao.findAll();}
    public List<SecurityInsurance> queryPage(PageBean pageBean){return dao.queryPage(pageBean);}
    public int addSecurityInsurance(SecurityInsurance securityInsurance){return dao.addSecurityInsurance(securityInsurance);}
    public int updateSecurityInsurance(SecurityInsurance securityInsurance){return dao.updateSecurityInsurance(securityInsurance);}
    public int deleteSecurityInsurance(int securityInsuranceId){return dao.deleteSecurityInsurance(securityInsuranceId);}
    public SecurityInsurance queryOne(int securityInsuranceId){return dao.queryOne(securityInsuranceId);}
}
