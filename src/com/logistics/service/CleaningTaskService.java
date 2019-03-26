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

    public CleaningTask findTaskByTaskId(int taskId) {
        return dao.findTaskByTaskId(taskId);
    }

    public List<CleaningTask> findTaskByStaffId(int staffId) {
        return dao.findTaskByStaffId(staffId);
    }

    public List<CleaningTask> getAllTask() {
        return dao.getAllTask();
    }

    public List<CleaningTask> getAllTaskByPage(PageBean pageBean) {
        return dao.getAllTaskByPage(pageBean);
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

    public int deleteTasks(int... taskIds) {
        int sum = 0;
        for (int i = 0; i < taskIds.length; i++) {
            sum += dao.deleteTask(taskIds[i]);
        }
        return sum;
    }
}
