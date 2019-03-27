package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.service.StaffService;
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
 * @Date: 2019-03-27 下午 6:21
 */
@WebServlet(name = "StaffServlet",urlPatterns = "/StaffServlet")
public class StaffServlet extends HttpServlet {
    private StaffService staffService=new StaffService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("query".equals(action)){
            query(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("queryOne".equals(action)){
            queryOne(request,response);
        } else if("queryPage".equals(action)){
            queryPage(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean=new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(staffService.findAll().size());
        List<Staff> staffList = staffService.queryStaffPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(staffList, pageBean);
        response.getWriter().print(jsonObject);
    }

}
