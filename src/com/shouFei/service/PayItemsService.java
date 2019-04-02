package com.shouFei.service;

import com.shouFei.dao.PayItemsDao;
import com.shouFei.dao.daoImpl.PayItemsDaoImpl;
import com.entity.PageBean;
import com.shouFei.entity.PayItems;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public class PayItemsService {
    private PayItemsDao pIdao=new PayItemsDaoImpl();

    public List<PayItems> findAll(){
        return pIdao.findAll();
    }

    public int addPayItems(PayItems payItems){
        return pIdao.addPayItems(payItems);
    }

    public int deletePayItems(int id){
        return pIdao.deletePayItems(id);
    }

    public int updatePayItems(PayItems payItems){
        return pIdao.updatePayItems(payItems);
    }

    public List<PayItems> queryByPage(PageBean pageBean){
        return pIdao.queryByPage(pageBean);
    }

    public PayItems findPayItemsById(int id){
        return  pIdao.findPayItemsById(id);
    }
}
