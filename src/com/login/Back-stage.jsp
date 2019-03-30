<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-27
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>layuiCms - 单页面后台管理模板系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../login/content/layui/rc/css/layui.css?t=201800202-1" media="all">
</head>
<body>
<div id="LAY_app"></div>
<script src="../login/content/layui/rc/layui.js?t=201800202-1"></script>
<script>
    layui.config({
        base: './content/dist/' //指定 layuiCms 项目路径
        , version: new Date().getTime() //'1.0.0-beta6-1'
    }).use('index', function(){
        var layer = layui.layer, admin = layui.admin;
        layer.ready(function(){
            admin.popup({
                content: '本模板是在贤心大神框架基础上扩展而来，下载请做学习之用，如需用于商业用途，请前往官方网站进行购买授权'
                ,area: '300px'
                ,btnAlign: 'c'
                ,shade: false
            });
        });
    });
</script>

</body>
</html>