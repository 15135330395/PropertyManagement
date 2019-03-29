package com.personnel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.entity.Staff;
import com.personnel.entity.Recuit;
import com.personnel.service.RecuitService;
import com.utils.DateUtil;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-29 下午 2:19
 */
@WebServlet(name = "RecuitServlet",urlPatterns = "/RecuitServlet")
public class RecuitServlet extends HttpServlet {
    private RecuitService recuitService=new RecuitService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("deleteAll".equals(action)) {
            deleteAll(request, response);
        } else if ("add".equals(action)) {
            add(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        } else if ("queryOne".equals(action)) {
            queryOne(request, response);
        } else if ("queryPage".equals(action)) {
            queryPage(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        System.out.println("ids"+ids);
        String[] array = ids.split(",");
        int sum=0;
        for (String recuitId: array) {
            int i = recuitService.deleteRecuit(Integer.parseInt(recuitId));
            sum+=i;
        }
        response.getWriter().print(sum);
    }


    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recuitPosition = request.getParameter("recuitPosition");
        String recuitCount = request.getParameter("recuitCount");
        String duty = request.getParameter("duty");
        String demand = request.getParameter("demand");
        String basicSalary = request.getParameter("basicSalary");



        Recuit recuit = new Recuit(recuitPosition,Integer.parseInt(recuitCount),duty
                ,demand,Double.parseDouble(basicSalary));
        int i = recuitService.addRecuit(recuit);
        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recuitId = request.getParameter("recuitId");
        String recuitPosition = request.getParameter("recuitPosition");
        String recuitCount = request.getParameter("recuitCount");
        String duty = request.getParameter("duty");
        String demand = request.getParameter("demand");
        String basicSalary = request.getParameter("basicSalary");
        Recuit recuit = new Recuit(Integer.parseInt(recuitId),recuitPosition,Integer.parseInt(recuitCount),duty
                ,demand,Double.parseDouble(basicSalary));

        int i = recuitService.updateRecuit(recuit);
        response.getWriter().print(i);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recuitId = request.getParameter("recuitId");
        Recuit recuit = recuitService.queryOne(Integer.parseInt(recuitId));
        request.setAttribute("recuit", recuit);
        request.getRequestDispatcher("/personnel/background/recuit/recuitAdd.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recuitId = request.getParameter("recuitId");
        int i = recuitService.deleteRecuit(Integer.parseInt(recuitId));
        response.getWriter().print(i);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page"); //页码
        String limit = request.getParameter("limit"); // 每页条数
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(recuitService.findAll().size());
        List<Recuit> recuitList = recuitService.queryRecuitPage(pageBean);
        JSONObject jsonObject = JsonUtil.getJsonObject(recuitList, pageBean);
        response.getWriter().print(jsonObject);
    }
}
