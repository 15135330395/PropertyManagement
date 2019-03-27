package com.logistics.dao;

import com.entity.PageBean;
import com.logistics.entity.FireIncident;

import java.util.List;

/**
 * @Description FireIncidentDao
 * @Author WYR
 * @CreateTime 2019-03-26 22:41
 */
public interface FireIncidentDao {
    /**
     * 查询所有的事故
     *
     * @return
     */
    List<FireIncident> getAllIncident();

    /**
     * 查询所有事故的分页
     *
     * @param pageBean
     * @return
     */
    List<FireIncident> getAllIncidentByPage(PageBean pageBean);

    /**
     * 通过事故ID查找
     *
     * @param incidentId
     * @return
     */
    FireIncident findIncidentById(int incidentId);

    /**
     * 添加事故
     *
     * @param fireIncident
     * @return
     */
    int addIncident(FireIncident fireIncident);

    /**
     * 修改事故
     *
     * @param fireIncident
     * @return
     */
    int updateIncident(FireIncident fireIncident);

    /**
     * 删除事故
     *
     * @param incidentId
     * @return
     */
    int deleteIncident(int incidentId);
}
