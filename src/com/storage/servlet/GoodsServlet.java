package com.storage.servlet;


import com.alibaba.fastjson.JSONObject;
import com.storage.entity.Goods;
import com.storage.entity.OutStorage;
import com.storage.service.GoodsService;
import com.storage.service.OutStorageService;
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

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/3/27
 * Time: 11:25
 * Description: No Description
 */
@WebServlet(name = "GoodsServlet",urlPatterns = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    GoodsService goodsService=new GoodsService();
    OutStorageService outStorageService=new OutStorageService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("findAll".equals(action)){
            findAll(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("outStorage".equals(action)){
            outStorage(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("findByGoodsName".equals(action)){
            findByGoodsName(request,response);
        }else if("warning".equals(action)){
            warning(request,response);
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> list = goodsService.findAll();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    //物品进库
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String good_name = request.getParameter("good_name");
        String numbers = request.getParameter("numbers");
        Goods one = goodsService.findOne(Integer.parseInt(id), good_name);
        if(one==null){
            Goods goods = new Goods(Integer.parseInt(id), good_name, Integer.parseInt(numbers));
            int i = goodsService.add(goods);
            response.getWriter().print(i);
        }else{
            int numbers1 = one.getNumbers();
            int newNumbers=numbers1+Integer.parseInt(numbers);
            Goods goods = new Goods(Integer.parseInt(id), good_name, newNumbers);
            int i = goodsService.update(goods);
            response.getWriter().print(i);
        }
    }

    //出库后更新物品库存，并添加到出库记录中以供查询
    protected void outStorage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String goodName = request.getParameter("goodName");
        String numbers = request.getParameter("numbers");
        Goods one = goodsService.findOne(Integer.parseInt(id), goodName);
        if(one.getNumbers()<Integer.parseInt(numbers)){
            String msg="出库失败！库存不足";
            response.getWriter().print(msg);
        }else{
            int kucun=one.getNumbers();
            int newNumbers=kucun-Integer.parseInt(numbers);
            Goods goods = new Goods(Integer.parseInt(id), goodName, newNumbers);
            int i = goodsService.update(goods);
            if(i!=0){
                OutStorage outStorage = new OutStorage(Integer.parseInt(id), goodName, Integer.parseInt(numbers), DateUtil.dateToString(new Date(System.currentTimeMillis())));
                int i2 = outStorageService.add(outStorage);
                response.getWriter().print(i2);
            }
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String goodName = request.getParameter("goodName");
        int i = goodsService.delete(Integer.parseInt(id), goodName);
        response.getWriter().print(i);
    }

    protected void findByGoodsName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodName = request.getParameter("name");
        List<Goods> list = goodsService.findByGoodsName(goodName);
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    protected void warning(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> list = goodsService.findWarning();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
