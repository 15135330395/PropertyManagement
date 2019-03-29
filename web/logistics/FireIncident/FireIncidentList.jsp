<%--
  Created by IntelliJ IDEA.
  User: 15087
  Date: 2019/3/27
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>消防事故表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>

</head>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#">首页</a>
        <a>
          <cite>绿化清洁任务管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <div class="layui-col-md12 x-so">
            <input type="text" name="incidentId" placeholder="请输入事故编号" autocomplete="off" class="layui-input">
            <button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>
        </div>
    </div>

    <table class="layui-hide" id="test" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn" lay-event="addIncident">
                <i class="layui-icon"></i>添加
            </button>
            <button class="layui-btn layui-btn-danger" lay-event="delAll">
                <i class="layui-icon"></i>批量删除
            </button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/html" id="alarmTime">
        {{ dateFormat(d.alarmTime) }}
    </script>
    <script>
        layui.use('table', function () {
            var table = layui.table;

            table.render({
                elem: '#test'
                , url: '<%=request.getContextPath()%>/FireIncidentServlet?action=getAllIncidentByPage'
                , toolbar: '#toolbarDemo'
                , width: 1200
                , title: '消防事故表'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'incidentId', title: '编号', fixed: 'left', sort: true}
                    , {field: 'alarmTime', title: '出动时间', templet: '#alarmTime'}
                    , {field: 'incidentLocale', title: '地点'}
                    , {field: 'staffNames', title: '人员'}
                    , {field: 'cause', title: '起因'}
                    , {field: 'loss', title: '损失'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]]
                , page: true
            });

            layui.$('#search').on('click', function () {
                var val = layui.$("*[name='incidentId']").val();
                if (val == "") {
                    layer.msg('请输入ID');
                    return;
                }
                layer.open({
                    title: '查询',
                    type: 2,
                    skin: 'layui-layer-rim', // 加上边框
                    area: ['451px', '405px'], // 宽高
                    content: '<%=request.getContextPath()%>/FireIncidentServlet?action=findIncidentById&incidentId=' + val
                });
            });

            //头工具栏事件
            table.on('toolbar(test)', function (obj) {
                if (obj.event === 'addIncident') {
                    layer.open({
                        title: '添加任务',
                        type: 2,
                        closeBtn: 1,
                        skin: 'layui-layer-rim', // 加上边框
                        area: ['840px', '620px'], // 宽高
                        content: '<%=request.getContextPath()%>/logistics/FireIncident/AddFireIncident.jsp'
                    });
                } else if (obj.event === 'delAll') {
                    var checkStatus = table.checkStatus(obj.config.id);
                    var data = checkStatus.data;
                    if (data == "") {
                        layer.msg('请至少选择1条数据');
                        return;
                    }
                    var ids = "";
                    for (var i = 0; i < data.length; i++) {
                        ids += data[i].incidentId
                        ids += ","
                    }
                    layer.confirm('确认要删除这些信息吗？', function () {
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/FireIncidentServlet",
                            data: {
                                action: "deleteIncidents",
                                incidentIds: "" + ids
                            },
                            success: function (msg) {
                                if (msg > 0) {
                                    layer.alert("成功删除" + msg + "条数据", {icon: 6});
                                } else {
                                    layer.msg('已被删除或不存在', {icon: 2, time: 2000});
                                }
                                // 刷新本页面
                                setTimeout("location.reload()", 2000)
                            },
                            error: function () {
                                layer.msg("删除异常")
                            }
                        });
                    });
                }
            });

            //监听行工具事件
            table.on('tool(test)', function (obj) {
                var data = obj.data;
                if (obj.event === 'del') {
                    layer.confirm('真的要删除吗？', function (index) {
                        layer.close(index);
                        //发异步 删除数据
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/FireIncidentServlet",
                            data: {
                                action: "deleteIncident",
                                incidentId: data.incidentId
                            },
                            success: function (msg) {
                                if (msg == 1) {
                                    layer.alert("删除成功", {icon: 6});
                                } else {
                                    layer.msg("已被删除或不存在", {icon: 2, time: 2000});
                                }
                                obj.del();
                            },
                            error: function () {
                                layer.msg("删除异常")
                            }
                        });
                    });
                } else if (obj.event === 'edit') {
                    layer.open({
                        title: '任务修改',
                        type: 2,
                        skin: 'layui-layer-rim', // 加上边框
                        area: ['840px', '620px'], // 宽高
                        content: '<%=request.getContextPath()%>/FireIncidentServlet?action=editIncident&incidentId=' + data.incidentId
                    });
                }
            });
        });
    </script>
</div>
<body>

</body>
</html>
