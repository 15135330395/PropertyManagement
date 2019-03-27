package com.manager.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.manager.entity.Area;
import com.manager.service.AreaService;
import com.utils.JsonUtil;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haoyu
 * date ：2019/3/27
 */
@WebServlet(name = "AreaServlet",urlPatterns = "/AreaServlet")
public class AreaServlet extends HttpServlet {
    AreaService service = new AreaService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");

        if("query".equals(action)){
            query(request,response);
        }else if("add".equals(action)){
            add(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("deleteAll".equals(action)){
            deleteAll(request,response);
        }else if("queryOne".equals(action)){
            queryOne(request,response);
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

        List<Area> areaList = service.queryByPage(pageBean);
        JSONObject array = JsonUtil.getJsonObject(areaList,pageBean);
        response.getWriter().print(array);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeName = request.getParameter("typeName");
        NewsTypeDao dao = new NewsTypeDaoImpl();
        int i = dao.addNewsType(new NewsType(typeName));
        response.getWriter().print(i);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        String typeName = request.getParameter("typeName");
        NewsTypeDao dao = new NewsTypeDaoImpl();
        int i = dao.updateNewsType(new NewsType(Integer.parseInt(typeId),typeName));
        response.getWriter().print(i);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        int id = Integer.parseInt(typeId);
        NewsDao newsDao = new NewsDaoImpl();
        int newsCount = newsDao.findNewsCountByType(id);
        ResultCode resultCode =  new ResultCode();

        if(newsCount==0){
            NewsTypeDao dao = new NewsTypeDaoImpl();
            int i = dao.deleteNewsType(id);
            if(i>0){
                resultCode.setCode("2001");
                resultCode.setMessage("新闻类型删除成功");
            }else{
                resultCode.setCode("2002");
                resultCode.setMessage("新闻类型已删除或不存在");
            }
        }else{
            resultCode.setCode("2003");
            resultCode.setMessage("新闻类型下有新闻不可删除");
        }
        String json = JSONObject.toJSONString(resultCode);
        System.out.println(json);
        response.getWriter().print(json);
    }

    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsTypeDao dao = new NewsTypeDaoImpl();
        String ids = request.getParameter("ids");
        System.out.println(ids);
        String[] id = ids.split(",");
        int sum=0;
        for (String typeId:id) {
            int  i = dao.deleteNewsType(Integer.parseInt(typeId));
            sum+=i;
        }
        response.getWriter().print(""+sum);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsTypeDao dao = new NewsTypeDaoImpl();
        String id = request.getParameter("id");
        int typeId=-1;
        if(!StringUtil.isEmpty(id)){
            typeId=Integer.parseInt(id);
        }
        NewsType type = dao.findTypeById(typeId);

        request.setAttribute("type",type);
        request.getRequestDispatcher("/background/newsType/addType.jsp").forward(request,response);

    }
}
