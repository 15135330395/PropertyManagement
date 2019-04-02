package com.客户关系管理.servelt;


import com.客户关系管理.entity.CustomerRegister;
import com.客户关系管理.entity.PageBean;
import com.客户关系管理.service.CustomerRegisterService;
import utils.DateUtil;
import utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-27；
 */

@WebServlet(name = "CustomerRegisterServelt", urlPatterns = "/CustomerRegisterServelt", initParams = {@WebInitParam(name = "PageCount", value = "5")})
public class CustomerRegisterServelt extends HttpServlet {

    CustomerRegisterService service = new CustomerRegisterService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
System.out.println("action"+action);
        if ("add".equals(action)) {
            add(request, response);
        } else if ("findByaddr".equals(action)) {
            findByaddr(request, response);
        } else if ("update".equals(action)) {
            updata(request, response);
        } else if ("queryOne".equals(action)) {
            queryOne(request, response);
        } else {
            query(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageIndex = request.getParameter("pageIndex");
        String pageCount = getInitParameter("PageCount");
        PageBean pageBean = new PageBean();
        if (!StringUtil.isEmpty(pageIndex)) {
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setPageCount(Integer.parseInt(pageCount));
        pageBean.setCount(service.findAll().size());

        List<CustomerRegister> customerRegisterList = service.queryAll(pageBean);
        request.setAttribute("customerRegisterList", customerRegisterList);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/crm/customerManagement/JoinRegistrationData.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String startTime = request.getParameter("startTime");
        String phone = request.getParameter("phone");
        String checkAccept = request.getParameter("checkAccept");
        String keyState = request.getParameter("keyState");
        String are = request.getParameter("are");
        String build = request.getParameter("build");
        String house = request.getParameter("house");


        CustomerRegister customerRegister = new CustomerRegister(name, DateUtil.formatString(startTime, "yyyy-MM-dd HH:mm"), phone, are+"区"+build+"楼"+house+"室", checkAccept, keyState);
        int i = service.add(customerRegister);
        System.out.println(i);
        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("addr");
        CustomerRegister customerRegister = service.queryOne(id);

        request.setAttribute("customerRegister", customerRegister);
        request.getRequestDispatcher("/crm/customerManagement/JoinRegistrationDataupdata.jsp").forward(request, response);
    }

    protected void updata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String addr = request.getParameter("addr");
        String checkAccept = request.getParameter("checkAccept");
        String keyState = request.getParameter("keyState");

        CustomerRegister customerRegister = new CustomerRegister(name, phone, addr, checkAccept, keyState);
        System.out.println(customerRegister);
        int i = service.update(customerRegister);
        System.out.println(i);
        response.getWriter().print(i);
    }

    protected void findByaddr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String addr = request.getParameter("addr");

        CustomerRegister customerRegister = service.findByaddr(addr);

        if (customerRegister != null) {
            request.setAttribute("customerRegister", customerRegister);
            request.getRequestDispatcher("/crm/customerManagement/JoinRegistrationFind.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/crm/customerManagement/CustomerFindError.jsp").forward(request, response);
        }

    }
}
