package com.storage.servlet;


import com.alibaba.fastjson.JSONObject;
import com.storage.entity.Goods;
import com.storage.entity.PurchaseDeliver;
import com.storage.entity.PurchaseListOrder;
import com.storage.service.GoodsService;
import com.storage.service.PurchaseService;
import com.storage.util.DateUtil;
import com.storage.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/27
 * Time: 11:11
 * Description: No Description
 */
@WebServlet(name = "PurchaseServlet",urlPatterns = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    PurchaseService purchaseService=new PurchaseService();
    GoodsService goodsService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("PurchaseDeliverFindAll".equals(action)){
            PurchaseDeliverFindAll(request,response);
        }else if("PurchaseDeliverFindOne".equals(action)){
            PurchaseDeliverFindOne(request,response);
        }else if("PurchaseDeliverAdd".equals(action)){
            PurchaseDeliverAdd(request,response);
        }else if("PurchaseDeliverDelete".equals(action)){
            PurchaseDeliverDelete(request,response);
        }else if("PurchaseDeliverDeleteAddList".equals(action)){
            PurchaseDeliverDeleteAddList(request,response);
        }else if("PurchaseListOrderFindAll".equals(action)){
            PurchaseListOrderFindAll(request,response);
        }else if("queryLimitDate".equals(action)){
            queryLimitDate(request,response);
        }
    }





    //采购分单全部
    protected void PurchaseDeliverFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PurchaseDeliver> list = purchaseService.PurchaseDeliverfindAll();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    protected void PurchaseDeliverFindOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String goodName = request.getParameter("goodName");
        PurchaseDeliver purchaseDeliver = purchaseService.PurchaseDeliverfindOne(Integer.parseInt(id), goodName);
        Object json = JSONObject.toJSON(purchaseDeliver);
        response.getWriter().print(json);
    }

    //分单添加到记录，同时从分担申请中删除相关信息
    protected void PurchaseDeliverAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String goodName = request.getParameter("goodName");
        String supplier1Name = request.getParameter("supplier1Name");
        String supplier1Price = request.getParameter("supplier1Price");
        String supplier1Numbers = request.getParameter("supplier1Numbers");
        String supplier2Name = request.getParameter("supplier2Name");
        String supplier2Price = request.getParameter("supplier2Price");
        String supplier2Numbers = request.getParameter("supplier2Numbers");
        String total = request.getParameter("total");
        PurchaseDeliver purchaseDeliver = new PurchaseDeliver(Integer.parseInt(id), goodName, supplier1Name, Integer.parseInt(supplier1Price),
                Integer.parseInt(supplier1Numbers), supplier2Name, Integer.parseInt(supplier2Price), Integer.parseInt(supplier2Numbers), Integer.parseInt(total));
        int i = purchaseService.PurchaseDeliveradd(purchaseDeliver);
                response.getWriter().print(i);
    }

    protected void PurchaseDeliverDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String goodName = request.getParameter("goodName");
        int i = purchaseService.PurchaseDeliverdelete(Integer.parseInt(id), goodName);
        response.getWriter().print(i);
    }

    //申请通过之后删除申请表中的信息，生成订单，并更新对应物品库存
    protected void PurchaseDeliverDeleteAddList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String goodName = request.getParameter("goodName");
        String supplier1Numbers = request.getParameter("supplier1Numbers");
        String supplier2Numbers = request.getParameter("supplier2Numbers");
        String cost = request.getParameter("total");
        int i = purchaseService.PurchaseDeliverdelete(Integer.parseInt(id), goodName);
        if(i!=0){
            int numbers=Integer.parseInt(supplier1Numbers)+Integer.parseInt(supplier2Numbers);
            String date = DateUtil.dateToString(new Date(System.currentTimeMillis()));
            int hashCodeV = UUID.randomUUID().toString().hashCode();
            if(hashCodeV < 0) {//有可能是负数
                hashCodeV = - hashCodeV;
            }
            String listNumber=date+"-"+hashCodeV;
            PurchaseListOrder purchaseListOrder = new PurchaseListOrder(Integer.parseInt(id), goodName, numbers, Integer.parseInt(cost), date, listNumber);
            int i2 = purchaseService.PurchaseListOrderadd(purchaseListOrder);
            if(i2!=0){
                Goods goods = new Goods(Integer.parseInt(id), goodName, numbers);
                int add = goodsService.add(goods);
                response.getWriter().print(add);
            }
        }
    }

    //采购订单全部
    protected void PurchaseListOrderFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PurchaseListOrder> list = purchaseService.PurchaseListOrderfindAll();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    protected void queryLimitDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<PurchaseListOrder> list = purchaseService.queryLimitDate(startDate, endDate);
        request.setAttribute("list",list);
        request.getRequestDispatcher("Storage/wuliao/Purchase/QueryLimitDate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
