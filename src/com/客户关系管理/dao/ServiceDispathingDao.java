package com.客户关系管理.dao;

import com.客户关系管理.entity.ServiceDispathing;

/**
 * @author：Ganlan；
 * @date：2019-03-26；
 */


public interface ServiceDispathingDao {

    public ServiceDispathing find(int id);
    public int updata(ServiceDispathing serviceDispathing);
    public int add(ServiceDispathing serviceDispathing);

}
