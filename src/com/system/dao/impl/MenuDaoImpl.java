package com.system.dao.impl;

import com.entity.PageBean;
import com.system.dao.MenuDao;
import com.system.entity.Menu;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description MenuDaoImpl
 * @Author WYR
 * @CreateTime 2019-03-31 15:14
 */
public class MenuDaoImpl implements MenuDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Menu> getAllMenu() {
        String sql = "select * from xtgl_menu";
        try {
            List<Menu> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Menu.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Menu> getAllMenuByPage(PageBean pageBean) {
        String sql = "select * from xtgl_menu limit ?,?";
        try {
            List<Menu> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Menu.class), pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Menu findMenuById(int menuId) {
        String sql = "select * from xtgl_menu where menu_id=?";
        try {
            Menu menu = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Menu.class), menuId);
            return menu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addMenu(Menu menu) {
        String sql = "insert into xtgl_menu (menu_name,img,url,parent_id) values (?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menu.getMenuName(), menu.getImg(), menu.getUrl(), menu.getParentId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateMenu(Menu menu) {
        String sql = "update xtgl_menu set menu_name=?,img=?,url=?,parent_id=? where menu_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menu.getMenuName(), menu.getImg(), menu.getUrl(), menu.getParentId(), menu.getMenuId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMenu(int menuId) {
        String sql = "delete from xtgl_menu where menu_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menuId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Menu> findMenuByUserId(int userId) {
        String sql = "select * from xtgl_menu where menu_id in" +
                "                              (" +
                "                                select menu_id from xtgl_menu_role where role_id =(" +
                "                                  select role_id from xtgl_role where role_id = (" +
                "                                    select role_id from xtgl_role_user where user_id =?" +
                "                                    )" +
                "                                  )" +
                "                                )";
        try {
            List<Menu> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Menu.class), userId);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
