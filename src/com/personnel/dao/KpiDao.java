package com.personnel.dao;

import com.entity.PageBean;
import com.personnel.entity.Kpi;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public interface KpiDao {
    public List<Kpi> findAll();
    public List<Kpi> queryPage(PageBean pageBean);
    public int addKpi(Kpi kpi);
    public int updateKpi(Kpi kpi);
    public int deleteKpi(int kpiId);
    public Kpi queryOne(int kpiId);

    public int addEvaluateGrade(int kpiId, int evaluateGrade);

    Kpi queryOneByStaffId(int staffId);
}
