package shouFei.dao;

import shouFei.entity.PayNorm;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
public interface PayNormDao {
    public List<PayNorm> findAll();

    public int addPayNorm(PayNorm payNorm);

    public int deletePayNorm(int id);

    public int updatePayNorm(PayNorm payNorm);

    public int findPayNormCountById(int id);

}