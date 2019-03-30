<%--
  Created by IntelliJ IDEA.
  User: 15087
  Date: 2019/3/30
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后勤部职员表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>

</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#">首页</a>
        <a>
          <cite>后勤部职员管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <div class="layui-col-md12 x-so">
            <input type="text" name="staffId" placeholder="请输入员工编号" autocomplete="off" class="layui-input">
            <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>
        </div>
    </div>

    <table class="layui-hide" id="test" lay-filter="test"></table>


    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    </script>
    <script type="text/html" id="joinTime">
        {{ dateFormat(d.joinTime) }}
    </script>
    <script>
        layui.use('table', function () {
            var table = layui.table;

            table.render({
                elem: '#test'
                , url: '<%=request.getContextPath()%>/LogisticsStaffServlet?action=getAllLogisticsStaffByPage'
                , toolbar: '#toolbarDemo'
                , width: 1200
                , title: '后勤部职员表'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'staffId', title: '员工编号', fixed: 'left', sort: true}
                    , {field: 'staffName', title: '姓名', width: 315}
                    , {field: 'departmentId', title: '部门编号', hide: true, sort: true}
                    , {field: 'departmentName', title: '部门名称'}
                    , {field: 'age', title: '年龄'}
                    , {field: 'sex', title: '性别'}
                    , {field: 'joinTime', title: '工作时间', templet: '#joinTime', width: 160}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]]
                , page: true
            });

            layui.$('#search').on('click', function () {
                var val = layui.$("*[name='staffId']").val();
                if (val == "") {
                    layer.msg('请输入ID');
                    return;
                }
                layer.open({
                    title: '查询',
                    type: 2,
                    skin: 'layui-layer-rim', // 加上边框
                    area: ['451px', '405px'], // 宽高
                    content: '<%=request.getContextPath()%>/LogisticsStaffServlet?action=findStaffById&staffId=' + val
                });
            });

            //监听行工具事件
            table.on('tool(test)', function (obj) {
                var data = obj.data;
                if (obj.event === 'edit') {
                    layer.open({
                        title: '修改员工信息',
                        type: 2,
                        skin: 'layui-layer-rim', // 加上边框
                        area: ['840px', '620px'], // 宽高
                        content: '<%=request.getContextPath()%>/LogisticsStaffServlet?action=editStaff&staffId=' + data.staffId
                    });
                }
            });
        });
    </script>
</div>

</body>
</html>

