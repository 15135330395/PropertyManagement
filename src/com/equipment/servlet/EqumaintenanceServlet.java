package com.equipment.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.equipment.entity.Equmaintenance;
import com.equipment.service.EqumaintenanceService;
import com.utils.DateUtil;
import com.utils.JsonUtil;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * @author :张
 * Date  : 2019/4/1
 * @Description: ${NAME}
 */
@WebServlet(name = "EqumaintenanceServlet",urlPatterns = "/EqumaintenanceServlet")
public class EqumaintenanceServlet extends HttpServlet {
    EqumaintenanceService eService=new EqumaintenanceService();

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
            System.out.println("action="+action);
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("queryPage".equals(action)){
            queryPage(request,response);
        }else if("queryOneBack".equals(action)){
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
        List<Equmaintenance> list = eService.findAll();
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

        List<Equmaintenance> equmaintenance = eService.queryPage(pageBean);
        JSONObject jsonObject= JsonUtil.getJsonObject(equmaintenance,pageBean);
         response.getWriter().print(jsonObject);
    }
    protected void queryOneBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("eid");
        Equmaintenance equmaintenance = eService.findById(Integer.parseInt(id));
        System.out.println(equmaintenance);
        request.setAttribute("equmaintenance",equmaintenance);
        request.getRequestDispatcher("/equbackground/equmaintenance/equmaintenanceUpdate.jsp").forward(request,response);

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eid = request.getParameter("eid");
        String ename = request.getParameter("ename");
        String eno = request.getParameter("eno");
        String content = request.getParameter("content");
        String charge = request.getParameter("charge");
        String edate = request.getParameter("edate");
        String material = request.getParameter("material");
        String number = request.getParameter("number");
        Equmaintenance equmaintenance=new Equmaintenance(ename,eno, content,charge,DateUtil.formatString(edate,"yyyy-MM-dd HH:mm:ss"),material,Integer.parseInt(number));
        int i = eService.add(equmaintenance);
        response.getWriter().print(i);

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eid = request.getParameter("eid");
        String ename = request.getParameter("ename");
        String eno = request.getParameter("eno");
        String content = request.getParameter("content");
        String charge = request.getParameter("charge");
        String edate = request.getParameter("edate");
        String material = request.getParameter("material");
        String number = request.getParameter("number");
        Equmaintenance equmaintenance=new Equmaintenance(Integer.parseInt(eid),ename,eno, content,charge,DateUtil.formatString(edate,"yyyy-MM-dd HH:mm:ss"),material,Integer.parseInt(number));
        System.out.println("修改之后"+equmaintenance);
        int i = eService.update(equmaintenance);
        System.out.println(i);
        response.getWriter().print(i);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("eid");
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
        request.getRequestDispatcher("/equbackground/equmaintenance/equmaintenanceAdd.jsp").forward(request,response);

    }


}
