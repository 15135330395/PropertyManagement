package com.shouFei.service;

import com.shouFei.dao.PayDao;
import com.shouFei.dao.daoImpl.PayDaoImpl;
import com.entity.PageBean;
import com.shouFei.entity.Pay;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
public class PayService {
    PayDao dao=new PayDaoImpl();
    public List<Pay> findAll(){
        return dao.findAll();
    }
    public List<Pay> queryByPage(PageBean pageBean){
        return dao.queryByPage(pageBean);
    }
    public int deletePay(int id){
        return dao.deletePay(id);
    }
    public int updatePay(Pay pay){
        return dao.updatePay(pay);
    }
    public Pay findPayById(int id){
        return dao.findPayById(id);
    }
    public int addPay(Pay pay){return dao.addPay(pay);}
}
