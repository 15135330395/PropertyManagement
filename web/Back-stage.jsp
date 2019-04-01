<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-27
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Title -->
    <title>物业管理系统</title>

    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta charset="UTF-8">
    <meta name="description" content="Admin Dashboard Template" />
    <meta name="keywords" content="admin,dashboard" />
    <meta name="author" content="Lizards" />
<jsp:include page="js_ys_biao.jsp"></jsp:include>

    <style>

    </style>

</head>
<body class="compact-menu">
<jsp:include page="main.jsp"></jsp:include>
<div class="overlay"></div>
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s1">
    <h3><span class="pull-left">Messages</span><a href="javascript:void(0);" class="pull-right" id="closeRight"><i class="icon-close"></i></a></h3>
    <div class="slimscroll">
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar2.png" alt=""><span>Michael Lewis<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar3.png" alt=""><span>John Doe<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar4.png" alt=""><span>Emma Green<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar5.png" alt=""><span>Nick Doe<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar2.png" alt=""><span>Michael Lewis<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar3.png" alt=""><span>John Doe<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar4.png" alt=""><span>Emma Green<small>Nice to meet you</small></span></a>
        <a href="javascript:void(0);" class="showRight2"><img src="login/images/avatar5.png" alt=""><span>Nick Doe<small>Nice to meet you</small></span></a>
    </div>
</nav>
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2">
    <h3><span class="pull-left">Michael Lewis</span> <a href="javascript:void(0);" class="pull-right" id="closeRight2"><i class="fa fa-angle-right"></i></a></h3>
    <div class="slimscroll chat">
        <div class="chat-item chat-item-left">
            <div class="chat-image">
                <img src="login/images/avatar2.png" alt="">
            </div>
            <div class="chat-message">
                Duis aute irure dolor?
            </div>
        </div>
        <div class="chat-item chat-item-right">
            <div class="chat-message">
                Lorem ipsum dolor sit amet, dapibus quis, laoreet et.
            </div>
        </div>
        <div class="chat-item chat-item-left">
            <div class="chat-image">
                <img src="login/images/avatar2.png" alt="">
            </div>
            <div class="chat-message">
                Ut ullamcorper, ligula.
            </div>
        </div>
        <div class="chat-item chat-item-right">
            <div class="chat-message">
                In hac habitasse platea dict umst. ligula eu tempor eu id tincidunt.
            </div>
        </div>
        <div class="chat-item chat-item-left">
            <div class="chat-image">
                <img src="login/images/avatar2.png" alt="">
            </div>
            <div class="chat-message">
                Curabitur pretium?
            </div>
        </div>
        <div class="chat-item chat-item-right">
            <div class="chat-message">
                Etiam tempor. Ut tempor! ull amcorper.
            </div>
        </div>
    </div>
    <div class="chat-write">
        <form class="form-horizontal" action="javascript:void(0);">
            <input type="text" class="form-control" placeholder="Say something">
        </form>
    </div>
</nav>
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
                                                <input type="checkbox" class="js-switch pull-right horizontal-bar-check">
                                            </div>
                                        </li>
                                        <li class="no-link" role="presentation">
                                            Toggle Sidebar
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox" class="js-switch pull-right toggle-sidebar-check">
                                            </div>
                                        </li>
                                        <li class="no-link" role="presentation">
                                            Compact Menu
                                            <div class="ios-switch pull-right switch-md">
                                                <input type="checkbox" class="js-switch pull-right compact-menu-check" checked>
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
                                <li class="no-link"><button class="btn btn-default reset-options">Reset Options</button></li>
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-envelope-open"></i><span class="badge badge-danger pull-right">6</span></a>
                            <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                <li><p class="drop-title">You have 6 new  messages!</p></li>
                                <li class="dropdown-menu-list slimscroll messages">
                                    <ul class="list-unstyled">
                                        <li>
                                            <a href="#">
                                                <div class="msg-img"><div class="online on"></div><img class="img-circle" src="assets/images/avatar2.png" alt=""></div>
                                                <p class="msg-name">Michael Lewis</p>
                                                <p class="msg-text">Yeah science!</p>
                                                <p class="msg-time">3 minutes ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img"><div class="online off"></div><img class="img-circle" src="assets/images/avatar4.png" alt=""></div>
                                                <p class="msg-name">John Doe</p>
                                                <p class="msg-text">Hi Nick</p>
                                                <p class="msg-time">8 minutes ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img"><div class="online off"></div><img class="img-circle" src="assets/images/avatar3.png" alt=""></div>
                                                <p class="msg-name">Emma Green</p>
                                                <p class="msg-text">Let's meet!</p>
                                                <p class="msg-time">56 minutes ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img"><div class="online on"></div><img class="img-circle" src="assets/images/avatar5.png" alt=""></div>
                                                <p class="msg-name">Nick Doe</p>
                                                <p class="msg-text">Nice to meet you</p>
                                                <p class="msg-time">2 hours ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img"><div class="online on"></div><img class="img-circle" src="assets/images/avatar2.png" alt=""></div>
                                                <p class="msg-name">Michael Lewis</p>
                                                <p class="msg-text">Yeah science!</p>
                                                <p class="msg-time">5 hours ago</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="msg-img"><div class="online off"></div><img class="img-circle" src="assets/images/avatar4.png" alt=""></div>
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-bell"></i><span class="badge badge-danger pull-right">3</span></a>
                            <ul class="dropdown-menu title-caret dropdown-lg" role="menu">
                                <li><p class="drop-title">You have 3 pending tasks!</p></li>
                                <li class="dropdown-menu-list slimscroll tasks">
                                    <ul class="list-unstyled">
                                        <li>
                                            <a href="#">
                                                <div class="task-icon badge badge-success"><i class="fa fa-user"></i></div>
                                                <span class="badge badge-roundless badge-default pull-right">1m</span>
                                                <p class="task-details">New user registered</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="task-icon badge badge-primary"><i class="fa fa-refresh"></i></div>
                                                <span class="badge badge-roundless badge-default pull-right">24m</span>
                                                <p class="task-details">3 Charts refreshed</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="task-icon badge badge-danger"><i class="fa fa-phone"></i></div>
                                                <span class="badge badge-roundless badge-default pull-right">24m</span>
                                                <p class="task-details">2 Missed calls</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="drop-all"><a href="#" class="text-center">All Tasks</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="user-name">Nick<i class="fa fa-angle-down"></i></span>
                                <img class="img-circle avatar" src="login/images/avatar1.png" style="width:40px;height:40px" alt="">
                                <%--<img src="login/images/avatar1.png" style="" alt="">--%>
                            </a>
                            <ul class="dropdown-menu dropdown-list" role="menu">
                                <li role="presentation"><a href="profile.html"><i class="icon-user"></i>Profile</a></li>
                                <li role="presentation"><a href="calendar.html"><i class="icon-calendar"></i>Calendar</a></li>
                                <li role="presentation"><a href="inbox.html"><i class="icon-envelope-open"></i>Inbox<span class="badge badge-success pull-right">4</span></a></li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation"><a href="lock-screen.html"><i class="icon-lock"></i>Lock screen</a></li>
                                <li role="presentation"><a href="login.html"><i class="icon-key m-r-xs"></i>Log out</a></li>
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
    </div><!-- Navbar -->
    <div id="sidebar" class="page-sidebar sidebar">
        <div class="page-sidebar-inner slimscroll">
            <ul class="menu accordion-menu">
                <li class="active"><a href="javascript://" class="waves-effect waves-button waves-classic"><span class="menu-icon icon-home"></span><p>主页</p><span class="active-page"></span></a></li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-user"></span><p>基础管理</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-user"></span><p>基础资料</p></a></li>
                        <li><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-user"></span><p>系统维护</p></a></li>
                        <li><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-user"></span><p>房产管理</p></a></li>

                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button">
                    <span class="menu-icon icon-envelope-open"></span><p>协同办公</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="inbox.html">我的工作台</a></li>
                        <li><a href="message-view.html">流程管理</a></li>
                        <li><a href="compose.html">资源管理</a></li>
                        <li><a href="compose.html">消息中心</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-puzzle"></span><p>客户关系管理</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="ui-alerts.html">客户管理</a></li>
                        <li><a href="ui-buttons.html">客服管理</a></li>
                        <li><a href="ui-icons.html">短信平台</a></li>
                        <li><a href="ui-typography.html">邮件平台</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-layers"></span><p>收费管理</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="layout-blank.html">收费管理</a></li>
                        <li><a href="layout-boxed.html">费用报表</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-grid"></span><p>租赁管理</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="table-static.html">租赁管理</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-pencil"></span><p>物料管理</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="form-elements.html">仓库管理</a></li>
                        <li><a href="form-wizard.html">采购管理</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-pie-chart"></span><p>工程管理</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="charts-sparkline.html">合同管理</a></li>
                        <li><a href="charts-rickshaw.html">签报管理</a></li>
                        <li><a href="charts-morris.html">设备管理</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-power"></span><p>人事管理</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="login.html">人事档案</a></li>
                        <li><a href="login-alt.html">招聘管理</a></li>
                        <li><a href="register.html">合同管理</a></li>
                        <li><a href="register-alt.html">考勤管理</a></li>
                        <li><a href="forgot.html">绩效管理</a></li>
                        <li><a href="lock-screen.html">社保管理</a></li>
                        <li><a href="lock-screen.html">酬薪管理</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-pointer"></span><p>Maps</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="maps-google.html">Google Maps</a></li>
                        <li><a href="maps-vector.html">Vector Maps</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-present"></span><p>Extra</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li><a href="404.html">404 Page</a></li>
                        <li><a href="500.html">500 Page</a></li>
                        <li><a href="invoice.html">Invoice</a></li>
                        <li><a href="calendar.html">Calendar</a></li>
                        <li><a href="faq.html">FAQ</a></li>
                        <li><a href="todo.html">Todo</a></li>
                        <li><a href="pricing-tables.html">Pricing Tables</a></li>
                        <li><a href="shop.html">Shop</a></li>
                        <li><a href="gallery.html">Gallery</a></li>
                        <li><a href="timeline.html">Timeline</a></li>
                        <li><a href="search.html">Search Results</a></li>
                        <li><a href="coming-soon.html">Coming Soon</a></li>
                        <li><a href="contact.html">Contact</a></li>
                    </ul>
                </li>
                <li class="droplink"><a href="#" class="waves-effect waves-button"><span class="menu-icon icon-energy"></span><p>Levels</p><span class="arrow"></span></a>
                    <ul class="sub-menu">
                        <li class="droplink"><a href="#"><p>Level 1.1</p><span class="arrow"></span></a>
                            <ul class="sub-menu">
                                <li class="droplink"><a href="#"><p>Level 2.1</p><span class="ar    row"></span></a>
                                    <ul class="sub-menu">
                                        <li><a href="#">Level 3.1</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Level 2.2</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Level 1.2</a></li>
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
<nav class="cd-nav-container" id="cd-nav">
    <header>
        <h3>LAYERS</h3>
    </header>
    <div class="col-md-6 demo-block demo-selected demo-active">
        <p>Dark<br>Design</p>
    </div>
    <div class="col-md-6 demo-block">
        <a href="../admin2/index.html"><p>Light<br>Design</p></a>
    </div>
    <div class="col-md-6 demo-block demo-coming-soon">
        <p>Horizontal<br>(Coming)</p>
    </div>
    <div class="col-md-6 demo-block demo-coming-soon">
        <p>Material<br>(Coming)</p>
    </div>
    <div class="col-md-6 demo-block demo-coming-soon">
        <p>Coming<br>Soon</p>
    </div>
    <div class="col-md-6 demo-block demo-coming-soon">
        <p>Coming<br>Soon</p>
    </div>
</nav>
<div class="cd-overlay"></div>

<!-- Javascripts -->
<script src="login/plugins/jquery/jquery-3.1.0.min.js"></script>
<script src="login/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="login/plugins/pace-master/pace.min.js"></script>
<script src="login/plugins/jquery-blockui/jquery.blockui.js"></script>
<script src="login/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="login/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="login/plugins/switchery/switchery.min.js"></script>
<script src="login/plugins/uniform/js/jquery.uniform.standalone.js"></script>
<script src="login/plugins/offcanvasmenueffects/js/classie.js"></script>
<script src="login/plugins/waves/waves.min.js"></script>
<script src="login/plugins/3d-bold-navigation/js/main.js"></script>
<script src="login/plugins/waypoints/jquery.waypoints.min.js"></script>
<script src="login/plugins/toastr/toastr.min.js"></script>
<script src="login/plugins/flot/jquery.flot.min.js"></script>
<script src="login/plugins/flot/jquery.flot.time.min.js"></script>
<script src="login/plugins/flot/jquery.flot.symbol.min.js"></script>
<script src="login/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="login/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="login/plugins/curvedlines/curvedLines.js"></script>
<script src="login/plugins/chartjs/Chart.bundle.min.js"></script>
<script src="login/js/layers.min.js"></script>
<script src="login/js/pages/dashboard.js"></script>

</body>
</html>