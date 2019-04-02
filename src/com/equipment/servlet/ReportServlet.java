package com.equipment.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.equipment.entity.Report;
import com.equipment.service.ReportService;
import com.utils.DateUtil;
import com.utils.JsonUtil;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ${NAME}
 */
@WebServlet(name = "ReportServlet",urlPatterns = "/ReportServlet",initParams ={@WebInitParam(name="pageCount",value="10") })
public class ReportServlet extends HttpServlet {
  ReportService reportService=new ReportService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
//        System.out.println("ReportServlet..."+action);
        if("query".equals(action)){
            query(request,response);
        }else if("add".equals(action)){
            System.out.println("ReportServlet..."+action);
            add(request,response);
        }else if("update".equals(action)){
//            System.out.println("action="+action);
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("queryPage".equals(action)){
            queryPage(request,response);
        }else if("queryOneBack".equals(action)){
            queryOneBack(request,response);
        }else if("toAdd".equals(action)){
            toAdd(request,response);
        }else if("deleteAll".equals(action)){
             deleteAll(request,response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("method=query");
        List<Report> reportList = reportService.findAll();
        request.setAttribute("reportList",reportList);
        request.getRequestDispatcher("前台查询页面").forward(request,response);

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reportId = request.getParameter("reportId");
        String reportTitle = request.getParameter("reportTitle");
        String reportDate = request.getParameter("reportDate");
        System.out.println("add...reportDate="+reportDate);
        String reportingUnit = request.getParameter("reportingUnit");
        String reportCost =  request.getParameter("reportCost");
        String reportName = request.getParameter("reportName");
        String reportPhone = request.getParameter("reportPhone");
        String instructions = request.getParameter("instructions");
        String executiveResult = request.getParameter("executiveResult");
        String reportContent = request.getParameter("reportContent");
        System.out.println("......."+reportId);
        Report report=new Report(reportTitle,DateUtil.formatString(reportDate,"yyyy-MM-dd HH:mm:ss") ,reportingUnit,
                reportContent, Double.parseDouble(reportCost),reportName,reportPhone,instructions,executiveResult);
        System.out.println(report);
        int i = reportService.addReport(report);

        response.getWriter().print(i);

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportId = request.getParameter("reportId");
        String reportTitle = request.getParameter("reportTitle");
        String reportDate = request.getParameter("reportDate");
        System.out.println("update...reportDate="+reportDate);
        String reportingUnit = request.getParameter("reportingUnit");
       String reportCost =  request.getParameter("reportCost");
        String reportName = request.getParameter("reportName");
        String reportPhone = request.getParameter("reportPhone");
        String instructions = request.getParameter("instructions");
        String executiveResult = request.getParameter("executiveResult");
        String reportContent = request.getParameter("reportContent");
        Report report=new Report(Integer.parseInt(reportId),reportTitle,DateUtil.formatString(reportDate,"yyyy-MM-dd HH:mm:ss") ,reportingUnit,
                reportContent, Double.parseDouble(reportCost),reportName, reportPhone , instructions,executiveResult);
        System.out.println("report="+report);
        int i = reportService.updateReportByReportId(report);
        System.out.println("i...."+i);
        response.getWriter().print(i);

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reportId = request.getParameter("reportId");
        int i = reportService.deleteReportByReportId(Integer.parseInt(reportId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("page");
        PageBean pageBean=new PageBean();
        if(!StringUtil.isEmpty(pageIndex)){
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setCount(reportService.findAll().size());
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));

        List<Report> reportList = reportService.queryPage(pageBean);
        System.out.println(reportList.get(0).getReportDate());

        JSONObject jsonObject= JsonUtil.getJsonObject(reportList,pageBean);
       /* System.out.println(jsonObject);*/
        response.getWriter().print(jsonObject);
    }

    protected void queryOneBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportId = request.getParameter("reportId");
        System.out.println("reportId="+reportId);

        Report report  = reportService.findReportById(Integer.parseInt(reportId));

        System.out.println("queryOneBack..."+report);
        request.setAttribute("report",report);
        request.getRequestDispatcher("/equbackground/report/reportUpdate.jsp").forward(request,response);

    }

    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("/equbackground/report/reportAdd.jsp").forward(request,response);

    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] idArr = ids.split(",");
        int sum=0;
        for(String reportId : idArr){
            int i = reportService.deleteReportByReportId(Integer.parseInt(reportId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }
}
