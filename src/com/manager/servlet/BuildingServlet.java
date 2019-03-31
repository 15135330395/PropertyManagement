package com.manager.servlet;

import com.entity.PageBean;
import com.manager.dao.BuildingDao;
import com.manager.dao.daoimpl.BuildingDaoImpl;
import com.manager.entity.Building;
import com.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
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
@WebServlet(name = "BuildingServlet",urlPatterns = "/BuildingServlet",initParams ={@WebInitParam(name="pageCount",value = "10")})
public class BuildingServlet extends HttpServlet {
    BuildingDao dao = new BuildingDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean =  new PageBean();
        // 页码
        String pageIndex = request.getParameter("pageIndex");
        if(!StringUtil.isEmpty(pageIndex)){
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 每页条数
        String pageCount = getInitParameter("pageCount");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        // 总条数
        pageBean.setCount(dao.getConut());
        // list数据
        List<Building> buildingList = dao.queryPageList(pageBean);
        request.setAttribute("buildingList",buildingList);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/manager/background/building/buildingList.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildingName = request.getParameter("buildingName");
        String staffId = request.getParameter("staffId");
        String areaId = request.getParameter("areaId");
        Building building = new Building(buildingName,Integer.parseInt(staffId),Integer.parseInt(areaId));
        int i = dao.addBuilding(building);

        response.getWriter().print(""+i);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildingId = request.getParameter("buildingId");
        String buildingName = request.getParameter("buildingName");
        String staffId = request.getParameter("staffId");
        String areaId = request.getParameter("areaId");
        Building building = new Building(Integer.parseInt(buildingId),buildingName,Integer.parseInt(staffId),Integer.parseInt(areaId));
        int i = dao.updateBuilding(building);
        response.getWriter().print(""+i);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        int buildingId=-1;
        if(!StringUtil.isEmpty(bid)){
            buildingId=Integer.parseInt(bid);
        }
        int  i = dao.deleteBuilding(buildingId);
        response.getWriter().print(""+i);
    }

    private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] id = ids.split(",");
        int sum=0;
        for (String buildingId:id) {
            int  i = dao.deleteBuilding(Integer.parseInt(buildingId));
            sum+=i;
        }
        response.getWriter().print(""+sum);
    }
    private void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        int buildingId=-1;
        if(!StringUtil.isEmpty(bid)){
            buildingId=Integer.parseInt(bid);
        }
        Building building = dao.queryOne(buildingId);

        request.setAttribute("building",building);
        System.out.println(building.toString());
        request.getRequestDispatcher("/manager/background/building/buildingUpdate.jsp").forward(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
