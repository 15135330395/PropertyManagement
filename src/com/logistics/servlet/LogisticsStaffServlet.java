package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.entity.Staff;
import com.logistics.entity.GuardRota;
import com.logistics.service.LogisticsStaffService;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description LogisticsStaffServlet
 * @Author WYR
 * @CreateTime 2019-03-30 18:48
 */
@WebServlet(name = "LogisticsStaffServlet", urlPatterns = "/LogisticsStaffServlet")
public class LogisticsStaffServlet extends HttpServlet {
    private LogisticsStaffService service = new LogisticsStaffService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllLogisticsStaffByPage".equals(action)) {
            getAllLogisticsStaffByPage(request, response);
        } else if ("findStaffById".equals(action)) {
            findStaffById(request, response);
        } else if ("editStaff".equals(action)) {
            editStaff(request, response);
        } else if ("updateStaff".equals(action)) {
            updateStaff(request, response);
        }
    }

    private void getAllLogisticsStaffByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        // 页码
        String pageIndex = request.getParameter("page");
        if (pageIndex != null) {
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 每页条数
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        // 总条数
        int rotaCount = service.getAllLogisticsStaff().size();
        pageBean.setCount(rotaCount);
        List<Staff> staffList = service.getAllLogisticsStaffByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(staffList, pageBean);
        response.getWriter().print(table);
    }

    private void findStaffById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        Staff staff = service.findLogisticsStaffById(Integer.parseInt(staffId));
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("/logistics/Manager/LogisticsStaffById.jsp").forward(request, response);
    }

    private void editStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        Staff staff = service.findLogisticsStaffById(Integer.parseInt(staffId));
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("/logistics/Manager/EditLogisticsStaff.jsp").forward(request, response);
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        String age = request.getParameter("age");
        Staff staff = new Staff(Integer.parseInt(staffId),staffName,Integer.parseInt(age));
        int i = service.updateLogisticsStaff(staff);
        response.getWriter().print(i);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
