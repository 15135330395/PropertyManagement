package com.shouFei.dao;

import com.shouFei.entity.Rule;
import com.entity.PageBean;


import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/1;
 */
public interface RuleDao {
    public List<Rule> findAll();
    public List<Rule> queryByPage(PageBean pageBean);
    public int deleteRule(int id);
    public int updateRule(Rule rule);
    public Rule findRuleById(int id);
    public int addRule(Rule rule);

}
