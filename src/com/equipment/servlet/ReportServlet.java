package com.equipment.servlet;

import com.equipment.entity.Report;
import com.equipment.service.ReportService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ${NAME}
 */
@WebServlet(name = "ReportServlet",urlPatterns = "/ReportServlet")
public class ReportServlet extends HttpServlet {
  ReportService reportService=new ReportService();

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.sendRedirect("text/html;charset=utf-8");

        String action = request.getParameter("action");
        if("query".equals(action)){
            query(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }


    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
doPost(request,response);
    }

    protected void query(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Report> reportList = reportService.findAll();
        request.setAttribute("reportList",reportList);
        request.getRequestDispatcher("report查询页面").forward(request,response);

    }

    protected void add(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    protected void update(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    protected void delete(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String reportId = request.getParameter("reportId");
        int i = reportService.deleteReportByReportId(Integer.parseInt(reportId));
        response.getWriter().print(i);
    }
}
