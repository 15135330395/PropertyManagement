package com.客户关系管理.dao;

import com.客户关系管理.entity.DecorateApply;
import com.客户关系管理.entity.PageBean;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public interface DecorateApplyDao {

    public List<DecorateApply> find(PageBean pageBean);

    public int updata(DecorateApply decorateApply);

}
