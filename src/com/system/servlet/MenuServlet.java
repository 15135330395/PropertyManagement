package com.system.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.system.entity.Menu;
import com.system.entity.Role;
import com.system.service.MenuService;
import com.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description MenuServlet
 * @Author WYR
 * @CreateTime 2019-03-31 16:51
 */
@WebServlet(name = "MenuServlet", urlPatterns = "/MenuServlet")
public class MenuServlet extends HttpServlet {
    private MenuService service = new MenuService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllMenuByPage".equals(action)) {
            PageBean pageBean = new PageBean();
            // 页码
            String pageIndex = request.getParameter("page");
            if (pageIndex != null) {
                pageBean.setPageIndex(Integer.parseInt(pageIndex));
            }
            // 每页条数
            String pageCount = request.getParameter("limit");
            pageBean.setPageCount(Integer.parseInt(pageCount));
            // 总条数
            int menuCount = service.getAllMenu().size();
            pageBean.setCount(menuCount);
            List<Menu> menuList = service.getAllMenuByPage(pageBean);
            JSONObject table = JsonUtil.getJsonObject(menuList, pageBean);
            response.getWriter().print(table);
        } else if ("addMenu".equals(action)) {
            String menuName = request.getParameter("menuName");
            String img = request.getParameter("img");
            String url = request.getParameter("url");
            String parentId = request.getParameter("parentId");
            Menu menu = new Menu(menuName, img, url, Integer.parseInt(parentId));
            int i = service.addMenu(menu);
            response.getWriter().print(i);
        } else if ("editMenu".equals(action)) {
            String menuId = request.getParameter("menuId");
            Menu menu = service.findMenuById(Integer.parseInt(menuId));
            request.setAttribute("menu", menu);
            request.getRequestDispatcher("/SystemManager/Menu/EditMenu.jsp").forward(request, response);
        } else if ("updateMenu".equals(action)) {
            String menuId = request.getParameter("menuId");
            String menuName = request.getParameter("menuName");
            String img = request.getParameter("img");
            String url = request.getParameter("url");
            String parentId = request.getParameter("parentId");
            Menu menu = new Menu(Integer.parseInt(menuId), menuName, img, url, Integer.parseInt(parentId));
            int i = service.updateMenu(menu);
            response.getWriter().print(i);
        } else if ("deleteMenu".equals(action)) {
            String menuId = request.getParameter("menuId");
            int i = service.deleteMenu(Integer.parseInt(menuId));
            response.getWriter().print(i);
        } else if ("findMenuByUserId".equals(action)) {

            String userId = request.getParameter("userId");
            List<Menu> menuList = service.findMenuByUserId(Integer.parseInt(userId));
            request.setAttribute("menuList", menuList);
            request.getRequestDispatcher("/").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
