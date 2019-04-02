package com.system.service;

import com.entity.PageBean;
import com.system.dao.MenuDao;
import com.system.dao.impl.MenuDaoImpl;
import com.system.entity.Menu;

import java.util.List;

/**
 * @Description MenuService
 * @Author WYR
 * @CreateTime 2019-03-31 14:38
 */
public class MenuService {
    private MenuDao dao = new MenuDaoImpl();

    public List<Menu> getAllMenu() {
        return dao.getAllMenu();
    }

    public List<Menu> getAllMenuByPage(PageBean pageBean) {
        return dao.getAllMenuByPage(pageBean);
    }

    public Menu findMenuById(int menuId) {
        return dao.findMenuById(menuId);
    }

    public int addMenu(Menu menu) {
        return dao.addMenu(menu);
    }


    public int updateMenu(Menu menu) {
        return dao.updateMenu(menu);
    }

    public int deleteMenu(int menuId) {
        return dao.deleteMenu(menuId);
    }


    public List<Menu> findMenuByUserId(int userId) {
        return dao.findMenuByUserId(userId);
    }
}
