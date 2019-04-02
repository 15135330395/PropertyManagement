package com.客户关系管理.servelt;


import com.客户关系管理.entity.Customer;
import com.客户关系管理.entity.PageBean;
import com.客户关系管理.service.CustomerService;
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


@WebServlet(name = "CustomerServlet",urlPatterns = "/CustomerServlet",initParams = {@WebInitParam(name = "PageCount",value = "5")})
public class CustomerServlet extends HttpServlet {

    CustomerService service = new CustomerService();
    Customer customer = new Customer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("add".equals(action)){
            add(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("findByName".equals(action)){
            findByName(request,response);
        }else if("update".equals(action)){
            updata(request,response);
        }else if("queryOne".equals(action)){
            queryOne(request,response);
        }else if("deleteAll".equals(action)){
            deleteAll(request,response);
        }else {
            query(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("pageIndex");
        String pageCount = getInitParameter("PageCount");

        PageBean pageBean = new PageBean();
        if(!StringUtil.isEmpty(pageIndex)){
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setPageCount(Integer.parseInt(pageCount));
        pageBean.setCount(service.findAll().size());

        List<Customer> customer = service.queryAll(pageBean);
        request.setAttribute("customerList",customer);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/crm/customerManagement/CustomerData.jsp").forward(request,response);
    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("idCard");
        Customer customer = service.queryOne(id);

        request.setAttribute("customer",customer);
        request.getRequestDispatcher("/crm/customerManagement/CustomerDataUpdata.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        int i = service.delete(Integer.parseInt(id));
        response.getWriter().print(i);
    }
    protected void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pageIndex = request.getParameter("pageIndex");
        String pageCount = getInitParameter("PageCount");

        PageBean pageBean = new PageBean();
        if(!StringUtil.isEmpty(pageIndex)){
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        pageBean.setPageCount(Integer.parseInt(pageCount));
        pageBean.setCount(service.findName(name).size());

        List<Customer> customer = service.findByName(name,pageBean);
        if(customer.size() == 0){
            request.getRequestDispatcher(request.getContextPath() + "/crm/customerManagement/CustomerFindError.jsp").forward(request, response);
        }else {
            request.setAttribute("customerList", customer);
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher(request.getContextPath() + "/crm/customerManagement/CustomerFind.jsp").forward(request, response);
        }
    }
    protected void updata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String customerNature = request.getParameter("customerNature");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String car = request.getParameter("car");
        String pet = request.getParameter("pet");
        String addr = request.getParameter("addr");

        Customer customer = new Customer(name, customerNature, phone, idCard, car, pet, addr);

        int i = service.update(customer);
        response.getWriter().print(i);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String customerNature = request.getParameter("customerNature");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String car = request.getParameter("car");
        if("".equals(car)){
            car = customer.getCar();
        }
        String pet = request.getParameter("pet");
        if("".equals(pet)){
            pet = customer.getPet();
        }
        String addr = request.getParameter("addr");
        String bid = request.getParameter("bid");
        String hid = request.getParameter("hid");

        Customer customer = new Customer(name, customerNature, phone, idCard, car, pet, addr+"区"+hid+"楼"+bid+"室");

        int i = service.add(customer);
        response.getWriter().print(i);
    }

    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ids = request.getParameter("ids");
        String[] id = ids.split(",");
        int sum = 0;
        for (String idss:id) {
            int i = service.delete(Integer.parseInt(idss));
            sum+=i;
        }
        response.getWriter().print(""+sum);
    }

}
