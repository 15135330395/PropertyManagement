package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.Department;
import com.entity.PageBean;
import com.entity.Staff;
import com.manager.dao.DepartmentDao;
import com.manager.dao.daoimpl.DepartmentDaoImpl;
import com.personnel.entity.Interview;
import com.personnel.service.InterviewService;
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
 * @Date: 2019/3/29
 */
@WebServlet(name = "InterviewServlet",urlPatterns = "/InterviewServlet")
public class InterviewServlet extends HttpServlet {
    private InterviewService interviewService =new InterviewService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            add(request, response);
        }else if ("delete".equals(action)) {
            delete(request, response);
        }else if ("queryPage".equals(action)) {
            queryPage(request, response);
        }else if ("addOffer".equals(action)) {
            addOffer(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void addOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String interviewId = request.getParameter("interviewId");
        int i = interviewService.addOffer(Integer.parseInt(interviewId));
        response.getWriter().print(i);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applyName = request.getParameter("applyName");
        String applyPosition = request.getParameter("applyPosition");
        String departmentName = request.getParameter("departmentName");
        String interviewer = request.getParameter("interviewer");
        Interview interview = new Interview(applyName,applyPosition,departmentName,interviewer);
        int i = interviewService.addInterview(interview);
        response.getWriter().print(i);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String interviewId = request.getParameter("interviewId");
        int i = interviewService.deleteInterview(Integer.parseInt(interviewId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(interviewService.findAll().size());
        List<Interview> interviewList = interviewService.queryPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(interviewList, pageBean);
        response.getWriter().print(jsonObject);
    }
}
