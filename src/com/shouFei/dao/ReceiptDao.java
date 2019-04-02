package com.shouFei.dao;

import com.entity.PageBean;
import shouFei.entity.Receipt;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
public interface ReceiptDao {
    public List<Receipt> findAll();
    public List<Receipt> queryByPage(PageBean pageBean);
    public int deleteReceipt(int id);
    public int updateReceipt(Receipt receipt);
    public Receipt findReceiptById(int id);
    public int addReceipt(Receipt receipt);
}
