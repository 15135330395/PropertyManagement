package com.storage.servlet;


import com.alibaba.fastjson.JSONObject;
import com.storage.entity.OutStorage;
import com.storage.service.OutStorageService;
import com.storage.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/27
 * Time: 11:28
 * Description: No Description
 */
@WebServlet(name = "OutStorageServlet",urlPatterns = "/OutStorageServlet")
public class OutStorageServlet extends HttpServlet {
    OutStorageService outStorageService=new OutStorageService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("findAll".equals(action)){
            findAll(request,response);
        }else if("queryLimitDate".equals(action)){
            queryLimitDate(request,response);
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OutStorage> list = outStorageService.findAll();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    protected void queryLimitDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<OutStorage> list = outStorageService.queryLimitDate(startDate, endDate);
        request.setAttribute("list",list);
        request.getRequestDispatcher("Storage/wuliao/OutStorage/QueryLimitDate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
