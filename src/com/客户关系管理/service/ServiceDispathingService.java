package com.客户关系管理.service;


import com.客户关系管理.dao.impl.ServiceDispathingDaoImpl;
import com.客户关系管理.entity.PageBean;
import com.客户关系管理.entity.ServiceDispathing;

import java.util.List;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public class ServiceDispathingService {

    ServiceDispathingDaoImpl dao = new ServiceDispathingDaoImpl();

    public ServiceDispathing find(int id){

        ServiceDispathing serviceDispathing = dao.find(id);
        return serviceDispathing;
    }

    public int updata(ServiceDispathing serviceDispathing){

        int i = dao.updata(serviceDispathing);
        return i;
    }

    public int add(String name,String addr,String feedback,String cphone){

        int i = dao.add(name,addr,feedback,cphone);
        return i;
    }

    public List<ServiceDispathing> findAll(){

        List<ServiceDispathing> list = dao.findAll();
        return list;
    }

    public List<ServiceDispathing> queryAll(PageBean pageBean) {

        List<ServiceDispathing> serviceDispathings = dao.queryAll(pageBean);

        return serviceDispathings;
    }

    public List<ServiceDispathing> findByName(String name) {

        List<ServiceDispathing> dispathingList = dao.findByName(name);
        return dispathingList;
    }
}
