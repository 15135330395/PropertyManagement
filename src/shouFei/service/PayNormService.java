package shouFei.service;

import shouFei.dao.PayNormDao;
import shouFei.dao.daoImpl.PayNormDaoImpl;
import shouFei.entity.PayNorm;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/27;
 */
public class PayNormService {
    private PayNormDao pNdao=new PayNormDaoImpl();
    public List<PayNorm> findAll(){
        return pNdao.findAll();
    }

    public int addPayNorm(PayNorm payNorm){
        return pNdao.addPayNorm(payNorm);
    }

    public int deletePayNorm(int id){
        return pNdao.deletePayNorm(id);
    }

    public int updatePayNorm(PayNorm payNorm){
        return pNdao.updatePayNorm(payNorm);
    }

    public int findPayNormCountById(int id){
        return pNdao.findPayNormCountById(id);
    }
}
