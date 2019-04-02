package com.shouFei.servlet;


import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.shouFei.service.PayItemsService;
import com.shouFei.service.PayNormService;
import com.utils.JsonUtil;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/28;
 */
@WebServlet(name = "PayNormServlet",urlPatterns = "/PayNormServlet")
public class PayNormServlet extends HttpServlet {
    PayItemsService piservice = new PayItemsService();
    PayNormService service = new PayNormService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if ("query".equals(action)) {
            query(request, response);
        } else if ("add".equals(action)) {
            add(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        } else if ("queryOne".equals(action)) {
            queryOne(request, response);
        }else if ("queryList".equals(action)) {
            //queryList(request, response);
        }else if("findOne".equals(action)){
            findOne(request,response);
        }
    }



    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payName = request.getParameter("payName");
        String normName = request.getParameter("normName");
        String computeMode = request.getParameter("computeMode");
        String chargeCycle = request.getParameter("chargeCycle");
        int i = service.addPayNorm(new shouFei.entity.PayNorm(payName,normName,computeMode,Integer.parseInt(chargeCycle)));
        response.getWriter().print(i);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String normId = request.getParameter("normId");
        String payName = request.getParameter("payName");
        String normName = request.getParameter("normName");
        String computeMode = request.getParameter("computeMode");
        String chargeCycle = request.getParameter("chargeCycle");
        int i = service.updatePayNorm(new shouFei.entity.PayNorm(Integer.parseInt(normId),payName,normName,computeMode,Integer.parseInt(chargeCycle)));

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int normId=-1;
        if(!StringUtil.isEmpty(id)){
            normId=Integer.parseInt(id);
        }
        int  i = service.deletePayNorm(normId);
        response.getWriter().print(""+i);
    }
    private void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int normId=-1;
        if(!StringUtil.isEmpty(id)){
            normId=Integer.parseInt(id);
        }
        shouFei.entity.PayNorm payNormById = service.findPayNormById(Integer.parseInt(id));
        request.setAttribute("payNormById",payNormById);
        request.getRequestDispatcher("/shouFei/norm/payNormAdd.jsp").forward(request,response);
    }
    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<shouFei.entity.PayNorm> payNormList = service.queryByPage(pageBean);
        JSONObject array = JsonUtil.getJsonObject(payNormList, pageBean);
        response.getWriter().print(array);
    }
    protected void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("payName");
        String payName=name;
        List<shouFei.entity.PayNorm> payNorms = service.queryOne(payName);
        request.getSession().setAttribute("payNorms",payNorms);
        if (!payName.isEmpty()){
            response.getWriter().print(1);
        }else{
            response.getWriter().print(0);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
