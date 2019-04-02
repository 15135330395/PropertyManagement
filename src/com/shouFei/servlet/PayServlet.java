package com.shouFei.servlet;


import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.shouFei.entity.Pay;
import com.shouFei.service.PayService;
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

/**
 * @Acthor:孙琪; date:2019/3/31;
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
        PayService service=new PayService();
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
        }
    }
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String department = request.getParameter("department");
        String staffId = request.getParameter("staffId");
        String staffName=request.getParameter("staffName");
        String monery = request.getParameter("monery");
        String reason = request.getParameter("reason");
        String transactor = request.getParameter("transactor");
        String shijian = request.getParameter("shijian");
        int i = service.addPay(new Pay(department,Integer.parseInt(staffId),staffName,Double.parseDouble(monery), reason,transactor, DateUtil.formatString(shijian,"yyyy-MM-dd")));
        response.getWriter().print(i);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        String department = request.getParameter("department");
        String staffId = request.getParameter("staffId");
        String staffName=request.getParameter("staffName");
        String monery = request.getParameter("monery");
        String reason = request.getParameter("reason");
        String transactor = request.getParameter("transactor");
        String shijian = request.getParameter("shijian");
        int i = service.updatePay(new Pay(Integer.parseInt(pid),department,Integer.parseInt(staffId),staffName,Double.parseDouble(monery), reason,transactor, DateUtil.formatString(shijian,"yyyy-MM-dd")));
        response.getWriter().print(i);

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int pid=-1;
        if(!StringUtil.isEmpty(id)){
            pid=Integer.parseInt(id);
        }
        int  i = service.deletePay(pid);
        response.getWriter().print(""+i);
    }
    private void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int pid=-1;
        if(!StringUtil.isEmpty(id)){
            pid=Integer.parseInt(id);
        }
        Pay payById = service.findPayById(Integer.parseInt(id));
        request.setAttribute("payById",payById);
        request.getRequestDispatcher("/shouFei/pay/payAdd.jsp").forward(request,response);
    }
    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());

        List<Pay> payList = service.queryByPage(pageBean);
        JSONObject array = JsonUtil.getJsonObject(payList, pageBean);
        response.getWriter().print(array);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
