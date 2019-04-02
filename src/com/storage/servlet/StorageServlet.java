package com.storage.servlet;


import com.alibaba.fastjson.JSONObject;
import com.storage.entity.Storage;
import com.storage.service.StorageService;
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
@WebServlet(name = "StorageServlet",urlPatterns = "/StorageServlet")
public class StorageServlet extends HttpServlet {
    StorageService storageService=new StorageService();
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
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Storage> list = storageService.findAll();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    protected void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Storage storage = storageService.findOne(Integer.parseInt(id));
        Object json = JSONObject.toJSON(storage);
        response.getWriter().print(json);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String principal = request.getParameter("principal");
        String contactPhone = request.getParameter("contactPhone");
        Storage storage = new Storage(Integer.parseInt(id), principal, contactPhone);
        int i = storageService.update(storage);
        response.getWriter().print(i);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
