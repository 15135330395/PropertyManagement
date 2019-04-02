<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-01
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Title -->
    <title>Layers | Extra - 404</title>

    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta charset="UTF-8">
    <meta name="description" content="Admin Dashboard Template" />
    <meta name="keywords" content="admin,dashboard" />
    <meta name="author" content="Lalassu" />
    <jsp:include page="js_ys_biao.jsp"></jsp:include>

</head>
<body class="page-error">
<main class="page-content">
    <div class="page-inner">
        <div id="main-wrapper">
            <div class="row">
                <div class="col-md-4 center">
                    <div class="panel panel-white" id="js-alerts">
                        <div class="panel-body">
                            <h1 class="text-xxl text-danger text-center">404</h1>
                            <div class="details">
                                <h3>Oops! Something went wrong</h3>
                                <p>We can't find the page you're looking for. Return <a href="index.html">home</a> or search.</p>
                            </div>
                            <form class="input-group m-b-lg">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="input-group-btn">
                                            <button class="btn btn-default"><i class="icon-magnifier"></i></button>
                                        </span>
                            </form>
                        </div>
                    </div>
                </div>
            </div><!-- Row -->
        </div><!-- Main Wrapper -->
    </div><!-- Page Inner -->
</main><!-- Page Content -->

<!-- Javascripts -->
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
