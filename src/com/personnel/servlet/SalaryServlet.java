package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.Department;
import com.entity.PageBean;
import com.entity.Staff;
import com.manager.dao.DepartmentDao;
import com.manager.dao.daoimpl.DepartmentDaoImpl;
import com.personnel.entity.Attendance;
import com.personnel.entity.Kpi;
import com.personnel.entity.Salary;
import com.personnel.entity.SecurityInsurance;
import com.personnel.service.*;
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
 * @Date: 2019/3/31
 */
@WebServlet(name = "SalaryServlet",urlPatterns = "/SalaryServlet")
public class SalaryServlet extends HttpServlet {
    private SalaryService service=new SalaryService();
    private StaffService staffService=new StaffService();
    private AttendanceService attendanceService=new AttendanceService();
    private KpiService kpiService=new KpiService();
    private SecurityInsuranceService securityInsuranceService=new SecurityInsuranceService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");

        if ("queryDetail".equals(action)) {
            queryDetail(request, response);
        } else if ("add".equals(action)) {
            add(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        } else if ("queryOne".equals(action)) {
            queryOne(request, response);
        } else if ("queryPage".equals(action)) {
            queryPage(request, response);
        }else if ("deleteAll".equals(action)) {
            deleteAll(request, response);
        }else if ("toEdit".equals(action)) {
            toEdit(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] array = ids.split(",");
        int sum=0;
        for (String salaryId: array) {
            int i = service.deleteSalary(Integer.parseInt(salaryId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }

    protected void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        Salary salary = service.queryOneByStaffId(Integer.parseInt(staffId));

        request.setAttribute("salary", salary);
        List<Staff> staffList = staffService.findAll();
        List<Kpi> kpiList = kpiService.findAll();
        List<Attendance> attendanceList = attendanceService.findAll();
        List<SecurityInsurance> securityInsuranceList = securityInsuranceService.findAll();
        request.setAttribute("staffList",staffList);
        request.setAttribute("kpiList",kpiList);
        request.setAttribute("attendanceList",attendanceList);
        request.setAttribute("securityInsuranceList",securityInsuranceList);

        request.getRequestDispatcher("/personnel/background/salary/salaryDetail.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String staffId = request.getParameter("staffId");

        String basicSalary = request.getParameter("basicSalary");
        String attantanceId = request.getParameter("attantanceId");
        String kpiId = request.getParameter("kpiId");

        String securityInsuranceId = request.getParameter("securityInsuranceId");

        Salary salary = new Salary( Integer.parseInt(staffId)
                ,Double.parseDouble(basicSalary),
                Integer.parseInt(attantanceId),
                Integer.parseInt(kpiId),
                Integer.parseInt(securityInsuranceId)
        );

        int i = service.addSalary(salary);

        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String salaryId = request.getParameter("salaryId");
        String staffId = request.getParameter("staffId");

        String basicSalary = request.getParameter("basicSalary");
        String attantanceId = request.getParameter("attantanceId");
        String kpiId = request.getParameter("kpiId");


        String securityInsuranceId = request.getParameter("securityInsuranceId");

        Salary salary = new Salary(Integer.parseInt(salaryId), Integer.parseInt(staffId)
                ,Double.parseDouble(basicSalary),
                Integer.parseInt(attantanceId),
                Integer.parseInt(kpiId),
                Integer.parseInt(securityInsuranceId)
                );

        int i = service.updateSalary(salary);

        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String salaryId = request.getParameter("salaryId");
        if (salaryId != null) {
            Salary salary = service.queryOne(Integer.parseInt(salaryId));
            request.setAttribute("salary", salary);
        }
        List<Staff> staffList = staffService.findAll();
        List<Kpi> kpiList = kpiService.findAll();
        List<Attendance> attendanceList = attendanceService.findAll();
        List<SecurityInsurance> securityInsuranceList = securityInsuranceService.findAll();
        request.setAttribute("staffList",staffList);
        request.setAttribute("kpiList",kpiList);
        request.setAttribute("attendanceList",attendanceList);
        request.setAttribute("securityInsuranceList",securityInsuranceList);
        request.getRequestDispatcher("/personnel/background/salary/salaryAdd.jsp").forward(request, response);
    }
    protected void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String salaryId = request.getParameter("salaryId");
        if (salaryId != null) {
            Salary salary = service.queryOne(Integer.parseInt(salaryId));
            request.setAttribute("salary", salary);
        }
        List<Staff> staffList = staffService.findAll();
        List<Kpi> kpiList = kpiService.findAll();
        List<Attendance> attendanceList = attendanceService.findAll();
        List<SecurityInsurance> securityInsuranceList = securityInsuranceService.findAll();
        request.setAttribute("staffList",staffList);
        request.setAttribute("kpiList",kpiList);
        request.setAttribute("attendanceList",attendanceList);
        request.setAttribute("securityInsuranceList",securityInsuranceList);
        request.getRequestDispatcher("/personnel/background/salary/salaryEdit.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String salaryId = request.getParameter("salaryId");
        int i = service.deleteSalary(Integer.parseInt(salaryId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<Salary> salaryList = service.queryPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(salaryList, pageBean);
        response.getWriter().print(jsonObject);
    }
}
