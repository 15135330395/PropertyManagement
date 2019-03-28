package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.logistics.entity.CleaningTask;
import com.logistics.service.CleaningTaskService;
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
 * @Description CleaningTaskServlet
 * @Author WYR
 * @CreateTime 2019-03-27 17:04
 */
@WebServlet(name = "CleaningTaskServlet", urlPatterns = "/CleaningTaskServlet")
public class CleaningTaskServlet extends HttpServlet {
    private CleaningTaskService service = new CleaningTaskService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
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
        } else if ("editTask".equals(action)) {
            editTask(request, response);
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
        int taskCount = service.getAllTask().size();
        pageBean.setCount(taskCount);
        List<CleaningTask> taskList = service.getAllTaskByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(taskList, pageBean);
        response.getWriter().print(table);
    }

    private void findTaskByTaskId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        CleaningTask task = service.findTaskByTaskId(Integer.parseInt(taskId));
        request.setAttribute("task", task);
        request.getRequestDispatcher("/logistics/CleaningTask/CleaningTaskByTaskId.jsp").forward(request, response);
    }

    private void findTaskByStaffId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskType = request.getParameter("taskType");
        String taskTime = request.getParameter("taskTime");
        String taskArea = request.getParameter("taskArea");
        String staffName = request.getParameter("staffName");

        CleaningTask cleaningTask = new CleaningTask(taskType, taskTime, taskArea, Integer.parseInt("4"));
        int i = service.addTask(cleaningTask);
        response.getWriter().print(i);
    }

    private void editTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        CleaningTask task = service.findTaskByTaskId(Integer.parseInt(taskId));
        request.setAttribute("task", task);
        request.getRequestDispatcher("/logistics/CleaningTask/EditCleaningTask.jsp").forward(request, response);
    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        String taskType = request.getParameter("taskType");
        String taskTime = request.getParameter("taskTime");
        String taskArea = request.getParameter("taskArea");
        String staffName = request.getParameter("staffName");
        // 通过name查询id
        CleaningTask cleaningTask = new CleaningTask(Integer.parseInt(taskId), taskType, taskTime, taskArea, Integer.parseInt("4"));
        int i = service.updateTask(cleaningTask);
        response.getWriter().print(i);
    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        int i = service.deleteTask(Integer.parseInt(taskId));
        response.getWriter().print(i);
    }

    private void deleteTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("taskIds");
        String[] taskIds = ids.split(",");
        int sum = 0;
        for (int i = 0; i < taskIds.length; i++) {
            sum += service.deleteTask(Integer.parseInt(taskIds[i]));
        }
        response.getWriter().print(sum);
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
