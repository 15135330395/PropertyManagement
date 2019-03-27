package com.logistics.service;

import com.entity.PageBean;
import com.logistics.dao.CleaningTaskDao;
import com.logistics.dao.impl.CleaningTaskDaoImpl;
import com.logistics.entity.CleaningTask;

import java.util.List;

/**
 * @Description CleaningTaskService
 * @Author WYR
 * @CreateTime 2019-03-26 23:44
 */
public class CleaningTaskService {
    private CleaningTaskDao dao = new CleaningTaskDaoImpl();

    public List<CleaningTask> getAllTask() {
        return dao.getAllTask();
    }

    public List<CleaningTask> getAllTaskByPage(PageBean pageBean) {
        return dao.getAllTaskByPage(pageBean);
    }

    public CleaningTask findTaskByTaskId(int taskId) {
        return dao.findTaskByTaskId(taskId);
    }

    public List<CleaningTask> findTaskByStaffId(int staffId) {
        return dao.findTaskByStaffId(staffId);
    }

    public int addTask(CleaningTask cleaningTask) {
        return dao.addTask(cleaningTask);
    }

    public int updateTask(CleaningTask cleaningTask) {
        return dao.updateTask(cleaningTask);
    }

    public int deleteTask(int taskId) {
        return dao.deleteTask(taskId);
    }

    public int addScore(int taskId, int score) {
        return dao.addScore(taskId, score);
    }

    public int updateScore(int taskId, int score) {
        return dao.updateScore(taskId, score);
    }

    public int deleteScore(int taskId) {
        return dao.deleteScore(taskId);
    }

}
