package com.equipment.service;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ContractService
 */

import com.equipment.dao.ContractDao;
import com.equipment.dao.daoImpl.ContractDaoImpl;
import com.equipment.entity.Contract;

import java.util.List;

public class ContractService {
    ContractDao dao=new ContractDaoImpl();


    public List<Contract> findAll(){

        return dao.findAll();
    }

    public int addContract(Contract contract){
        return dao.addContract(contract);
    }

    public int updateContract(Contract contract){
        return dao.updateContract(contract);
    }

    public int deleteContract(int contractId){
        return dao.deleteContract(contractId);
    }
}
