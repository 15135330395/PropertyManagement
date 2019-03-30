package com.personnel.service;

import com.entity.PageBean;
import com.personnel.dao.InterviewDao;
import com.personnel.dao.impl.InterviewDaoImpl;
import com.personnel.entity.Interview;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/29
 */
public class InterviewService {
    private InterviewDao dao=new InterviewDaoImpl();
    public List<Interview> findAll(){return dao.findAll();}
    public List<Interview> queryPage(PageBean pageBean){return dao.queryPage(pageBean);}
    public int addInterview(Interview interview){return  dao.addInterview(interview);}
    public int updateInterview(Interview interview){return dao.updateInterview(interview);}
    public int deleteInterview(int interviewId){return dao.deleteInterview(interviewId);}
    public Interview queryOne(int interviewId){return dao.queryOne(interviewId);}

    public int addOffer(int interviewId) {
        return dao.addOffer(interviewId);
    }
}
