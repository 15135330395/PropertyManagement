package com.logistics.servlet;

import com.logistics.service.OperatingRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    }

    private void findRecordByRecordId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findRecordByStaffId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updateRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void returnEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
