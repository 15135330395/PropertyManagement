package shouFei.service;

import shouFei.dao.MeterReadingDao;
import shouFei.dao.daoImpl.MeterReadingDaoImpl;
import shouFei.entity.MeterReading;
import shouFei.entity.PageBean;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/29;
 */
public class MeterReadingService {
    private MeterReadingDao dao = new MeterReadingDaoImpl();

    public List<MeterReading> findAll() {
        return dao.findAll();
    }

    public List<MeterReading> queryByPage(PageBean pageBean) {
        return dao.queryByPage(pageBean);
    }

    public int deleteMeterReading(int id) {

        return dao.deleteMeterReading(id);
    }

    public int updateMeterReading(MeterReading meterReading) {
        return dao.updateMeterReading(meterReading);
    }

    public MeterReading findMeterReadingById(int id) {
        return dao.findMeterReadingById(id);
    }
}
