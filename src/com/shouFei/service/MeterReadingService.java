package com.shouFei.service;

import com.shouFei.dao.MeterReadingDao;
import com.shouFei.dao.daoImpl.MeterReadingDaoImpl;

import com.entity.PageBean;
import com.shouFei.entity.MeterReading;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/29;
 */
public class MeterReadingService {
    MeterReadingDao dao=new MeterReadingDaoImpl();

    public List<MeterReading> findAll(){
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

    public int addMeterReading(MeterReading meterReading) {

        return dao.addMeterReading(meterReading);
    }
}
