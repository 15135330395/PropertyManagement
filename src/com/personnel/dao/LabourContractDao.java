package com.personnel.dao;

import com.entity.PageBean;
import com.personnel.entity.LabourContract;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public interface LabourContractDao {
    public List<LabourContract> findAll();
    public List<LabourContract> queryPage(PageBean pageBean);
    public int addLabourContract(LabourContract labourContract);
    public int updateLabourContract(LabourContract labourContract);
    public int deleteLabourContract(int labourContractId);
    public LabourContract queryOne(int labourContractId);
}
