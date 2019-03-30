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

    public int clockIn(int rotaId) {
        GuardRota rota = dao.findRotaByRotaId(rotaId);
        if (rota.getClockIn() == null) {
            Date clockInTime = new Date();
            int i = dao.clockIn(rotaId, clockInTime);
            return i;
        } else {
            return 2;
        }
    }

    public int clockOut(int rotaId) {
        GuardRota rota = dao.findRotaByRotaId(rotaId);
        if (rota.getClockOut() == null) {
            Date clockOutTime = new Date();
            int i = dao.clockOut(rotaId, clockOutTime);
            return i;
        } else {
            return 2;
        }
    }
}
