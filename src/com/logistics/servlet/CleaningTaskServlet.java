package com.logistics.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.logistics.entity.Cleaner;
import com.logistics.entity.CleaningTask;
import com.logistics.service.CleanerService;
import com.logistics.service.CleaningTaskService;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description CleaningTaskServlet
 * @Author WYR
 * @CreateTime 2019-03-27 17:04
 */
@WebServlet(name = "CleaningTaskServlet", urlPatterns = "/CleaningTaskServlet")
public class CleaningTaskServlet extends HttpServlet {
    private CleaningTaskService service = new CleaningTaskService();
    private CleanerService cleanerService = new CleanerService();

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
        } else if ("toAddTask".equals(action)) {
            toAddTask(request, response);
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
        } else if ("addCompletion".equals(action)) {
            addCompletion(request, response);
        } else if ("toAddScore".equals(action)) {
            toAddScore(request, response);
        } else if ("addScore".equals(action)) {
            addScore(request, response);
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

    private void toAddTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cleaner> cleanerList = cleanerService.getAllCleaner();
        request.setAttribute("cleanerList", cleanerList);
        request.getRequestDispatcher("/logistics/CleaningTask/AddCleaningTask.jsp").forward(request, response);
    }

    private void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        String taskType = request.getParameter("taskType");
        String taskTime = request.getParameter("taskTime");
        String taskArea = request.getParameter("taskArea");
        CleaningTask cleaningTask = new CleaningTask(taskType, taskTime, taskArea, Integer.parseInt(staffId));
        int i = service.addTask(cleaningTask);
        response.getWriter().print(i);
    }

    private void editTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        CleaningTask task = service.findTaskByTaskId(Integer.parseInt(taskId));
        request.setAttribute("task", task);

        List<Cleaner> cleanerList = cleanerService.getAllCleaner();
        request.setAttribute("cleanerList", cleanerList);
        request.getRequestDispatcher("/logistics/CleaningTask/EditCleaningTask.jsp").forward(request, response);
    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        String taskType = request.getParameter("taskType");
        String taskTime = request.getParameter("taskTime");
        String taskArea = request.getParameter("taskArea");
        String staffId = request.getParameter("staffId");
        // 通过name查询id
        CleaningTask cleaningTask = new CleaningTask(Integer.parseInt(taskId), taskType, taskTime, taskArea, Integer.parseInt(staffId));
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

    private void addCompletion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        int i = service.addCompletion(Integer.parseInt(taskId));
        response.getWriter().print(i);
    }

    private void toAddScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        CleaningTask task = service.findTaskByTaskId(Integer.parseInt(taskId));
        request.setAttribute("task", task);
        request.getRequestDispatcher("/logistics/Manager/addScore.jsp").forward(request, response);
    }

    private void addScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        String score = request.getParameter("score");
        int i = service.addScore(Integer.parseInt(taskId), Integer.parseInt(score));
        response.getWriter().print(i);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
