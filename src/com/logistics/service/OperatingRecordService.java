package com.logistics.service;

import com.entity.PageBean;
import com.logistics.dao.OperatingRecordDao;
import com.logistics.dao.impl.OperatingRecordDaoImpl;
import com.logistics.entity.OperatingRecord;

import java.util.Date;
import java.util.List;

/**
 * @Description OperatingRecordSerivce
 * @Author WYR
 * @CreateTime 2019-03-26 23:55
 */
public class OperatingRecordService {
    private OperatingRecordDao dao = new OperatingRecordDaoImpl();

    public List<OperatingRecord> getAllRecord() {
        return dao.getAllRecord();
    }

    public List<OperatingRecord> getAllRecordByPage(PageBean pageBean) {
        return dao.getAllRecordByPage(pageBean);
    }

    public OperatingRecord findRecordById(int recordId) {
        return dao.findRecordById(recordId);
    }

    public int addRecord(OperatingRecord operatingRecord) {
        return dao.addRecord(operatingRecord);
    }

    public int updateRecord(OperatingRecord operatingRecord) {
        return dao.updateRecord(operatingRecord);
    }

    public int deleteRecord(int recordId) {
        return dao.deleteRecord(recordId);
    }

    public int returnEquipment(int recordId, Date returnTime) {
        return dao.returnEquipment(recordId, returnTime);
    }
}
