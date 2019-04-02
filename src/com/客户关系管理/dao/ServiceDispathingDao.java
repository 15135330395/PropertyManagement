package com.客户关系管理.dao;
import com.客户关系管理.entity.PageBean;
import com.客户关系管理.entity.ServiceDispathing;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public interface ServiceDispathingDao {

    public ServiceDispathing find(int id);
    public int updata(ServiceDispathing serviceDispathing);
    public int add(String name,String addr,String feedback,String cphone);
    public List<ServiceDispathing> findAll();
    public List<ServiceDispathing> queryAll(PageBean pageBean);
    public List<ServiceDispathing> findByName(String name);
}
