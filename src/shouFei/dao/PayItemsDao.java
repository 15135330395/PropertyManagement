package shouFei.dao;

import shouFei.entity.PageBean;
import shouFei.entity.PayItems;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public interface PayItemsDao {
    public List<PayItems> findAll();

    public int addPayItems(PayItems payItems);

    public int deletePayItems(int id);

    public int updatePayItems(PayItems payItems);

    public List<PayItems> queryByPage(PageBean pageBean);
    public PayItems findPayItemsById(int id);
}
