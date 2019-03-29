package com.logistics.entity;

import java.util.Date;

/**
 * @Description 清洁绿化工作的任务及执行程度
 * @Author WYR
 * @CreateTime 2019-03-26 10:41
 */
public class CleaningTask {
    private int taskId;
    private String taskType;
    private String taskTime;
    private String taskArea;
    private int staffId;
    private String staffName;
    private boolean completion = false;
    private int score;

    public CleaningTask() {
    }

    public CleaningTask(String taskType, String taskTime, String taskArea, int staffId) {
        this.taskType = taskType;
        this.taskTime = taskTime;
        this.taskArea = taskArea;
        this.staffId = staffId;
    }

    public CleaningTask(int taskId, String taskType, String taskTime, String taskArea, int staffId) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskTime = taskTime;
        this.taskArea = taskArea;
        this.staffId = staffId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTask_id(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTask_type(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTask_time(String taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskArea() {
        return taskArea;
    }

    public void setTask_area(String taskArea) {
        this.taskArea = taskArea;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaff_id(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaff_name(String staffName) {
        this.staffName = staffName;
    }

    public boolean isCompletion() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
