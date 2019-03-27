package com.equipment.dao;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ReportDao
 */

import com.equipment.entity.Report;

import java.util.List;

public interface ReportDao {

   public List<Report> findAll();

   public int addReport(Report report);

   public int updateReportByReportId(Report report);


   public int deleteReportByReportId(int reportId);



}
