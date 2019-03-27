package com.equipment.service;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ReportService
 */

import com.equipment.dao.ReportDao;
import com.equipment.dao.daoImpl.ReportDaoImpl;
import com.equipment.entity.Report;

import java.util.List;

public class ReportService {
    ReportDao dao=new ReportDaoImpl();

    public List<Report> findAll(){
        return dao.findAll();
    }

    public int addReport(Report report){
      return dao.addReport(report);
    }

    public int updateReportByReportId(Report report){
        return dao.updateReportByReportId(report);
    }

    public int deleteReportByReportId(int reportId){
        return dao.deleteReportByReportId(reportId);
    }


}
