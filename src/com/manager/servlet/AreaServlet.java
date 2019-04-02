package com.manager.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.entity.ResultCode;
import com.manager.dao.AreaDao;
import com.manager.dao.BuildingDao;
import com.manager.dao.daoimpl.AreaDaoImpl;
import com.manager.dao.daoimpl.BuildingDaoImpl;
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
        String areaName = request.getParameter("areaName");
        AreaDao dao = new AreaDaoImpl();
        int i = dao.addArea(new Area(areaName));
        response.getWriter().print(i);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String areaId = request.getParameter("areaId");
        String areaName = request.getParameter("areaName");
        AreaDao dao = new AreaDaoImpl();
        int i = dao.updateArea(new Area(Integer.parseInt(areaId),areaName));
        response.getWriter().print(i);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String areaId = request.getParameter("areaId");
        int id = Integer.parseInt(areaId);
        BuildingDao buildingDao = new BuildingDaoImpl();
        int buildingCount = buildingDao.findBuildingCountByArea(id);
        ResultCode resultCode =  new ResultCode();

        if(buildingCount==0){
            AreaDao dao = new AreaDaoImpl();
            int i = dao.deleteArea(id);
            if(i>0){
                resultCode.setCode("2001");
                resultCode.setMessage("区域删除成功");
            }else{
                resultCode.setCode("2002");
                resultCode.setMessage("区域已删除或不存在");
            }
        }else{
            resultCode.setCode("2003");
            resultCode.setMessage("区域下有楼宇不可删除");
        }
        String json = JSONObject.toJSONString(resultCode);
        System.out.println(json);
        response.getWriter().print(json);
    }

    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AreaDao dao = new AreaDaoImpl();
        String ids = request.getParameter("ids");
        System.out.println(ids);
        String[] id = ids.split(",");
        int sum=0;
        for (String areaId:id) {
            int  i = dao.deleteArea(Integer.parseInt(areaId));
            sum+=i;
        }
        response.getWriter().print(""+sum);
    }

    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AreaDao dao = new AreaDaoImpl();
        String id = request.getParameter("id");
        int areaId=-1;
        if(!StringUtil.isEmpty(id)){
            areaId=Integer.parseInt(id);
        }
        Area area = dao.findAreaById(areaId);

        request.setAttribute("area",area);
        request.getRequestDispatcher("/manager/background/area/areaAdd.jsp").forward(request,response);

    }
}
