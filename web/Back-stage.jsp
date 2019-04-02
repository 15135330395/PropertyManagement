<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-27
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Title -->
    <title>物业管理系统</title>

    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta charset="UTF-8">
    <meta name="description" content="Admin Dashboard Template"/>
    <meta name="keywords" content="admin,dashboard"/>
    <meta name="author" content="Lizards"/>
    <jsp:include page="js_ys_biao.jsp"></jsp:include>

    <style>

    </style>

</head>
<body class="compact-menu">
<jsp:include page="main.jsp"></jsp:include>
<div class="overlay"></div>
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s1">
    <h3><span class="pull-left">Messages</span><a href="javascript:void(0);" class="pull-right" id="closeRight"><i
            class="icon-close"></i></a></h3>
    <div class="slimscroll">
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar2.png" alt=""><span>张三<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar3.png" alt=""><span>李四<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar4.png" alt=""><span>王五<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar5.png" alt=""><span>赵六<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar2.png" alt=""><span>冯七<small>Nice to meet you</small></span></a>
    </div>
</nav>
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2"></nav>
<form class="search-form" action="#" method="GET">
    <div class="input-group">
        <input type="text" name="search" class="form-control search-input" placeholder="Type something...">
        <span class="input-group-btn">
                    <button class="btn btn-default close-search" type="button"><i class="icon-close"></i></button>
                </span>
    </div><!-- Input Group -->
</form><!-- Search Form -->
<main class="page-content content-wrap">
    <div class="navbar">
        <div class="navbar-inner">
            <div class="sidebar-pusher">
                <a href="javascript:void(0);" class="waves-effect waves-button waves-classic push-sidebar">
                    <i class="icon-arrow-right"></i>
                </a>
            </div>
            <div class="logo-box">
                <a href="index.html" class="logo-text"><span>物业管理系统</span></a>
            </div><!-- Logo Box -->
            <div class="search-button">
                <a href="javascript:void(0);" class="show-search"><i class="icon-magnifier"></i></a>
            </div>
            <div class="topmenu-outer">
                <ul class="top-menu">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="javascript:void(0);" class="sidebar-toggle"><i class="icon-arrow-left"></i></a>
                        </li>
                        <li>
                            <a href="#cd-nav" class="cd-nav-trigger"><i class="icon-support"></i></a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="toggle-fullscreen"><i class="icon-size-fullscreen"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="icon-settings"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-md dropdown-list theme-settings" role="menu">
                                <li class="li-group">
                                    <ul class="list-unstyled">
                                        <li class="no-link" role="presentation">
                                            Fixed Header
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox" class="js-switch pull-right fixed-header-check">
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li class="li-group">
                                    <ul class="list-unstyled">
                                        <li class="no-link" role="presentation">
                                            Fixed Sidebar
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox" class="js-switch pull-right fixed-sidebar-check">
                                            </div>
                                        </li>
                                        <li class="no-link" role="presentation">
                                            Horizontal bar
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox"
                                                       class="js-switch pull-right horizontal-bar-check">
                                            </div>
                                        </li>
                                        <li class="no-link" role="presentation">
                                            Toggle Sidebar
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox"
                                                       class="js-switch pull-right toggle-sidebar-check">
                                            </div>
                                        </li>
                                        <li class="no-link" role="presentation">
                                            Compact Menu
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox" class="js-switch pull-right compact-menu-check"
                                                       checked>
                                            </div>
                                        </li>
                                        <li class="no-link" role="presentation">
                                            Hover Menu
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox" class="js-switch pull-right hover-menu-check">
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li class="li-group">
                                    <ul class="list-unstyled">
                                        <li class="no-link" role="presentation">
                                            Boxed Layout
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox" class="js-switch pull-right boxed-layout-check">
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li class="no-link">
                                    <button class="btn btn-default reset-options">Reset Options</button>
                                </li>
                            </ul>
                        </li>
                    </ul>

                    <ul id="time" class="nav navbar-nav navbar-center visible-lg visible-md">
                        <%--<li>2019</li>
                        <li>年</li>
                        <li>03</li>
                        <li>月</li>
                        <li>29</li>
                        <li>日</li>
                        <li>16</li>
                        <li>:</li>
                        <li>17</li>
                        <li>:</li>
                        <li>30</li>
                        <span class="tab-city">南京</span>&nbsp;&nbsp;
                        <span class="tab-tianqi">晴天 36</span>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="javascript:void(0);" class="show-search"><i class="icon-magnifier"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                    class="icon-envelope-open"></i><span class="badge badge-danger pull-right">6</span></a>
                            <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                <li><p class="drop-title">You have 6 new messages!</p></li>
                                <li class="dropdown-menu-list slimscroll messages">
                                    <ul class="list-unstyled">
                                        <li>
                                            <a href="#">
                                                <div class="msg-img">
                                                    <div class="online on"></div>
                                                    <img class="img-circle" src="assets/images/avatar2.png" alt="">
                                                </div>
                                                <p class="msg-name">Michael Lewis</p>
                                                <p class="msg-text">Yeah science!</p>
                                                <p class="msg-time">3 minutes ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img">
                                                    <div class="online off"></div>
                                                    <img class="img-circle" src="assets/images/avatar4.png" alt="">
                                                </div>
                                                <p class="msg-name">John Doe</p>
                                                <p class="msg-text">Hi Nick</p>
                                                <p class="msg-time">8 minutes ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img">
                                                    <div class="online off"></div>
                                                    <img class="img-circle" src="assets/images/avatar3.png" alt="">
                                                </div>
                                                <p class="msg-name">Emma Green</p>
                                                <p class="msg-text">Let's meet!</p>
                                                <p class="msg-time">56 minutes ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img">
                                                    <div class="online on"></div>
                                                    <img class="img-circle" src="assets/images/avatar5.png" alt="">
                                                </div>
                                                <p class="msg-name">Nick Doe</p>
                                                <p class="msg-text">Nice to meet you</p>
                                                <p class="msg-time">2 hours ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img">
                                                    <div class="online on"></div>
                                                    <img class="img-circle" src="assets/images/avatar2.png" alt="">
                                                </div>
                                                <p class="msg-name">Michael Lewis</p>
                                                <p class="msg-text">Yeah science!</p>
                                                <p class="msg-time">5 hours ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img">
                                                    <div class="online off"></div>
                                                    <img class="img-circle" src="assets/images/avatar4.png" alt="">
                                                </div>
                                                <p class="msg-name">John Doe</p>
                                                <p class="msg-text">Hi Nick</p>
                                                <p class="msg-time">9 hours ago</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="drop-all"><a href="#" class="text-center">All Messages</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-bell"></i><span
                                    class="badge badge-danger pull-right">3</span></a>
                            <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                <li><p class="drop-title">您有3条信息</p></li>
                                <li class="dropdown-menu-list slimscroll tasks">
                                    <ul class="list-unstyled">
                                        <li>
                                            <a href="#">
                                                <div class="task-icon badge badge-success"><i class="fa fa-user"></i>
                                                </div>
                                                <span class="badge badge-roundless badge-default pull-right">1m</span>
                                                <p class="task-details">新用户已注册</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="task-icon badge badge-primary"><i class="fa fa-refresh"></i>
                                                </div>
                                                <span class="badge badge-roundless badge-default pull-right">24m</span>
                                                <p class="task-details">刷新了3个图表</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="task-icon badge badge-danger"><i class="fa fa-phone"></i>
                                                </div>
                                                <span class="badge badge-roundless badge-default pull-right">24m</span>
                                                <p class="task-details">2个未接电话</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="drop-all"><a href="#" class="text-center">所有任务</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="user-name">${username}<i class="fa fa-angle-down"></i></span>
                                <img class="img-circle avatar" src="login/images/avatar1.png"
                                     style="width:40px;height:40px" alt="">
                                <%--<img src="login/images/avatar1.png" style="" alt="">--%>
                            </a>
                            <ul class="dropdown-menu dropdown-list" role="menu">
                                <li role="presentation"><a href="profile.html"><i class="icon-user"></i>状况</a></li>
                                <li role="presentation"><a href="calendar.html"><i
                                        class="icon-calendar"></i>Calendar</a></li>
                                <li role="presentation"><a href="inbox.html"><i
                                        class="icon-envelope-open"></i>Inbox<span
                                        class="badge badge-success pull-right">4</span></a></li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation"><a href="lock-screen.html"><i class="icon-lock"></i>Lock screen</a>
                                </li>
                                <li role="presentation"><a href="login.html"><i class="icon-key m-r-xs"></i>Log out</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" id="showRight">
                                <i class="icon-bubbles"></i>
                            </a>
                        </li>
                    </ul><!-- Nav -->
            </div><!-- Top Menu -->
        </div>
    </div>
    </div>
    <!-- Navbar -->
    <div id="sidebar" class="page-sidebar sidebar">
        <div class="page-sidebar-inner slimscroll">
            <ul class="menu accordion-menu">
                <li class="active"><a href="javascript://" class="waves-effect waves-button waves-classic">
                    <span class="menu-icon icon-home"></span>
                    <p>主页</p>
                    <span class="active-page"></span>
                </a>
                </li>
                <c:forEach items="${menus}" var="root">
                    <c:if test="${root.parentId==-1}">
                        <li class="droplink">
                            <a href="${root.url}" class="waves-effect waves-button">
                                <span class="menu-icon ${root.img}"></span>
                                <p>${root.menuName}</p>
                                <span class="arrow"></span>
                            </a>

                            <ul class="sub-menu">
                                <c:forEach items="${menus}" var="menu">
                                    <c:if test="${menu.parentId==root.menuId}">
                                        <li>
                                            <a href="<%=request.getContextPath()%>${menu.url}" class="waves-effect waves-button">
                                                <span class="menu-icon ${menu.img}"></span>
                                                <p>${menu.menuName}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                </c:forEach>

                <li class="droplink"><a href="#" class="waves-effect waves-button"><span
                        class="menu-icon icon-present"></span>
                    <p>错误信息</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="404.jsp">404 页面</a></li>
                        <li><a href="500.jsp">500 页面</a></li>

                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span
                        class="menu-icon icon-energy"></span>
                    <p>版本</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="#">版本 1.1</a></li>
                        <li><a href="#">版本 1.2</a></li>
                    </ul>
                </li>
            </ul>

        </div><!-- Page Sidebar Inner -->
    </div><!-- Page Sidebar -->

    <div class="page-inner">
        <div class="page-title">
            <div class="page-breadcrumb">
                <ol class="breadcrumb">
                    <li><a href="index.jsp">首页</a></li>
                    <li class="active">主页</li>
                </ol>
            </div>
        </div>

        <div id="main-wrapper">
            <jsp:include page="default.jsp"></jsp:include>
            <%--<iframe id="framecon" src="default.jsp" name="con" style="width:100%;height:700px; border:none;" frameborder="0" onload="SetIframeHeight(this);">IE</iframe>--%>
        </div>


        <div class="page-footer">
            <p class="no-s">Made with <i class="fa fa-heart"></i> by lizards</p>
        </div>

    </div><!-- Page Inner -->
</main><!-- Page Content -->


<jsp:include page="bottom.jsp"></jsp:include>

</body>
</html>