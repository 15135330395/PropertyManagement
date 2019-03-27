package com.logistics.dao;

import com.entity.PageBean;
import com.logistics.entity.OperatingRecord;

import java.util.Date;
import java.util.List;

/**
 * @Description OperatingRecordDao
 * @Author WYR
 * @CreateTime 2019-03-26 22:52
 */
public interface OperatingRecordDao {
    /**
     * 通过记录ID查找
     *
     * @param recordId
     * @return
     */
    OperatingRecord findRecordByRecordId(int recordId);

    /**
     * 通过员工ID查找
     *
     * @param staffId
     * @return
     */
    List<OperatingRecord> findRecordByStaffId(int staffId);

    /**
     * 查询所有的使用记录
     *
     * @return
     */
    List<OperatingRecord> findAllRecord();

    /**
     * 查询所有使用记录的分页
     *
     * @param pageBean
     * @return
     */
    List<OperatingRecord> findAllRecordByPage(PageBean pageBean);

    /**
     * 添加使用记录
     *
     * @param operatingRecord
     * @return
     */
    int addRecord(OperatingRecord operatingRecord);

    /**
     * 修改使用记录
     *
     * @param operatingRecord
     * @return
     */
    int updateRecord(OperatingRecord operatingRecord);

    /**
     * 删除使用记录
     *
     * @param recordId
     * @return
     */
    int deleteRecord(int recordId);

    /**
     * 添加归还器材时间
     *
     * @param recordId
     * @param returnTime
     * @return
     */
    int returnEquipment(int recordId, Date returnTime);

}
