package com.equipment.dao.daoImpl;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ReportDaoImpl
 */

import com.equipment.dao.ReportDao;
import com.equipment.entity.Report;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {

 QueryRunner qr=new QueryRunner();
    @Override
    public List<Report> findAll() {
       String sql="select * from report ";
        List<Report> list = new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Report>(Report.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int addReport(Report report) {
       String sql="insert into report (report_title,report_date,reporting_unit,report_content," +
               "report_cost,report_name,report_phone,instructions,executive_result) values (?,?,?,?,?,?,?,?,?)";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, report.getReportTitle(), report.getReportDate(), report.getReportingUnit(), report.getReportContent(),
                    report.getReportCost(), report.getReportName(), report.getReportPhone(), report.getInstructions(), report.getExecutiveResult());
        return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateReportByReportId(Report report) {
        String sql="update report set (report_title=? , report_date=? , reporting_unit=? , report_content=? , report_cost=? , " +
                "report_name=? , report_phone=? , instructions=? ,executive_result=?) where report_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, report.getReportTitle(), report.getReportDate(), report.getReportingUnit(), report.getReportContent(),
                    report.getReportCost(), report.getReportName(), report.getReportPhone(), report.getInstructions(), report.getExecutiveResult(), report.getReportId());
        return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    @Override
    public int deleteReportByReportId(int reportId) {
        String sql="delete from report where report_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, reportId);
       return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
