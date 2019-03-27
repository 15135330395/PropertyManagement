package com.logistics.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description CleaningTaskServlet
 * @Author WYR
 * @CreateTime 2019-03-27 17:04
 */
@WebServlet(name = "CleaningTaskServlet", urlPatterns = "/CleaningTaskServlet")
public class CleaningTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("getAllTask".equals(action)) {
            getAllTask(request, response);
        } else if ("getAllTaskByPage".equals(action)) {
            getAllTaskByPage(request, response);
        } else if ("findTaskByTaskId".equals(action)) {
            findTaskByTaskId(request, response);
        } else if ("findTaskByStaffId".equals(action)) {
            findTaskByStaffId(request, response);
        } else if ("addTask".equals(action)) {
            addTask(request, response);
        } else if ("updateTask".equals(action)) {
            updateTask(request, response);
        } else if ("deleteTask".equals(action)) {
            deleteTask(request, response);
        } else if ("deleteTasks".equals(action)) {
            deleteTasks(request, response);
        } else if ("addScore".equals(action)) {
            addScore(request, response);
        } else if ("updateScore".equals(action)) {
            updateScore(request, response);
        } else if ("deleteScore".equals(action)) {
            deleteScore(request, response);
        }
    }

    private void getAllTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAllTaskByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findTaskByTaskId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findTaskByStaffId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void updateScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void deleteScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
