package com.客户关系管理.servelt;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.utils.JsonUtil;
import com.客户关系管理.entity.Customer;
import com.客户关系管理.service.CustomerService;
import javax.servlet.ServletException;
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


@WebServlet(name = "CustomerServlet",urlPatterns = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    CustomerService service = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if("query".equals(action)){
            query(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("findByName".equals(action)){
            findByName(request,response);
        }else if("updata".equals(action)){
            updata(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());

        List<Customer> customer = service.queryAll(pageBean);

        JSONObject jsonObject = JsonUtil.getJsonObject(customer,pageBean);
        response.getWriter().print(jsonObject);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        int i = service.delete(Integer.parseInt(id));

        response.getWriter().print(i);
    }
    protected void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String name = request.getParameter("name");

        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findName(name).size());

        List<Customer> customer = service.findByName(name,pageBean);

        JSONObject jsonObject = JsonUtil.getJsonObject(customer,pageBean);
        response.getWriter().print(jsonObject);
    }
    protected void updata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String customerNature = request.getParameter("customerNature");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String car = request.getParameter("car");
        String pet = request.getParameter("pet");
        String extraDemand = request.getParameter("extraDemand");
        String addr = request.getParameter("addr");

        Customer customer = new Customer(name, customerNature, phone, idCard, car, pet, extraDemand, addr);
        int i = service.update(customer);

        response.getWriter().print(i);

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String customerNature = request.getParameter("customerNature");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String car = request.getParameter("car");
        String pet = request.getParameter("pet");
        String extraDemand = request.getParameter("extraDemand");
        String addr = request.getParameter("addr");

        Customer customer = new Customer(name, customerNature, phone, idCard, car, pet, extraDemand, addr);

        int i = service.add(customer);
        response.getWriter().print(i);
    }
}
