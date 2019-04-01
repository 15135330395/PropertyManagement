package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.entity.Kpi;
import com.personnel.entity.LabourContract;
import com.personnel.service.KpiService;
import com.personnel.service.StaffService;
import com.utils.DateUtil;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/30
 */
@WebServlet(name = "KpiServlet",urlPatterns = "/KpiServlet")
public class KpiServlet extends HttpServlet {
    private KpiService service=new KpiService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("queryPage".equals(action)) {
            queryPage(request, response);
        } else if ("add".equals(action)) {
            add(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        } else if ("queryOne".equals(action)) {
            queryOne(request, response);
        }else if ("addEvaluateGrade".equals(action)) {
            addEvaluateGrade(request, response);
        }else if ("toaddEvaluateGrade".equals(action)) {
            toaddEvaluateGrade(request, response);
        }else if ("toEidt".equals(action)) {
            toEidt(request, response);
        }else if ("queryDetail".equals(action)) {
            queryDetail(request, response);
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void toaddEvaluateGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kpiId = request.getParameter("kpiId");
        Kpi kpi = service.queryOne(Integer.parseInt(kpiId));
        request.setAttribute("kpi", kpi);
        request.getRequestDispatcher("/personnel/background/kpi/addEvaluateGrade.jsp").forward(request, response);

    }
    private void addEvaluateGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kpiId = request.getParameter("kpiId");
        String evaluateGrade = request.getParameter("evaluateGrade");
        int i = service.addEvaluateGrade(Integer.parseInt(kpiId), Integer.parseInt(evaluateGrade));
        response.getWriter().print(i);
    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] array = ids.split(",");
        int sum=0;
        for (String labourContractId: array) {
            int i = service.deleteKpi(Integer.parseInt(labourContractId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String staffId = request.getParameter("staffId");

        String evaluateContent = request.getParameter("evaluateContent");
        String evaluatePerson = request.getParameter("evaluatePerson");
        Kpi kpi = new Kpi(Integer.parseInt(staffId),
                evaluateContent,evaluatePerson);

        int i = service.addKpi(kpi);

        response.getWriter().print(i);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kpiId = request.getParameter("kpiId");
        String staffId = request.getParameter("staffId");


        String evaluateContent = request.getParameter("evaluateContent");
        String evaluatePerson = request.getParameter("evaluatePerson");
        Kpi kpi = new Kpi(Integer.parseInt(kpiId),Integer.parseInt(staffId),
               evaluateContent,evaluatePerson);

        int i = service.updateKpi(kpi);

        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kpiId = request.getParameter("kpiId");
        if (kpiId != null) {
            Kpi kpi = service.queryOne(Integer.parseInt(kpiId));
            request.setAttribute("kpi", kpi);
        }
        StaffService staffService=new StaffService();
        List<Staff> staffList = staffService.findAll();
        request.setAttribute("staffList",staffList);
        request.getRequestDispatcher("/personnel/background/kpi/kpiAdd.jsp").forward(request, response);
    }
    protected void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        if (staffId != null) {
            Kpi kpi = service.queryOneByStaffId(Integer.parseInt(staffId));
            request.setAttribute("kpi", kpi);
        }
        StaffService staffService=new StaffService();
        List<Staff> staffList = staffService.findAll();
        request.setAttribute("staffList",staffList);
        request.getRequestDispatcher("/personnel/background/kpi/kpiDetail.jsp").forward(request, response);
    }
    protected void toEidt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kpiId = request.getParameter("kpiId");
        if (kpiId != null) {
            Kpi kpi = service.queryOne(Integer.parseInt(kpiId));
            request.setAttribute("kpi", kpi);
        }
        StaffService staffService=new StaffService();
        List<Staff> staffList = staffService.findAll();
        request.setAttribute("staffList",staffList);
        request.getRequestDispatcher("/personnel/background/kpi/kpiEdit.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kpiId = request.getParameter("kpiId");
        int i = service.deleteKpi(Integer.parseInt(kpiId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<Kpi> kpiList = service.queryPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(kpiList, pageBean);
        response.getWriter().print(jsonObject);
    }
}
