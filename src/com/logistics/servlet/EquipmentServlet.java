package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.Equipment;
import com.entity.PageBean;
import com.logistics.entity.FireFightingEquipment;
import com.logistics.entity.SecurityGuardEquipment;
import com.logistics.service.EquipmentService;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description EquipmentServlet
 * @Author WYR
 * @CreateTime 2019-03-30 22:20
 */
@WebServlet(name = "EquipmentServlet", urlPatterns = "/EquipmentServlet")
public class EquipmentServlet extends HttpServlet {
    private EquipmentService service = new EquipmentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllFireFightingEquipmentByPage".equals(action)) {
            getAllFireFightingEquipmentByPage(request, response);
        } else if ("getAllSecurityGuardEquipmentByPage".equals(action)) {
            getAllSecurityGuardEquipmentByPage(request, response);
        } else if ("findEquipmentById".equals(action)) {
            findEquipmentById(request, response);
        } else if ("addFireFightingEquipment".equals(action)) {
            addFireFightingEquipment(request, response);
        } else if ("addSecurityEquipment".equals(action)) {
            addSecurityEquipment(request, response);
        } else if ("editEquipment".equals(action)) {
            editEquipment(request, response);
        } else if ("updateEquipment".equals(action)) {
            updateEquipment(request, response);
        } else if ("deleteEquipment".equals(action)) {
            deleteEquipment(request, response);
        } else if ("deleteEquipments".equals(action)) {
            deleteEquipments(request, response);
        }
    }

    private void getAllFireFightingEquipmentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        // 页码
        String pageIndex = request.getParameter("page");
        if (pageIndex != null) {
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 每页条数
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        // 总条数
        int equipmentCount = service.getAllFireFightingEquipment().size();
        pageBean.setCount(equipmentCount);
        List<FireFightingEquipment> equipmentList = service.getAllFireFightingEquipmentByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(equipmentList, pageBean);
        response.getWriter().print(table);

    }

    private void getAllSecurityGuardEquipmentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        // 页码
        String pageIndex = request.getParameter("page");
        if (pageIndex != null) {
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 每页条数
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        // 总条数
        int incidentCount = service.getAllSecurityGuardEquipment().size();
        pageBean.setCount(incidentCount);
        List<SecurityGuardEquipment> equipmentList = service.getAllSecurityGuardEquipmentByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(equipmentList, pageBean);
        response.getWriter().print(table);
    }

    private void findEquipmentById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentId = request.getParameter("equipmentId");
        Equipment equipment = service.findEquipmentById(Integer.parseInt(equipmentId));
        request.setAttribute("equipment", equipment);
        request.getRequestDispatcher("/logistics/Equipment/EquipmentById.jsp").forward(request, response);
    }

    private void addFireFightingEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentName = request.getParameter("equipmentName");
        String amount = request.getParameter("amount");
        FireFightingEquipment fireFightingEquipment = new FireFightingEquipment(equipmentName, amount);
        int i = service.addFireFightingEquipment(fireFightingEquipment);
        response.getWriter().print(i);
    }

    private void addSecurityEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentName = request.getParameter("equipmentName");
        String amount = request.getParameter("amount");
        SecurityGuardEquipment securityGuardEquipment = new SecurityGuardEquipment(equipmentName, amount);
        int i = service.addSecurityGuardEquipment(securityGuardEquipment);
        response.getWriter().print(i);
    }

    private void editEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentId = request.getParameter("equipmentId");
        Equipment equipment = service.findEquipmentById(Integer.parseInt(equipmentId));
        request.setAttribute("equipment", equipment);
        request.getRequestDispatcher("/logistics/Equipment/EditEquipment.jsp").forward(request, response);
    }

    private void updateEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentId = request.getParameter("equipmentId");
        String equipmentName = request.getParameter("equipmentName");
        String amount = request.getParameter("amount");
        Equipment equipment = new Equipment(Integer.parseInt(equipmentId),equipmentName, amount);
        int i = service.updateEquipment(equipment);
        response.getWriter().print(i);
    }

    private void deleteEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentId = request.getParameter("equipmentId");
        int i = service.deleteEquipment(Integer.parseInt(equipmentId));
        response.getWriter().print(i);
    }

    private void deleteEquipments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("equipmentIds");
        String[] equipmentIds = ids.split(",");
        int sum = 0;
        for (int i = 0; i < equipmentIds.length; i++) {
            sum += service.deleteEquipment(Integer.parseInt(equipmentIds[i]));
        }
        response.getWriter().print(sum);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
