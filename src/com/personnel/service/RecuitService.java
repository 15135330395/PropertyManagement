package com.personnel.service;

import com.entity.PageBean;
import com.personnel.dao.RecuitDao;
import com.personnel.dao.impl.RrecuitDaoImpl;
import com.personnel.entity.Recuit;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-28 上午 10:15
 */
public class RecuitService {
    private  RecuitDao dao=new RrecuitDaoImpl();
    public List<Recuit> findAll(){return dao.findAll();}
    public List<Recuit> queryRecuitPage(PageBean pageBean){return dao.queryRecuitPage(pageBean);}
    public int addRecuit(Recuit recuit){return dao.addRecuit(recuit);}
    public int updateRecuit(Recuit recuit){return dao.updateRecuit(recuit);}
    public int deleteRecuit(int recuitId){return dao.deleteRecuit(recuitId);}
    public Recuit queryOne(int recuitId){return dao.queryOne(recuitId);}
}
