<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29 0029
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>保安打卡表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>

</head>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#">首页</a>
        <a>
          <cite>保安打卡管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <div class="layui-col-md12 x-so">
            <input type="text" name="rotaId" placeholder="请输入排班编号" autocomplete="off" class="layui-input">
            <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>
        </div>
    </div>

    <table class="layui-hide" id="test" lay-filter="test"></table>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="clockIn">上班</a>
        <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="clockOut">下班</a>
    </script>
    <script type="text/html" id="clockIn">
        {{ d.clockIn==null? '尚未打卡':dateFormat(d.clockIn) }}
    </script>
    <script type="text/html" id="clockOut">
        {{ d.clockOut==null? '尚未打卡':dateFormat(d.clockOut) }}
    </script>
    <script>
        layui.use('table', function () {
            var table = layui.table;

            table.render({
                elem: '#test'
                , url: '<%=request.getContextPath()%>/GuardRotaServlet?action=getAllRotaByPage'
                , toolbar: '#toolbarDemo'
                , width: 1200
                , title: '保安排班表'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'rotaId', title: '编号', fixed: 'left', sort: true}
                    , {field: 'rotaTime', title: '排班时段', width: 315}
                    , {field: 'staffId', title: '员工编号'}
                    , {field: 'staffName', title: '员工姓名'}
                    , {field: 'clockIn', title: '上班打卡', templet: '#clockIn', width: 160}
                    , {field: 'clockOut', title: '下班打卡', templet: '#clockOut', width: 160}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]]
                , page: true
            });

            layui.$('#search').on('click', function () {
                var val = layui.$("*[name='rotaId']").val();
                if (val == "") {
                    layer.msg('请输入ID');
                    return;
                }
                layer.open({
                    title: '查询',
                    type: 2,
                    skin: 'layui-layer-rim', // 加上边框
                    area: ['451px', '405px'], // 宽高
                    content: '<%=request.getContextPath()%>/GuardRotaServlet?action=findRotaByRotaId&rotaId=' + val
                });
            });

            //监听行工具事件
            table.on('tool(test)', function (obj) {
                var data = obj.data;
                if (obj.event === 'clockIn') {
                    layer.confirm('准备好上班了吗？', function (index) {
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/GuardRotaServlet",
                            data: {
                                action: "clockIn",
                                rotaId: data.rotaId
                            },
                            success: function (msg) {
                                if (msg == 1) {
                                    layer.alert("打卡成功", {icon: 6});
                                } else if (msg == 2) {
                                    layer.msg("无效 重复打卡", {icon: 2, time: 2000});
                                } else if (msg == 0) {
                                    layer.msg("打卡失败 已被删除或不存在", {icon: 2, time: 2000});
                                }
                                // 刷新本页面
                                setTimeout("location.reload()", 2000)
                            },
                            error: function () {
                                layer.msg("打卡异常")
                            }
                        });
                    });
                } else if (obj.event === 'clockOut') {
                    layer.confirm('确定要下班吗？', function (index) {
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/GuardRotaServlet",
                            data: {
                                action: "clockOut",
                                rotaId: data.rotaId
                            },
                            success: function (msg) {
                                if (msg == 1) {
                                    layer.alert("打卡成功", {icon: 6});
                                } else if (msg == 2) {
                                    layer.msg("无效 重复打卡", {icon: 2, time: 2000});
                                } else if (msg == 0) {
                                    layer.msg("打卡失败 已被删除或不存在", {icon: 2, time: 2000});
                                }
                                // 刷新本页面
                                setTimeout("location.reload()", 2000)
                            },
                            error: function () {
                                layer.msg("打卡异常")
                            }
                        });
                    });
                }
            });
        });
    </script>
</div>
<body>

</body>
</html>
