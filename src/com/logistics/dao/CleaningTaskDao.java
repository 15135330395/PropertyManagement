package com.logistics.dao;

import com.entity.PageBean;
import com.logistics.entity.CleaningTask;

import java.util.List;

/**
 * @Description CleaningTaskDao
 * @Author WYR
 * @CreateTime 2019-03-26 19:11
 */
public interface CleaningTaskDao {

    /**
     * 查询所有的保洁任务
     *
     * @return
     */
    List<CleaningTask> getAllTask();

    /**
     * 查询所有保洁任务的分页
     *
     * @param pageBean
     * @return
     */
    List<CleaningTask> getAllTaskByPage(PageBean pageBean);

    /**
     * 通过任务ID查找
     *
     * @param taskId
     * @return
     */
    CleaningTask findTaskByTaskId(int taskId);

    /**
     * 通过员工ID查找
     *
     * @param staffId
     * @return
     */
    List<CleaningTask> findTaskByStaffId(int staffId);

    /**
     * 添加保洁任务
     *
     * @param cleaningTask
     * @return
     */
    int addTask(CleaningTask cleaningTask);

    /**
     * 修改保洁任务
     *
     * @param cleaningTask
     * @return
     */
    int updateTask(CleaningTask cleaningTask);

    /**
     * 删除保洁任务
     *
     * @param taskId
     * @return
     */
    int deleteTask(int taskId);

    /**
     * 添加评分
     *
     * @param taskId
     * @param score
     * @return
     */
    int addScore(int taskId, int score);

    /**
     * 修改评分
     *
     * @param taskId
     * @param score
     * @return
     */
    int updateScore(int taskId, int score);

    /**
     * 删除评分
     *
     * @param taskId
     * @return
     */
    int deleteScore(int taskId);
}
