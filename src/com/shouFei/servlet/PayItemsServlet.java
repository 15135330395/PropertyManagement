package com.shouFei.servlet;

import com.alibaba.fastjson.JSONObject;
import com.shouFei.service.PayItemsService;
import com.utils.JsonUtil;
import com.shouFei.dao.PayNormDao;
import com.shouFei.dao.daoImpl.PayNormDaoImpl;
import com.entity.PageBean;
import shouFei.entity.PayItems;
import shouFei.entity.ResultCode;

import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/26;
 */
@WebServlet("/PayItemsServlet")
public class PayItemsServlet extends HttpServlet {

    PayItemsService service = new PayItemsService();
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());

        List<PayItems> PayItemsList = service.queryByPage(pageBean);
        JSONObject array = JsonUtil.getJsonObject(PayItemsList,pageBean);
        response.getWriter().print(array);

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payName = request.getParameter("payName");
        String payType = request.getParameter("payType");
        String billingAaccuracy = request.getParameter("billingAaccuracy");
        String note = request.getParameter("note");
        int i = service.addPayItems(new PayItems(payName,payType,billingAaccuracy,note));
        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payId=request.getParameter("payId");
        String payName = request.getParameter("payName");
        System.out.println("payName"+payName);
        String payType = request.getParameter("payType");
        String billingAccuracy = request.getParameter("billingAccuracy");
        String note = request.getParameter("note");
        int i = service.updatePayItems(new PayItems(Integer.parseInt(payId),payName, payType,billingAccuracy,note));
        response.getWriter().print(i);
        System.out.println("i"+i);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payId=request.getParameter("payId");
        System.out.println(payId);
        int id = Integer.parseInt(payId);
        PayNormDao pNdao=new PayNormDaoImpl();
        int payNormCount = pNdao.findPayNormCountById(id);
       ResultCode resultCode =  new ResultCode();
        if(payNormCount==0){
            int i = service.deletePayItems(id);
            if(i>0){
                resultCode.setCode("2001");
                resultCode.setMessage("收费项目删除成功");
            }else{
                resultCode.setCode("2002");
                resultCode.setMessage("收费项目已删除或不存在");
            }
        }else{
            resultCode.setCode("2003");
            resultCode.setMessage("收费项目下有收费标准不可删除");
        }
        String json = JSONObject.toJSONString(resultCode);
        //System.out.println(json);
        response.getWriter().print(json);
    }



    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int payId=-1;
        if(!StringUtil.isEmpty(id)){
            payId=Integer.parseInt(id);
        }
        PayItems payItemsById = service.findPayItemsById(Integer.parseInt(id));
        request.setAttribute("payItemsById",payItemsById);
        request.getRequestDispatcher("/shouFei/items/payItemsAdd.jsp").forward(request,response);

    }
}

