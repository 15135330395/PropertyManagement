package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.Department;
import com.entity.PageBean;
import com.entity.Staff;
import com.manager.dao.DepartmentDao;
import com.manager.dao.daoimpl.DepartmentDaoImpl;
import com.personnel.entity.Attendance;
import com.personnel.service.AttendanceService;
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
@WebServlet(name = "AttendanceServlet",urlPatterns = "/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
    private AttendanceService service=new AttendanceService();
    private StaffService staffService=new StaffService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("deleteAll".equals(action)) {
            deleteAll(request, response);
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
        for (String attendanceId: array) {
            int i = service.deleteAttendance(Integer.parseInt(attendanceId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        String departmentId = request.getParameter("departmentId");
        String workDay = request.getParameter("workDay");



        String sickLeave = request.getParameter("sickLeave");
        String affairLeave = request.getParameter("affairLeave");
        String onduty = request.getParameter("onduty");
        String abnormal = request.getParameter("abnormal");



        Attendance attendance = new Attendance(
                Integer.parseInt(staffId),Integer.parseInt(departmentId),
                Integer.parseInt(workDay),
                Integer.parseInt(sickLeave),Integer.parseInt(affairLeave),Integer.parseInt(onduty),
                Integer.parseInt(abnormal)
        );

        int i = service.addAttendance(attendance);

        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attendanceId = request.getParameter("attendanceId");
        String staffId = request.getParameter("staffId");
        String departmentId = request.getParameter("departmentId");
        String workDay = request.getParameter("workDay");



        String sickLeave = request.getParameter("sickLeave");
        String affairLeave = request.getParameter("affairLeave");
        String onduty = request.getParameter("onduty");
        String abnormal = request.getParameter("abnormal");



        Attendance attendance = new Attendance(Integer.parseInt(attendanceId),
                Integer.parseInt(staffId),Integer.parseInt(departmentId),
                Integer.parseInt(workDay),
                Integer.parseInt(sickLeave),Integer.parseInt(affairLeave),Integer.parseInt(onduty),
                Integer.parseInt(abnormal)
                );

        int i = service.updateAttendance(attendance);

        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attendanceId = request.getParameter("attendanceId");
        if (attendanceId != null) {
            Attendance attendance = service.queryOne(Integer.parseInt(attendanceId));
            request.setAttribute("attendance", attendance);
        }
        DepartmentDao dao=new DepartmentDaoImpl();
        List<Department> departmentList = dao.findAll();
        request.setAttribute("departmentList",departmentList);
        List<Staff> staffList = staffService.findAll();
        request.setAttribute("staffList",staffList);
        request.getRequestDispatcher("/personnel/background/attendance/attendanceAdd.jsp").forward(request, response);
    }
    protected void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attendanceId = request.getParameter("attendanceId");
        if (attendanceId != null) {
            Attendance attendance = service.queryOne(Integer.parseInt(attendanceId));
            request.setAttribute("attendance", attendance);
        }
        DepartmentDao dao=new DepartmentDaoImpl();
        List<Department> departmentList = dao.findAll();
        request.setAttribute("departmentList",departmentList);
        List<Staff> staffList = staffService.findAll();
        request.setAttribute("staffList",staffList);
        request.getRequestDispatcher("/personnel/background/attendance/attendanceEdit.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attendanceId = request.getParameter("attendanceId");
        int i = service.deleteAttendance(Integer.parseInt(attendanceId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<Attendance> attendanceList = service.queryPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(attendanceList, pageBean);
        response.getWriter().print(jsonObject);
    }
}
