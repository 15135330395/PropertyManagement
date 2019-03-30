package com.personnel.service;

import com.entity.PageBean;
import com.personnel.dao.LabourContractDao;
import com.personnel.dao.impl.LabourContractDaoImpl;
import com.personnel.entity.LabourContract;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
public class LabourContractService {
    private LabourContractDao dao=new LabourContractDaoImpl();
    public List<LabourContract> findAll(){return dao.findAll();}
    public List<LabourContract> queryPage(PageBean pageBean){return dao.queryPage(pageBean);}
    public int addLabourContract(LabourContract labourContract){return dao.addLabourContract(labourContract);}
    public int updateLabourContract(LabourContract labourContract){return dao.updateLabourContract(labourContract);}
    public int deleteLabourContract(int labourContractId){return dao.deleteLabourContract(labourContractId);}
    public LabourContract queryOne(int labourContractId){return dao.queryOne(labourContractId);}
}
