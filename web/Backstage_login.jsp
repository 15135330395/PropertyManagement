<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-26
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="login/css/Backstage.css">
</head>
<body>
<div class="login">
    <div class="login_title">
        <p>太原天能物业管理系统</p>
    </div>
    <div class="login_main">
        <div class="main_left"></div>
        <div class="main_right">
            <div class="right_title">用户登录</div>
            <form action="Back-stage.jsp" method="post">
                <span style="color: red;margin-left: 50px;font-size: 14px"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></span>
                <div class="username">
                    <img src="login/img/username.png" alt="">
                    <input id="username" name="username" type="text" placeholder="请输入用户名">
                </div>
                <div class="password">
                    <img src="login/img/password.png" alt="">
                    <input id="password" name="password" type="password" placeholder="请输入密码">
                </div>
                <div class="code">
                    <img src="login/img/code.png" alt="">
                    <input type="text" placeholder="请输入验证码">
                    <div class="code_img">
                        <img src="login/img/code_img.png" alt="">
                    </div>
                </div>
                <input class="yes_login" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录">
            </form>
        </div>
    </div>
    <div class="login_footer">
        <!--<p class="name">北京XXXX信息科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;京ICP：京B2-20170028</p>-->
        <!--<p>联系电话：18588888888&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;010-2888888</p>-->
        <p>建议浏览器：IE9以上、Firefox v22</p>
    </div>
</div>

</body>
</html>