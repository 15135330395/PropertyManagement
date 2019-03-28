package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.logistics.entity.OperatingRecord;
import com.logistics.service.OperatingRecordService;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        String action = request.getParameter("action");
        if ("getAllRecord".equals(action)) {
            getAllRecord(request, response);
        } else if ("getAllRecordByPage".equals(action)) {
            getAllRecordByPage(request, response);
        } else if ("findRecordByRecordId".equals(action)) {
            findRecordByRecordId(request, response);
        } else if ("findRecordByStaffId".equals(action)) {
            findRecordByStaffId(request, response);
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
        int taskCount = service.getAllRecord().size();
        pageBean.setCount(taskCount);
        List<OperatingRecord> incidentList = service.getAllRecordByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(incidentList, pageBean);
        response.getWriter().print(table);
    }

    private void findRecordByRecordId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findRecordByStaffId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void editRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updateRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
