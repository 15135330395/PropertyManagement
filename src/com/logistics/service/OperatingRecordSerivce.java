package com.logistics.service;

import com.entity.PageBean;
import com.logistics.dao.OperatingRecordDao;
import com.logistics.dao.impl.OperatingRecordDaoImpl;
import com.logistics.entity.GuardRota;
import com.logistics.entity.OperatingRecord;

import java.util.Date;
import java.util.List;

/**
 * @Description OperatingRecordSerivce
 * @Author WYR
 * @CreateTime 2019-03-26 23:55
 */
public class OperatingRecordSerivce {
    private OperatingRecordDao dao = new OperatingRecordDaoImpl();

    public OperatingRecord findRecordByRecordId(int recordId) {
        return dao.findRecordByRecordId(recordId);
    }

    public List<OperatingRecord> findRecordByStaffId(int staffId) {
        return dao.findRecordByStaffId(staffId);
    }

    public List<OperatingRecord> findAllRecord() {
        return dao.findAllRecord();
    }

    public List<OperatingRecord> findAllRecordByPage(PageBean pageBean) {
        return dao.findAllRecordByPage(pageBean);
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

    public int deleteRecords(int... recordIds) {
        int sum = 0;
        for (int i = 0; i < recordIds.length; i++) {
            sum += dao.deleteRecord(recordIds[i]);
        }
        return sum;
    }

    public int returnEquipment(int recordId, Date returnTime) {
        return dao.returnEquipment(recordId, returnTime);
    }
}
