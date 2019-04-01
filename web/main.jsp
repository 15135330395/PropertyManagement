
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String user=(String)session.getAttribute("username");
        if (username==null || username==""){
            if (user==null){
                request.setAttribute("msg","你还没有登录…");
                request.getRequestDispatcher("Backstage_login.jsp").forward(request,response);
            }
        }else if (username.equals(password)){
            session.setAttribute("username",username);
        }else{
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("Backstage_login.jsp").forward(request,response);
        }
    %>
