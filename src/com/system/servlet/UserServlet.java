package com.system.servlet;

import com.alibaba.fastjson.JSONObject;
import com.entity.PageBean;
import com.system.entity.Menu;
import com.system.entity.Role;
import com.system.entity.RoleUser;
import com.system.entity.User;
import com.system.service.MenuService;
import com.system.service.RoleService;
import com.system.service.RoleUserService;
import com.system.service.UserService;
import com.utils.JsonUtil;
import com.utils.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Description UserServlet
 * @Author WYR
 * @CreateTime 2019-03-31 16:56
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllUserByPage".equals(action)) {
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
            int userCount = service.getAllUser().size();
            pageBean.setCount(userCount);
            List<User> userList = service.getAllUserByPage(pageBean);
            JSONObject table = JsonUtil.getJsonObject(userList, pageBean);
            response.getWriter().print(table);
        } else if ("addUser".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User(username, password);
            int i = service.addUser(user);
            response.getWriter().print(i);
        } else if ("editUser".equals(action)) {
            String userId = request.getParameter("userId");
            User user = service.findUserById(Integer.parseInt(userId));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/SystemManager/User/EditUser.jsp").forward(request, response);
        } else if ("updateUser".equals(action)) {
            String userId = request.getParameter("userId");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User(Integer.parseInt(userId), username, password);
            int i = service.updateUser(user);
            response.getWriter().print(i);
        } else if ("deleteUser".equals(action)) {
            String userId = request.getParameter("userId");
            int i = service.deleteUser(Integer.parseInt(userId));
            response.getWriter().print(i);
        } else if ("toRole".equals(action)) {
            String userId = request.getParameter("userId");
            User user = service.findUserById(Integer.parseInt(userId));
            request.setAttribute("user", user);

            RoleService roleService = new RoleService();
            List<Role> roleList = roleService.getAllRole();
            request.setAttribute("roleList", roleList);

            RoleUserService roleUserService = new RoleUserService();
            RoleUser roleUser = roleUserService.findRoleUserByUserId(Integer.parseInt(userId));
            request.setAttribute("roleUser", roleUser);

            request.getRequestDispatcher("/SystemManager/User/GiveUsersARole.jsp").forward(request, response);
        } else if ("giveUsersARole".equals(action)) {
            String userId = request.getParameter("userId");
            String roleId = request.getParameter("roleId");
            RoleUserService roleUserService = new RoleUserService();
            int i = roleUserService.addRoleUser(new RoleUser(Integer.parseInt(roleId), Integer.parseInt(userId)));
            response.getWriter().print(i);
        } else if ("findUserByUsername".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = service.findUserByUsername(username);
            String str = MD5Util.MD5Test(username + password);
            if (user == null) {
                System.out.println("用户名 " + username + " 不存在");
                // 用户名不存在
                response.getWriter().print(202);
            } else {
                if (user.getPassword().equals(str)) {
                    System.out.println("用户 " + username + " 登录成功");
                    // 登陆成功
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("user", user);
                    MenuService menuService = new MenuService();
                    List<Menu> menuList = menuService.findMenuByUserId(user.getUserId());
                    System.out.println(menuList.get(0).getImg()+" "+menuList.get(0).getMenuName());
                    request.getSession().setAttribute("menus", menuList);
                    response.getWriter().print(200);
                } else {
                    // 密码错误
                    System.out.println("用户 " + username + " 的密码错误");
                    response.getWriter().print(201);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

