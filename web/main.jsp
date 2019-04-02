<%@ page import="com.system.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");
    User user = (User) session.getAttribute("user");
    if (username == null || username == "") {
        request.setAttribute("msg", "你还没有登录…");
        request.getRequestDispatcher("Backstage_login.jsp").forward(request, response);
    } else if (user == null) {
        request.setAttribute("msg", "用户名或密码错误");
        request.getRequestDispatcher("Backstage_login.jsp").forward(request, response);
    }
%>
