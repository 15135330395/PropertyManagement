package com.logistics.servlet;

import com.logistics.service.GuardRotaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description GuardRotaServlet
 * @Author WYR
 * @CreateTime 2019-03-27 21:21
 */
@WebServlet(name = "GuardRotaServlet", urlPatterns = "/GuardRotaServlet")
public class GuardRotaServlet extends HttpServlet {
    private GuardRotaService service = new GuardRotaService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("getAllRota".equals(action)) {
            getAllRota(request, response);
        } else if ("getAllRotaByPage".equals(action)) {
            getAllRotaByPage(request, response);
        } else if ("findRotaByRotaId".equals(action)) {
            findRotaByRotaId(request, response);
        } else if ("findRotaByStaffId".equals(action)) {
            findRotaByStaffId(request, response);
        } else if ("addRota".equals(action)) {
            addRota(request, response);
        } else if ("updateRota".equals(action)) {
            updateRota(request, response);
        } else if ("deleteRota".equals(action)) {
            deleteRota(request, response);
        } else if ("deleteRotas".equals(action)) {
            deleteRotas(request, response);
        } else if ("clockIn".equals(action)) {
            clockIn(request, response);
        } else if ("clockOut".equals(action)) {
            clockOut(request, response);
        }
    }

    private void getAllRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAllRotaByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findRotaByRotaId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findRotaByStaffId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updateRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteRotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void clockIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void clockOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
