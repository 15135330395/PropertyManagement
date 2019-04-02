package com.system.dao;


import com.entity.PageBean;
import com.system.entity.Menu;
import org.apache.commons.dbutils.QueryRunner;


import com.entity.PageBean;
import com.system.entity.Menu;


import java.util.List;

/**
 * @Description MenuDao
 * @Author WYR
 * @CreateTime 2019-03-31 14:38
 */
public interface MenuDao {
    /**
     * 查询所有的权限菜单
     *
     * @return
     */
    List<Menu> getAllMenu();

    /**
     * 查询所有权限菜单的分页
     *
     * @return
     */
    List<Menu> getAllMenuByPage(PageBean pageBean);

    /**
     * 通过ID查询权限菜单
     * @param menuId
     * @return
     */
    Menu findMenuById(int menuId);
    /**
     * 添加菜单
     *
     * @param menu
     * @return
     */
    int addMenu(Menu menu);

    /**
     * 修改菜单
     *
     * @param menu
     * @return
     */
    int updateMenu(Menu menu);

    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     */
    int deleteMenu(int menuId);

    /**
     * 通过UserId查找权限菜单
     *
     * @param userId
     * @return
     */
    List<Menu> findMenuByUserId(int userId);

}
