package shouFei.dao;

import shouFei.entity.PageBean;
import shouFei.entity.Pay;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
public interface PayDao {
    public List<Pay> findAll();
    public List<Pay> queryByPage(PageBean pageBean);
    public int deletePay(int id);
    public int updatePay(Pay pay);
    public Pay findPayById(int id);
    public int addPay(Pay pay);
}
