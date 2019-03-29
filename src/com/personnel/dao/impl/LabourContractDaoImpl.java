package com.personnel.dao.impl;

import com.entity.PageBean;
import com.personnel.dao.LabourContractDao;
import com.personnel.entity.LabourContract;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public class LabourContractDaoImpl implements LabourContractDao {
    @Override
    public List<LabourContract> findAll() {
        return null;
    }

    @Override
    public List<LabourContract> queryPage(PageBean pageBean) {
        return null;
    }

    @Override
    public int addLabourContract(LabourContract labourContract) {
        return 0;
    }

    @Override
    public int updateLabourContract(LabourContract labourContract) {
        return 0;
    }

    @Override
    public int deleteLabourContract(int labourContractId) {
        return 0;
    }

    @Override
    public LabourContract queryOne(int labourContractId) {
        return null;
    }
}
