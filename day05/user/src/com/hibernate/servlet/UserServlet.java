package com.hibernate.servlet;

import com.hibernate.dao.UserDao;
import com.hibernate.entity.User;
import com.hibernate.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * @author :张
 * Date  : 2019/4/12
 * @Description: ${NAME}
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {

    UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  request.setCharacterEncoding("utf-8");
  response.setContentType("text/html;charset=utf-8");

        String method = request.getParameter("method");
        if("queryPage".equals(method)){
            queryPage(request,response);
        }else if("queryOne".equals(method)){
            queryOne(request,response);
        }else if("update".equals(method)){
            update(request,response);
        }else if("delete".equals(method)){
            delete(request,response);
        }else if("add".equals(method)){
            add(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int pageIndex=1;
        String index = request.getParameter("pageIndex");
        if(index!=null){
              pageIndex= Integer.parseInt(index);
        }
       int pageCount=5;
      UserDao dao=new UserDao();
        int pages = dao.pages(pageCount);

        List<User> userList = userService.queryPage(pageIndex,pageCount);

        System.out.println(userList);
        request.setAttribute("pages",pages);
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/query.jsp").forward(request,response);
    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = userService.queryOne(Integer.parseInt(id));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/queryOne.jsp").forward(request,response);

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     UserDao dao=new UserDao();
        System.out.println("Servlet...update");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("name.."+name+"password"+password);
        dao.updateById(new User(name,password));
     //   System.out.println(new User(name,password));
     // request.getRequestDispatcher("/update.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/UserServlet?method=queryPage");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();

       String id = request.getParameter("id");
       dao.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath()+"UserServlet?method=queryPage");

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        dao.add(new User( name,password));
       // request.getRequestDispatcher("/add.jsp").forward(request,response);
       response.sendRedirect(request.getContextPath()+"/UserServlet?method=queryPage");

    }


}
