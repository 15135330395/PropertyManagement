package com.storage.servlet;


import com.alibaba.fastjson.JSONObject;
import com.storage.entity.DiaoBo;
import com.storage.entity.Goods;
import com.storage.service.DiaoBoService;
import com.storage.service.GoodsService;
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
 * Time: 11:28
 * Description: No Description
 */
@WebServlet(name = "DiaoBoServlet",urlPatterns = "/DiaoBoServlet")
public class DiaoBoServlet extends HttpServlet {
    DiaoBoService diaoBoService=new DiaoBoService();
    GoodsService goodsService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("findAll".equals(action)){
            findAll(request,response);
        }else if("queryLimitDate".equals(action)){
            queryLimitDate(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DiaoBo> list = diaoBoService.findAll();
        JSONObject jsonObject = JsonUtil.getJsonObject(list);
        response.getWriter().print(jsonObject);
    }

    //查询某段时间之内的调拨记录
    protected void queryLimitDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<DiaoBo> list = diaoBoService.queryLimitDate(startDate, endDate);
        request.setAttribute("list",list);
        request.getRequestDispatcher("Storage/wuliao/DiaoBo/QueryLimitDate.jsp").forward(request,response);

    }

    //执行调拨动作,添加调拨记录
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String outId = request.getParameter("outId");
        String inId = request.getParameter("inId");
        String goodName = request.getParameter("good_name");
        String numbers = request.getParameter("numbers");
        //查询调出仓库的某物品数量。如果够就继续执行，不够直接返回
        Goods outOne = goodsService.findOne(Integer.parseInt(outId), goodName);
        if(outOne==null||outOne.getNumbers()<Integer.parseInt(numbers)){
            String msg="操作无效！物品不存在或库存数量不足";
            response.getWriter().print(msg);
        }else{
            Goods outGoods=goodsService.findOne(Integer.parseInt(outId),goodName);
            Goods inGoods = goodsService.findOne(Integer.parseInt(inId), goodName);
            //获取原仓库物品的库存
            int outNumbers = outGoods.getNumbers();
            //获取调入仓库的物品库存
            int inNumbers = inGoods.getNumbers();
            //原仓库减去相应数量物品
            outNumbers-=Integer.parseInt(numbers);
            //调入仓库增加相应数量
            inNumbers+=Integer.parseInt(numbers);

            //更新两个仓库现有的物品库存
            outGoods.setNumbers(outNumbers);
            inGoods.setNumbers(inNumbers);
            int i1=goodsService.update(outGoods);
            int i2 = goodsService.update(inGoods);
            if(i1!=0&&i2!=0){
                DiaoBo diaoBo = new DiaoBo(Integer.parseInt(outId), Integer.parseInt(inId), goodName, Integer.parseInt(numbers), DateUtil.dateToString(new Date(System.currentTimeMillis())));
                int i3=diaoBoService.add(diaoBo);
                if(i3!=0){
                    response.getWriter().print(i3);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
