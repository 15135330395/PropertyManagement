package com.shouFei.dao;

import com.entity.PageBean;
import com.shouFei.entity.PayNorm;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public interface PayNormDao {
    public List<PayNorm> findAll();

    public int addPayNorm(PayNorm payNorm);

    public int deletePayNorm(int NormId);

    public int updatePayNorm(PayNorm payNorm);

    public PayNorm findPayNormById(int NormId);

    public List<PayNorm> queryByPage(PageBean pageBean);

    public int findPayNormCountById(int normId);

    public List<PayNorm> queryOne(String payName);

}
