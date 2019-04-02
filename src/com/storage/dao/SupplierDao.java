package com.storage.dao;



import com.storage.entity.Supplier;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/26
 * Time: 15:15
 * Description: No Description
 */
public interface SupplierDao {
    List<Supplier> findAll();
    int update(Supplier supplier);
    Supplier findOne(String supplierName);
    int deleteById(int id);
    int add(Supplier supplier);
}
