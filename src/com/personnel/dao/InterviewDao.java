package com.personnel.dao;

import com.entity.PageBean;
import com.personnel.entity.Interview;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/28
 */
public interface InterviewDao {
    public List<Interview> findAll();
    public List<Interview> queryPage(PageBean pageBean);
    public int addInterview(Interview interview);
    public int updateInterview(Interview interview);
    public int deleteInterview(int interviewId);
    public Interview queryOne(int interviewId);
}
