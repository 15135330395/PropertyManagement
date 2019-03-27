package com.logistics.service;

import com.entity.PageBean;
import com.logistics.dao.GuardRotaDao;
import com.logistics.dao.impl.GuardRotaDaoImpl;
import com.logistics.entity.GuardRota;

import java.util.Date;
import java.util.List;

/**
 * @Description GuardRotaService
 * @Author WYR
 * @CreateTime 2019-03-26 23:52
 */
public class GuardRotaService {
    private GuardRotaDao dao = new GuardRotaDaoImpl();

    public List<GuardRota> getAllRota() {
        return dao.getAllRota();
    }

    public List<GuardRota> getAllRotaByPage(PageBean pageBean) {
        return dao.getAllRotaByPage(pageBean);
    }

    public GuardRota findRotaByRotaId(int rotaId) {
        return dao.findRotaByRotaId(rotaId);
    }

    public List<GuardRota> findRotaByStaffId(int staffId) {
        return dao.findRotaByStaffId(staffId);
    }

    public int addRota(GuardRota guardRota) {
        return dao.addRota(guardRota);
    }

    public int updateRota(GuardRota guardRota) {
        return dao.updateRota(guardRota);
    }

    public int deleteRota(int rotaId) {
        return dao.deleteRota(rotaId);
    }

    public int clockIn(int rotaId, Date clockInTime) {
        return dao.clockIn(rotaId, clockInTime);
    }

    public int clockOut(int rotaId, Date clockOutTime) {
        return dao.clockIn(rotaId, clockOutTime);
    }
}
