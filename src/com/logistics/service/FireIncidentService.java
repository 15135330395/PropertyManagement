package com.logistics.service;

import com.entity.PageBean;
import com.logistics.dao.FireIncidentDao;
import com.logistics.dao.impl.FireIncidentDaoImpl;
import com.logistics.entity.FireIncident;

import java.util.List;

/**
 * @Description FireIncidentService
 * @Author WYR
 * @CreateTime 2019-03-26 23:49
 */
public class FireIncidentService {
    private FireIncidentDao dao = new FireIncidentDaoImpl();

    public List<FireIncident> getAllIncident() {
        return dao.getAllIncident();
    }

    public List<FireIncident> getAllIncidentByPage(PageBean pageBean) {
        return dao.getAllIncidentByPage(pageBean);
    }

    public FireIncident findIncidentById(int incidentId) {
        return dao.findIncidentById(incidentId);
    }

    public int addIncident(FireIncident fireIncident) {
        return dao.addIncident(fireIncident);
    }

    public int updateIncident(FireIncident fireIncident) {
        return dao.updateIncident(fireIncident);
    }

    public int deleteIncident(int incidentId) {
        return dao.deleteIncident(incidentId);
    }
}
