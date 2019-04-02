package com.manager.servlet;

import com.manager.dao.AreaDao;
import com.manager.dao.BuildingDao;
import com.manager.dao.HouseDao;
import com.manager.dao.daoimpl.AreaDaoImpl;
import com.manager.dao.daoimpl.BuildingDaoImpl;
import com.manager.dao.daoimpl.HouseDaoImpl;
import com.manager.entity.Area;
import com.manager.entity.Building;
import com.manager.entity.House;
import com.manager.service.AreaService;
import com.manager.service.BuildingService;
import com.manager.service.HouseService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author haoyu
 * date ：2019/4/1
 */
@WebServlet(name = "InitServlet",urlPatterns = "/InitServlet",loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    private AreaService areaService = new AreaService();
    private BuildingService buildingService = new BuildingService();
    private HouseService houseService = new HouseService();
    @Override
    public void init() throws ServletException {
        ServletContext application = this.getServletContext();
        List<Area> areaList = areaService.findAll();
        application.setAttribute("areaList", areaList);
        List<Building> buildingList = buildingService.findAll();
        application.setAttribute("buildingList", buildingList);
        List<House> houseList = houseService.findAll();
        application.setAttribute("houseList", houseList);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        List<Area> areaList = areaService.findAll();
        application.setAttribute("areaList", areaList);
        List<Building> buildingList = buildingService.findAll();
        application.setAttribute("buildingList", buildingList);
        List<House> houseList = houseService.findAll();
        application.setAttribute("houseList", houseList);
        loginInfo(request,response);
        PrintWriter out = response.getWriter();

        response.sendRedirect(request.getContextPath()+"/manager/background/commons/backgroundIndex.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void loginInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        AreaDao areaDao=new AreaDaoImpl();
        BuildingDao buildingDao=new BuildingDaoImpl();
        HouseDao houseDao=new HouseDaoImpl();
        List<Area> areaList = areaDao.findAll();
        List<Building> buildingList = buildingDao.findAll();
        List<House> houseList = houseDao.findAll();

        session.setAttribute("areaListCount",areaList.size());
        session.setAttribute("buildingListCount",buildingList.size());
        session.setAttribute("houseListCount",houseList.size());
    }
}
