package com.manager.servlet;

import com.entity.PageBean;
import com.manager.entity.Building;
import com.manager.service.BuildingService;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoyu
 * date ：2019/3/27
 */
@WebServlet(name = "BuildingServlet",urlPatterns = "/BuildingServlet",initParams ={@WebInitParam(name="pageCount",value = "10")})
public class BuildingServlet extends HttpServlet {
    private BuildingService buildingService = new BuildingService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("query".equals(action)){
            query(request, response);
        }else if("queryOne".equals(action)){
            queryOne(request, response);
        }
    }
    private void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
