package com.equipment.servlet;

import com.equipment.entity.Contract;
import com.equipment.service.ContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * @author :张
 * Date  : 2019/3/27
 * @Description: ${NAME}
 */

@WebServlet(name = "ContractServlet")
public class ContractServlet extends HttpServlet {
    ContractService contractService=new ContractService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.sendRedirect("text/html;charset=utf-8");


        String action = request.getParameter("action");
        if("query".equals(action)){
            query(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractService.findAll();
        request.setAttribute("contractList",contractList);
        request.getRequestDispatcher("查询页面").forward(request,response);

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //添加对象时，如何获取对象，


    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contractId = request.getParameter("contractId");
        int i = contractService.deleteContract(Integer.parseInt(contractId));
        response.getWriter().print(i);  //用$.ajax({ }) 传递数据

    }
}
