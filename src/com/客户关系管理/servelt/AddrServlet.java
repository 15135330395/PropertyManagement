package com.客户关系管理.servelt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.客户关系管理.entity.Area;
import com.客户关系管理.entity.Building;
import com.客户关系管理.entity.House;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-04-01；
 */

@WebServlet(name = "AddrServlet",urlPatterns = "/AddrServlet")
public class AddrServlet extends HttpServlet {

    QueryRunner qr = new QueryRunner();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("queryHouse".equals(action)){
            queryHouse(request,response);
        }else if("queryBuild".equals(action)){
            queryBuild(request,response);
        }else if("RqueryArea".equals(action)){
            RqueryArea(request,response);
        }else{
            queryArea(request,response);
        }
    }

    private void queryHouse(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String hid = request.getParameter("hid");
        String sql = "select * from house where building_id = ?";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            List<House> houseList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(House.class), hid);
            JSONArray jsonArray = new JSONArray();
            for(int i = 0;i < houseList.size();i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("building_id",houseList.get(i).getBuilding_id());
                jsonObject.put("house_id",houseList.get(i).getHouse_id());
                jsonArray.add(jsonObject);
            }
            response.getWriter().print(jsonArray);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private void queryBuild(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String areaid = request.getParameter("bid");
        String sql = " select * from building where area_id = ?";
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            List<Building> buildingListlist = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Building.class), areaid);
            JSONArray jsonArray = new JSONArray();
            for(int i = 0;i < buildingListlist.size();i++){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("building_id",buildingListlist.get(i).getBuilding_id());
                jsonObject.put("building_name",buildingListlist.get(i).getBuilding_name());
                jsonArray.add(jsonObject);
            }
            response.getWriter().print(jsonArray);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private void queryArea(HttpServletRequest request, HttpServletResponse response) {

        String sql = " select * from area ";

        try {
            List<Area> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Area.class));

            request.setAttribute("lsit",list);
            request.getRequestDispatcher(request.getContextPath()+"/crm/customerManagement/CustomerDataAdd.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void RqueryArea(HttpServletRequest request, HttpServletResponse response) {

        String sql = " select * from area ";

        try {
            List<Area> list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Area.class));

            request.setAttribute("lsit",list);
            request.getRequestDispatcher(request.getContextPath()+"/crm/customerManagement/JoinRegistrationDataAdd.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
