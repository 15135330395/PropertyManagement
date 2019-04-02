package shouFei.dao;

import shouFei.entity.MeterReading;
import shouFei.entity.PageBean;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/29;
 */
public interface MeterReadingDao {
    public List<MeterReading> findAll();
    public List<MeterReading> queryByPage(PageBean pageBean);
    public int deleteMeterReading(int id);
    public int updateMeterReading(MeterReading meterReading);
    public MeterReading findMeterReadingById(int id);
    public int addMeterReading(MeterReading meterReading);
}
