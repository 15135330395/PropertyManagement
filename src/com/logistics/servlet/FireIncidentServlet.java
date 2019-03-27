package com.logistics.servlet;

import com.logistics.service.FireIncidentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description FireIncidentServlet
 * @Author WYR
 * @CreateTime 2019-03-27 21:21
 */
@WebServlet(name = "FireIncidentServlet", urlPatterns = "/FireIncidentServlet")
public class FireIncidentServlet extends HttpServlet {
    private FireIncidentService service = new FireIncidentService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("getAllIncident".equals(action)) {
            getAllIncident(request, response);
        } else if ("getAllIncidentByPage".equals(action)) {
            getAllIncidentByPage(request, response);
        } else if ("findIncidentById".equals(action)) {
            findIncidentById(request, response);
        } else if ("addIncident".equals(action)) {
            addIncident(request, response);
        } else if ("updateIncident".equals(action)) {
            updateIncident(request, response);
        } else if ("deleteIncident".equals(action)) {
            deleteIncident(request, response);
        } else if ("deleteIncidents".equals(action)) {
            deleteIncidents(request, response);
        }
    }

    private void getAllIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAllIncidentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findIncidentById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updateIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteIncident(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteIncidents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
