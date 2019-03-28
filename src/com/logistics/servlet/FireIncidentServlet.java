package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.logistics.entity.FireIncident;
import com.logistics.service.FireIncidentService;
import com.utils.DateUtil;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description FireIncidentServlet
 * @Author WYR
 * @CreateTime 2019-03-27 21:21
 */
@WebServlet(name = "FireIncidentServlet", urlPatterns = "/FireIncidentServlet")
public class FireIncidentServlet extends HttpServlet {
    private FireIncidentService service = new FireIncidentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllIncident".equals(action)) {
            getAllIncident(request, response);
        } else if ("getAllIncidentByPage".equals(action)) {
            getAllIncidentByPage(request, response);
        } else if ("findIncidentById".equals(action)) {
            findIncidentById(request, response);
        } else if ("addIncident".equals(action)) {
            addIncident(request, response);
        } else if ("editIncident".equals(action)) {
            editIncident(request, response);
        } else if ("updateIncident".equals(action)) {
            updateIncident(request, response);
        } else if ("deleteIncident".equals(action)) {
            deleteIncident(request, response);
        } else if ("deleteIncidents".equals(action)) {
            deleteIncidents(request, response);
        }
    }

    private void getAllIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAllIncidentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        int taskCount = service.getAllIncident().size();
        pageBean.setCount(taskCount);
        List<FireIncident> incidentList = service.getAllIncidentByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(incidentList, pageBean);
        response.getWriter().print(table);
    }

    private void findIncidentById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String incidentId = request.getParameter("incidentId");
        FireIncident incident = service.findIncidentById(Integer.parseInt(incidentId));
        request.setAttribute("incident", incident);
        request.getRequestDispatcher("/logistics/FireIncident/FireIncidentById.jsp").forward(request, response);

    }

    private void addIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String alarmTimeStr = request.getParameter("alarmTime");
        String incidentLocale = request.getParameter("incidentLocale");
        String staffNames = request.getParameter("staffNames");
        String cause = request.getParameter("cause");
        String loss = request.getParameter("loss");
        Date alarmTime = DateUtil.formatString(alarmTimeStr, "yyyy-MM-dd HH:mm:ss");
        FireIncident fireIncident = new FireIncident(alarmTime, incidentLocale, staffNames, cause, loss);
        int i = service.addIncident(fireIncident);
        response.getWriter().print(i);
    }

    private void editIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String incidentId = request.getParameter("incidentId");
        FireIncident incident = service.findIncidentById(Integer.parseInt(incidentId));
        request.setAttribute("incident", incident);
        request.getRequestDispatcher("/logistics/FireIncident/EditFireIncident.jsp").forward(request, response);
    }

    private void updateIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String incidentId = request.getParameter("incidentId");
        String alarmTimeStr = request.getParameter("alarmTime");
        String incidentLocale = request.getParameter("incidentLocale");
        String staffNames = request.getParameter("staffNames");
        String cause = request.getParameter("cause");
        String loss = request.getParameter("loss");
        Date alarmTime = DateUtil.formatString(alarmTimeStr, "yyyy-MM-dd HH:mm:ss");
        FireIncident fireIncident = new FireIncident(Integer.parseInt(incidentId), alarmTime, incidentLocale, staffNames, cause, loss);
        int i = service.updateIncident(fireIncident);
        response.getWriter().print(i);
    }

    private void deleteIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String incidentId = request.getParameter("incidentId");
        int i = service.deleteIncident(Integer.parseInt(incidentId));
        response.getWriter().print(i);
    }

    private void deleteIncidents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("incidentIds");
        String[] incidentIds = ids.split(",");
        int sum = 0;
        for (int i = 0; i < incidentIds.length; i++) {
            sum += service.deleteIncident(Integer.parseInt(incidentIds[i]));
        }
        response.getWriter().print(sum);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
