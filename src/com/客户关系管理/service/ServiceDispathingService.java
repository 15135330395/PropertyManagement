package com.客户关系管理.service;

import com.客户关系管理.dao.impl.ServiceDispathingDaoImpl;
import com.客户关系管理.entity.ServiceDispathing;

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

    public int add(ServiceDispathing serviceDispathing){

        int i = dao.add(serviceDispathing);
        return i;
    }

}
