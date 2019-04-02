package com.storage.servlet;


import com.alibaba.fastjson.JSONObject;
import com.storage.entity.Supplier;
import com.storage.service.SupplierService;
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
 * Time: 11:12
 * Description: No Description
 */
@WebServlet(name = "SupplierServlet",urlPatterns = "/SupplierServlet")
public class SupplierServlet extends HttpServlet {
    SupplierService supplierService=new SupplierService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("findAll".equals(action)){
            findAll(request,response);
        }else if("findOne".equals(action)){
            findOne(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Supplier> list = supplierService.findAll();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    protected void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Supplier supplier = supplierService.findOne(name);
        Object json = JSONObject.toJSON(supplier);
        response.getWriter().print(json);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String contactPerson = request.getParameter("contactPerson");
        String contactPhone = request.getParameter("contactPhone");
        String goodName = request.getParameter("goodName");
        String goodPrice = request.getParameter("goodPrice");
        Supplier supplier = new Supplier(Integer.parseInt(id), name, contactPerson, contactPhone,goodName,Integer.parseInt(goodPrice));
        int i = supplierService.update(supplier);
        response.getWriter().print(i);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String contactPerson = request.getParameter("contactPerson");
        String contactPhone = request.getParameter("contactPhone");
        String goodName = request.getParameter("goodName");
        String goodPrice = request.getParameter("goodPrice");
        Supplier supplier = new Supplier(Integer.parseInt(id), name, contactPerson, contactPhone,goodName,Integer.parseInt(goodPrice));
        int i = supplierService.add(supplier);
        response.getWriter().print(i);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = supplierService.deleteById(Integer.parseInt(id));
        response.getWriter().print(i);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
