package com.personnel.service;

import com.entity.PageBean;
import com.personnel.dao.KpiDao;
import com.personnel.dao.impl.KpiDaoImpl;
import com.personnel.entity.Kpi;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
public class KpiService {
    private KpiDao dao=new KpiDaoImpl();
    public List<Kpi> findAll(){return dao.findAll();}
    public List<Kpi> queryPage(PageBean pageBean){return  dao.queryPage(pageBean); }
    public int addKpi(Kpi kpi){return dao.addKpi(kpi);}
    public int updateKpi(Kpi kpi){return dao.updateKpi(kpi);}
    public int deleteKpi(int kpiId){return dao.deleteKpi(kpiId);}
    public Kpi queryOne(int kpiId){return dao.queryOne(kpiId);}

    public int addEvaluateGrade(int kpiId, int evaluateGrade) {
        return dao.addEvaluateGrade(kpiId,evaluateGrade);
    }

    public Kpi queryOneByStaffId(int staffId) {
        return dao.queryOneByStaffId(staffId);
    }
}
