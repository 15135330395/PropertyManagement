package com.system.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.system.entity.*;
import com.system.service.MenuRoleService;
import com.system.service.MenuService;
import com.system.service.RoleService;
import com.system.service.RoleUserService;
import com.utils.JsonUtil;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description RoleServlet
 * @Author WYR
 * @CreateTime 2019-03-31 16:55
 */
@WebServlet(name = "RoleServlet", urlPatterns = "/RoleServlet")
public class RoleServlet extends HttpServlet {
    private RoleService service = new RoleService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllRoleByPage".equals(action)) {
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
            int roleCount = service.getAllRole().size();
            pageBean.setCount(roleCount);
            List<Role> roleList = service.getAllRoleByPage(pageBean);
            JSONObject table = JsonUtil.getJsonObject(roleList, pageBean);
            response.getWriter().print(table);
        } else if ("addRole".equals(action)) {
            String roleName = request.getParameter("roleName");
            Role role = new Role(roleName);
            int i = service.addRole(role);
            response.getWriter().print(i);
        } else if ("editRole".equals(action)) {
            String roleId = request.getParameter("roleId");
            Role role = service.findRoleById(Integer.parseInt(roleId));
            request.setAttribute("role", role);
            request.getRequestDispatcher("/SystemManager/Role/EditRole.jsp").forward(request, response);
        } else if ("updateRole".equals(action)) {
            String roleId = request.getParameter("roleId");
            String roleName = request.getParameter("roleName");
            Role role = new Role(Integer.parseInt(roleId), roleName);
            int i = service.updateRole(role);
            response.getWriter().print(i);
        } else if ("deleteRole".equals(action)) {
            String roleId = request.getParameter("roleId");
            int i = service.deleteRole(Integer.parseInt(roleId));
            response.getWriter().print(i);
        } else if ("toGrant".equals(action)) {
            String roleId = request.getParameter("roleId");
            Role role = service.findRoleById(Integer.parseInt(roleId));
            request.setAttribute("role", role);

            MenuService menuService = new MenuService();
            List<Menu> menuList = menuService.getAllMenu();
            request.setAttribute("menus", menuList);

            MenuRoleService menuRoleService = new MenuRoleService();
            List<MenuRole> menuByRoleId = menuRoleService.getAllMenuByRoleId(Integer.parseInt(roleId));
            request.setAttribute("menusByRole", menuByRoleId);

            request.getRequestDispatcher("/SystemManager/Role/GrantRole.jsp").forward(request, response);
        } else if ("grant".equals(action)) {
            String roleId = request.getParameter("roleId");
            MenuRoleService menuRoleService = new MenuRoleService();
            int del = menuRoleService.deleteMenuRoleByRoleId(Integer.parseInt(roleId));
            String ids = request.getParameter("menuIds");
            String[] menuIds = ids.split(",");
            int success = 0;
            for (int i = 0; i < menuIds.length; i++) {
                int id = Integer.parseInt(menuIds[i]);
                success += menuRoleService.addMenuRole(new MenuRole(id, Integer.parseInt(roleId)));
            }
            response.getWriter().print(success);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
