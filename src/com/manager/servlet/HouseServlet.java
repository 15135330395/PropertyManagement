package com.manager.servlet;

import com.entity.PageBean;
import com.manager.dao.HouseDao;
import com.manager.dao.daoimpl.HouseDaoImpl;
import com.manager.entity.House;
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
@WebServlet(name = "HouseServlet",urlPatterns = "/HouseServlet",initParams ={@WebInitParam(name="pageCount",value = "10")})
public class HouseServlet extends HttpServlet {
    HouseDao dao = new HouseDaoImpl();
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
        List<House> houseList = dao.queryPageList(pageBean);

        request.setAttribute("houseList",houseList);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/manager/background/house/houseList.jsp").forward(request,response);

    }
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId = request.getParameter("houseId");
        String buildingId = request.getParameter("buildingId");
        String acreage = request.getParameter("acreage");
        String use = request.getParameter("use");
        String houseType = request.getParameter("houseType");

        House house = new House(Integer.parseInt(houseId),Integer.parseInt(buildingId),acreage,use,houseType);
        int i = dao.addHouse(house);

        response.getWriter().print(""+i);

    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId = request.getParameter("houseId");
        String buildingId = request.getParameter("buildingId");
        String acreage = request.getParameter("acreage");
        String use = request.getParameter("use");
        String houseType = request.getParameter("houseType");
        House house = new House(Integer.parseInt(houseId),Integer.parseInt(buildingId),acreage,use,houseType);
        int i = dao.updateHouse(house);
        response.getWriter().print(""+i);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hid = request.getParameter("hid");
        int houseId=-1;
        if(!StringUtil.isEmpty(hid)){
            houseId=Integer.parseInt(hid);
        }
        int  i = dao.deleteHouse(houseId);
        response.getWriter().print(""+i);
    }
    private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String[] id = ids.split(",");
        int sum=0;
        for (String houseId:id) {
            int  i = dao.deleteHouse(Integer.parseInt(houseId));
            sum+=i;
        }
        response.getWriter().print(""+sum);
    }
    private void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hid = request.getParameter("hid");
        int houseId=-1;
        if(!StringUtil.isEmpty(hid)){
            houseId=Integer.parseInt(hid);
        }
        House house = dao.queryOne(houseId);

        request.setAttribute("house",house);
        request.getRequestDispatcher("/manager/background/house/houseupdate.jsp").forward(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
