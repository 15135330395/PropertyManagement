package com.客户关系管理.service;

import com.客户关系管理.dao.impl.DecorateApplyDaoImpl;
import com.客户关系管理.entity.DecorateApply;
import com.客户关系管理.entity.PageBean;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public class DecorateApplyService {


    DecorateApplyDaoImpl dao = new DecorateApplyDaoImpl();

    public List<DecorateApply> find(PageBean pageBean){

        List<DecorateApply> decorateApplies = dao.find(pageBean);
        return decorateApplies;
    }

    public int updata(DecorateApply decorateApply){

        int i = dao.updata(decorateApply);
        return i;
    }

}
