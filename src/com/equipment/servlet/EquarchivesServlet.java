package com.equipment.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.equipment.entity.Equarchives;
import com.equipment.service.EquarchivesService;
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
@WebServlet(name = "EquarchivesServlet",urlPatterns = "/EquarchivesServlet",initParams = {@WebInitParam(name="pageCount",value="10")})
public class EquarchivesServlet extends HttpServlet {

    EquarchivesService equarchivesService=new EquarchivesService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
        if("query".equals(action)){
            query(request,response);
        }else if("queryPage".equals(action)){
            queryPage(request,response);
        }else if("queryOneBack".equals(action)){
            queryOneBack(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("toadd".equals(action)){
            toadd(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("deleteAll".equals(action)){
            System.out.println("eaServlet...action"+action);
            deleteAll(request,response);
        }



    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equarchives> list = equarchivesService.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("前台查询页面").forward(request,response);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("page");
        PageBean pageBean=new PageBean();
        if(!StringUtil.isEmpty(pageIndex)){
           pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setCount(equarchivesService.findAll().size());
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        List<Equarchives> equarchivesList = equarchivesService.queryPage(pageBean);

        JSONObject jsonObject= JsonUtil.getJsonObject(equarchivesList, pageBean);
        response.getWriter().print(jsonObject);

    }

    protected void queryOneBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Equarchives equarchives = equarchivesService.findById(Integer.parseInt(id));
        request.setAttribute("equarchives",equarchives);
        request.getRequestDispatcher("/equbackground/equarchives/equarchivesUpdate.jsp").forward(request,response);

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ano = request.getParameter("ano");
        String ename = request.getParameter("ename");
        String eno = request.getParameter("eno");
        String department = request.getParameter("department");
        String recordDate = request.getParameter("recordDate");
        String manufacturer = request.getParameter("manufacturer");
        String price = request.getParameter("price");
        String place = request.getParameter("place");
        Equarchives equarchives=new Equarchives(ano,ename,eno,department, DateUtil.formatString(recordDate,"yyyy-MM-dd"),
                manufacturer,Double.parseDouble(price),place);
        int i = equarchivesService.add(equarchives);
        response.getWriter().print(i);

    }
    protected void toadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("equbackground/equarchives/equarchivesAdd.jsp");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ano = request.getParameter("ano");
        String ename = request.getParameter("ename");
        String eno = request.getParameter("eno");
        String department = request.getParameter("department");
        String recordDate = request.getParameter("recordDate");
        String manufacturer = request.getParameter("manufacturer");
        String price = request.getParameter("price");
        String place = request.getParameter("place");
        Equarchives equarchives=new Equarchives(Integer.parseInt(id),ano,ename,eno,department, DateUtil.formatString(recordDate,"yyyy-MM-dd"),
                manufacturer,Double.parseDouble(price),place);
        int i = equarchivesService.update(equarchives);
        response.getWriter().print(i);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = equarchivesService.deleteById(Integer.parseInt(id));
        response.getWriter().print(i);

    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] idArr = ids.split(",");
        int sum=0;
        for(String id:idArr){
            System.out.println(id);
            int i = equarchivesService.deleteById(Integer.parseInt(id));
            sum+=i;
        }
        response.getWriter().print(sum);
    }
}
