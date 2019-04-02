package shouFei.service;

import shouFei.dao.RuleDao;
import shouFei.dao.daoImpl.RuleDaoImpl;
import shouFei.entity.PageBean;
import shouFei.entity.Rule;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/1;
 */
public class RuleService {
    RuleDao dao=new RuleDaoImpl();
    public List<Rule> findAll(){
        return dao.findAll();
    }
    public List<Rule> queryByPage(PageBean pageBean){
        return dao.queryByPage(pageBean);
    }
    public int deleteRule(int id){
        return dao.deleteRule(id);
    }
    public int updateRule(Rule rule){
        return dao.updateRule(rule);
    }
    public Rule findRuleById(int id){
        return dao.findRuleById(id);
    }
    public int addRule(Rule rule){
        return dao.addRule(rule);
    }
}
