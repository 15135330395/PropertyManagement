package com.shouFei.service;

import com.shouFei.dao.ReceiptDao;
import com.shouFei.dao.daoImpl.ReceiptDaoImpl;
import com.entity.PageBean;
import shouFei.entity.Receipt;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
public class ReceiptService {
    ReceiptDao dao=new ReceiptDaoImpl();
    public List<Receipt> findAll(){
        return dao.findAll();
    }
    public List<Receipt> queryByPage(PageBean pageBean){
        return dao.queryByPage(pageBean);
    }
    public int deleteReceipt(int id){
        return dao.deleteReceipt(id);
    }
    public int updateReceipt(Receipt receipt){
        return dao.updateReceipt(receipt);
    }
    public Receipt findReceiptById(int id){
        return dao.findReceiptById(id);
    }
    public int addReceipt(Receipt receipt){
        return dao.addReceipt(receipt);
    }
}
