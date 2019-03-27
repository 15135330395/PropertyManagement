package com.equipment.dao;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ContractDao
 */

import com.equipment.entity.Contract;

import java.util.List;

public interface ContractDao {

    public List<Contract> findAll();

    public int addContract(Contract contract);

    public int updateContract(Contract contract);

    public int deleteContract(int contractId);
}
