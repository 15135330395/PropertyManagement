package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.logistics.entity.OperatingRecord;
import com.logistics.service.OperatingRecordService;
import com.utils.DateUtil;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description OperatingRecordServlet
 * @Author WYR
 * @CreateTime 2019-03-27 21:21
 */
@WebServlet(name = "OperatingRecordServlet", urlPatterns = "/OperatingRecordServlet")
public class OperatingRecordServlet extends HttpServlet {

    private OperatingRecordService service = new OperatingRecordService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllRecord".equals(action)) {
            getAllRecord(request, response);
        } else if ("getAllRecordByPage".equals(action)) {
            getAllRecordByPage(request, response);
        } else if ("findRecordById".equals(action)) {
            findRecordById(request, response);
        } else if ("addRecord".equals(action)) {
            addRecord(request, response);
        } else if ("editRecord".equals(action)) {
            editRecord(request, response);
        } else if ("updateRecord".equals(action)) {
            updateRecord(request, response);
        } else if ("deleteRecord".equals(action)) {
            deleteRecord(request, response);
        } else if ("deleteRecords".equals(action)) {
            deleteRecords(request, response);
        } else if ("returnEquipment".equals(action)) {
            returnEquipment(request, response);
        }
    }

    private void getAllRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAllRecordByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        int recordCount = service.getAllRecord().size();
        pageBean.setCount(recordCount);
        List<OperatingRecord> incidentList = service.getAllRecordByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(incidentList, pageBean);
        response.getWriter().print(table);
    }

    private void findRecordById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("recordId");
        OperatingRecord record = service.findRecordById(Integer.parseInt(recordId));
        request.setAttribute("record", record);
        request.getRequestDispatcher("/logistics/OperatingRecord/OperatingRecordById.jsp").forward(request, response);
    }

    private void addRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffName = request.getParameter("staffName");
        String equipmentName = request.getParameter("equipmentName");
        String borrowingTimeStr = request.getParameter("borrowingTime");
        Date borrowingTime = DateUtil.formatString(borrowingTimeStr, "yyyy-MM-dd HH:mm:ss");
        OperatingRecord operatingRecord = new OperatingRecord(staffName, equipmentName, borrowingTime);
        int i = service.addRecord(operatingRecord);
        response.getWriter().print(i);
    }

    private void editRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("recordId");
        OperatingRecord record = service.findRecordById(Integer.parseInt(recordId));
        request.setAttribute("record", record);
        request.getRequestDispatcher("/logistics/OperatingRecord/EditOperatingRecord.jsp").forward(request, response);
    }

    private void updateRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("recordId");
        String staffName = request.getParameter("staffName");
        String equipmentName = request.getParameter("equipmentName");
        String borrowingTimeStr = request.getParameter("borrowingTime");
        Date borrowingTime = DateUtil.formatString(borrowingTimeStr, "yyyy-MM-dd HH:mm:ss");
        OperatingRecord operatingRecord = new OperatingRecord(Integer.parseInt(recordId), staffName, equipmentName, borrowingTime);
        int i = service.updateRecord(operatingRecord);
        response.getWriter().print(i);
    }

    private void deleteRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("recordId");
        int i = service.deleteRecord(Integer.parseInt(recordId));
        response.getWriter().print(i);
    }

    private void deleteRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("recordIds");
        String[] recordIds = ids.split(",");
        int sum = 0;
        for (int i = 0; i < recordIds.length; i++) {
            sum += service.deleteRecord(Integer.parseInt(recordIds[i]));
        }
        response.getWriter().print(sum);
    }

    private void returnEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("recordId");
        int i = service.returnEquipment(Integer.parseInt(recordId));
        response.getWriter().print(i);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
