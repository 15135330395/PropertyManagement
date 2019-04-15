package com.hibernate.service;/*
 * @author :张
 * Date  : 2019/4/12
 * @Description: UserService
 */

import com.hibernate.dao.UserDao;
import com.hibernate.entity.User;

import java.util.List;

public class UserService {

    UserDao dao=new UserDao();
    public List<User> queryPage(int pageIndex, int pageCount){
        return dao.queryPage(pageIndex,pageCount);
    }
    public User queryOne(int id){
        return dao.queryOneById(id);
    }
   /* public void update(User user){
        return dao.updateById(user);
    }*/

}
