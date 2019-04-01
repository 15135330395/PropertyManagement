package com.equipment.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.equipment.entity.Equmalfunction;
import com.equipment.service.EqumalfunctionService;
import com.utils.DateUtil;
import com.utils.JsonUtil;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * @author:张国栋
 * Date  ：2019/4/1
 * */
@WebServlet(name = "EqumalfunctionServlet",urlPatterns = "/EqumalfunctionServlet",initParams = {@WebInitParam(name="pageCount",value="10")})
public class EqumalfunctionServlet extends HttpServlet {

    EqumalfunctionService eService=new EqumalfunctionService();
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

       String action = request.getParameter("action");
       if("query".equals(action)){
           query(request,response);
       }else if("add".equals(action)){
           add(request,response);
       }else if("update".equals(action)){
           System.out.println("eaServlet.....action="+action);
           update(request,response);
       }else if("delete".equals(action)){
           delete(request,response);
       }else if("queryPage".equals(action)){
           queryPage(request,response);
       }else if("queryOneBack".equals(action)){
           System.out.println("eaServlet.....action="+action);
           queryOneBack(request,response);
       }else if("toadd".equals(action)){
           toadd(request,response);
       }else if("deleteAll".equals(action)){
           deleteAll(request,response);
       }

   }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equmalfunction> list = eService.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("前台页面").forward(request,response);

    }
    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("page");
        PageBean pageBean=new PageBean();
        if(!StringUtil.isEmpty(pageIndex)){
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setCount(eService.findAll().size());
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));

        List<Equmalfunction> equmalfunction = eService.queryPage(pageBean);
        JSONObject jsonObject= JsonUtil.getJsonObject(equmalfunction,pageBean);
        response.getWriter().print(jsonObject);
    }
    protected void queryOneBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("mid");
        Equmalfunction equmalfunction = eService.findById(Integer.parseInt(id));
        System.out.println(equmalfunction);
        request.setAttribute("equmalfunction",equmalfunction);
        request.getRequestDispatcher("/equbackground/equmalfunction/equmalfunctionUpdate.jsp").forward(request,response);

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mid = request.getParameter("mid");
        String ename = request.getParameter("ename");
        String eno = request.getParameter("eno");
        String mdate = request.getParameter("mdate");
        String handler = request.getParameter("handler");
        String installdetail = request.getParameter("installdetail");
        String operation = request.getParameter("operation");
        String maintenance = request.getParameter("maintenance");
        String rejection = request.getParameter("rejection");

        Equmalfunction equmalfunction=new Equmalfunction(Integer.parseInt(mid),ename,eno, DateUtil.formatString(mdate,"yyyy-MM-dd HH:mm:ss"),handler,installdetail,operation,maintenance,rejection);
        int i = eService.add(equmalfunction);
        response.getWriter().print(i);

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mid = request.getParameter("mid");
        String ename = request.getParameter("ename");
        String eno = request.getParameter("eno");
        String mdate = request.getParameter("mdate");
        String handler = request.getParameter("handler");
        String installdetail = request.getParameter("installdetail");
        String operation = request.getParameter("operation");
        String maintenance = request.getParameter("maintenance");
        String rejection = request.getParameter("rejection");

        Equmalfunction equmalfunction=new Equmalfunction(Integer.parseInt(mid),ename,eno, DateUtil.formatString(mdate,"yyyy-MM-dd HH:mm:ss"),handler,installdetail,operation,maintenance,rejection);
        int i = eService.update(equmalfunction);
        response.getWriter().print(i);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("mid");
        int i = eService.deleteById(Integer.parseInt(id));
        response.getWriter().print(i);

    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] idArr = ids.split(",");
      int sum=0;
        for(String id:idArr){
            int i = eService.deleteById(Integer.parseInt(id));
        sum+=i;
        }
       response.getWriter().print(sum);
    }

    protected void toadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/equbackground/equmalfunction/equmalfunctionAdd.jsp").forward(request,response);

    }


}
