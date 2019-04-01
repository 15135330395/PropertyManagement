package com.equipment.service;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ContractService
 */

import com.entity.PageBean;
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

    public int deleteContract(int id){
        return dao.deleteContract(id);
    }

    public List<Contract> queryPage(PageBean pageBean){
        return dao.queryPage(pageBean);
    }

    public Contract findContractById(int id){
        return dao.findContractById(id);
    }

}
