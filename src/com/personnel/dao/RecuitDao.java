package com.personnel.dao;

import com.entity.PageBean;
import com.personnel.entity.Recuit;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-28 上午 9:58
 */
public interface RecuitDao {
    public List<Recuit> findAll();
    public List<Recuit> queryRecuitPage(PageBean pageBean);
    public int addRecuit(Recuit recuit);
    public int updateRecuit(Recuit recuit);
    public int deleteRecuit(int recuitId);
    public Recuit queryOne(int recuitId);
}
