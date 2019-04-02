<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/info.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>查询标准</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">?</i></a>
</div>
<div class="x-body" style="height: 60px">
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <td>normId</td>
            <td>项目名称</td>
            <td>标准名称</td>
            <td>金额计算方式</td>
            <td>收费周期</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${payNorms}" var="payNorms">
            <tr>
                <th>
                    <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
                </th>
                <td>${payNorms.normId}</td>
                <td>${payNorms.payName}</td>
                <td>${payNorms.normName}</td>
                <td>${payNorms.computeMode}</td>
                <td>${payNorms.chargeCycle}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<form action="/shouFei/items/payItems.jsp" method="post">
    <button>返回<<</button>
</form>
</body>
</html>
