package com.logistics.dao.impl;

import com.entity.PageBean;
import com.logistics.dao.CleaningTaskDao;
import com.logistics.entity.CleaningTask;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description CleaningTaskDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-26 22:58
 */
public class CleaningTaskDaoImpl implements CleaningTaskDao {

    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public CleaningTask findTaskByTaskId(int taskId) {
        String sql = "select * from cleaning_task where task_id = ?";
        try {
            CleaningTask query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(CleaningTask.class), taskId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<CleaningTask> findTaskByStaffId(int staffId) {
        String sql = "select * from cleaning_task where staff_id = ?";
        try {
            List<CleaningTask> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CleaningTask.class), staffId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<CleaningTask> getAllTask() {
        String sql = "select * from cleaning_task";
        try {
            List<CleaningTask> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CleaningTask.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public List<CleaningTask> getAllTaskByPage(PageBean pageBean) {
        String sql = "select * from cleaning_task limit ? ,?";
        try {
            List<CleaningTask> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(CleaningTask.class), pageBean.getIndex(), pageBean.getPageCount());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public int addTask(CleaningTask cleaningTask) {
        /*
        String sql = "insert into cleaning_task () values ()";
        Object[] obj = {cleaningTask.getTaskId()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        */
        return 0;
    }

    @Override
    public int updateTask(CleaningTask cleaningTask) {
        /*
        String sql = "update cleaning_task set    where task_id = ?";
        Object[] obj = {cleaningTask.getTaskId()};
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        */
        return 0;
    }

    @Override
    public int deleteTask(int taskId) {
        String sql = "delete from cleaning_task where task_id = ?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, taskId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return 0;
    }
}
