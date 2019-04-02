package com.shouFei.service;

import com.shouFei.dao.PayNormDao;
import com.shouFei.dao.daoImpl.PayNormDaoImpl;
import com.entity.PageBean;
import shouFei.entity.PayNorm;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/27;
 */
public class PayNormService {
    private PayNormDao pNdao = new PayNormDaoImpl();

    public List<PayNorm> findAll() {
        return pNdao.findAll();
    }
    //public List<PayNorm> findByPayId(){return pNdao.findByPayId();}

    public int addPayNorm(PayNorm payNorm) {
        return pNdao.addPayNorm(payNorm);
    }

    public int deletePayNorm(int NormId) {
        return pNdao.deletePayNorm(NormId);
    }

    public int updatePayNorm(PayNorm payNorm) {
        return pNdao.updatePayNorm(payNorm);
    }

    public List<PayNorm> queryByPage(PageBean pageBean) {
        return pNdao.queryByPage(pageBean);
    }

    public PayNorm findPayNormById(int NormId) {
        return pNdao.findPayNormById(NormId);
    }
    public List<PayNorm> queryOne(String name){
        return pNdao.queryOne(name);
    }




}
