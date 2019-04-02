package com.equipment.dao.daoImpl;/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ReportDaoImpl
 */

import com.entity.PageBean;
import com.equipment.dao.ReportDao;
import com.equipment.entity.Report;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Report.class));
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
        String sql="update report set report_title=? , report_date=? , reporting_unit=? , report_content=? , report_cost=? , " +
                " report_name=? , report_phone=? , instructions=? , executive_result=? where report_id=? ";
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
@Override

public List<Report> queryPage(PageBean pageBean) {
    String sql = "select * from report order by report_date desc limit ?,?";
    List<Report> list=new ArrayList<>();
    try {
        list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Report.class),pageBean.getIndex(),pageBean.getPageCount());

    } catch (SQLException e) {
        e.printStackTrace();
    }return list;
}

/*    @Override
    public List<Report> queryPage(PageBean pageBean){
        String sql="select * from report order by report_date desc limit ?,?";
        List<Report> list=new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
       PreparedStatement ps=null;
       ResultSet rs=null;
        try {
             ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            ps.executeQuery();  //在预处理语句后面，执行顺序
            rs = ps.executeQuery();
            while(rs.next()){
                Report report=new Report();
                report.setReport_id(rs.getInt("report_id"));
                report.setReport_title(rs.getString("report_title"));
                report.setReport_date(rs.getDate("report_date"));
                report.setReporting_unit(rs.getString("reporting_unit"));
                report.setReport_content(rs.getString ("report_content"));
                report.setReport_cost(rs.getDouble("report_cost"));
                report.setReport_name(rs.getString("report_name"));
                report.setReport_phone(rs.getInt("report_phone"));
                report.setInstructions(rs.getString("instructions"));
                report.setExecutive_result(rs.getString("executive_result"));
                System.out.println(report.getReportDate());
                list.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs!=null){ rs.close();}
                if(ps!=null){ps.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return list;
    }*/
    @Override
    public Report findReportById(int reportId) {
        String sql="select * from report where report_id= ? ";
        Report report=new Report();
        try {
              report = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Report.class), reportId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }

   /* public static void main(String[] args) {
        new ReportDaoImpl().findReportById(1);
    }*/
}
