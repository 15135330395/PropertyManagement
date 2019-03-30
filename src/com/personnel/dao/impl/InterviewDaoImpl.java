package com.personnel.dao.impl;

import com.entity.PageBean;
import com.personnel.dao.InterviewDao;
import com.personnel.entity.Interview;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public class InterviewDaoImpl implements InterviewDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<Interview> findAll() {
        String sql="select *from interview order by interview_id";
        try {
            List<Interview> interviewList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Interview.class));
            return  interviewList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Interview> queryPage(PageBean pageBean) {
        String sql="select *from interview order by interview_id limit ?,?";
        try {
            List<Interview> interviewList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Interview.class), pageBean.getIndex(), pageBean.getPageCount());
            return interviewList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addInterview(Interview interview) {
        String sql="insert into interview (apply_name,apply_position,department_name,interviewer) " +
                "values(?,?,?,?)";
        Object[] objs={interview.getApplyName(),interview.getApplyPosition(),interview.getDepartmentName(),interview.getInterviewer()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateInterview(Interview interview) {
        String sql="update interview set apply_name=?,apply_position=?,department_name=?,interviewer=?,offer=? " +
                "where interview_id=?";
        Object[] objs={interview.getApplyName(),interview.getApplyPosition(),interview.getDepartmentName(),interview.getInterviewer()
                ,interview.isOffer(),interview.getInterviewId()};
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteInterview(int interviewId) {
        String sql="delete from interview  where interview_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, interviewId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Interview queryOne(int interviewId) {
        String sql="select * from interview  where interview_id=?";
        try {
            Interview interview = qr.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Interview.class), interviewId);
            return interview;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addOffer(int interviewId) {
        String sql="update interview set offer=1 where interview_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, interviewId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
