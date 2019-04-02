package com.storage.service;


import com.storage.dao.SupplierDao;
import com.storage.dao.daoImpl.SupplierDaoImpl;
import com.storage.entity.Supplier;

import java.util.List;

/**
 * author wzh
 * Created on 2019/3/26
 */
public class SupplierService {
    SupplierDao supplierDao=new SupplierDaoImpl();

    public List<Supplier> findAll(){
        return supplierDao.findAll();
    }
    public Supplier findOne(String supplierName){
        return  supplierDao.findOne(supplierName);
    }
    public int deleteById(int id){
        return supplierDao.deleteById(id);
    }
    public int add(Supplier supplier){
        return supplierDao.add(supplier);
    }
    public int update(Supplier supplier){
        return supplierDao.update(supplier);
    }
}
