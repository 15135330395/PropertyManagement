<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commons/info.jsp"%>
<html>
<head>
    <title>新闻分类</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#"><cite>首页</cite></a>
        <a><cite>合同列表维护</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="tab" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-danger" lay-event="deleteAll"><i class="layui-icon"></i>批量删除</button>
            <button class="layui-btn" lay-event="toadd"><i class="layui-icon"></i>添加</button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

   <%-- <script type="text/javascript" id="sigingDate">
        {{ dateFormat(d.reportDate) }}
    </script>--%>
</div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#tab'
            // Servlet 返回一个json字符串
            ,url:'<%=request.getContextPath()%>/ContractServlet?action=queryPage'
            ,toolbar: '#toolbarDemo'
            ,title: '合同列表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                 ,{field:'id', title:'ID', width:'5%', fixed: 'left', unresize: true, sort: true}
                ,{field:'contractId', title:'合同编号', width:'10%'}
                ,{field:'contractName', title:'合同名称', width:'10%'}
                ,{field:'firstParty', title:'甲方', width:'5%'}
                ,{field:'secondParty', title:'乙方', width:'5%'}
                ,{field:'sigingDate', title:'签约日期', width:'10%'   }
                ,{field:'projectLocation', title:'项目位置', width:'10%'}
                ,{field:'cost', title:'项目报价', width:'5%'}
                ,{field:'content', title:'合约内容', width:'10%'}
                ,{field:'supplyChain', title:'供应链选择', width:'10%'}
                ,{field:'paymentCycle', title:'付款周期', width:'5%'}
                ,{field:'acceptanceResult', title:'验收结果', width:'5%'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]]
            ,page: true
        });
      //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
          /*alert(123);*/
            switch(obj.event){
                case 'deleteAll':
                    var data = checkStatus.data;
                    if(data==""){
                        layer.msg('请至少选择1条数据');
                        return;
                    }
                    var ids="";
                    for(var i=0;i<data.length;i++){
                        ids+=data[i].id
                        ids+=","
                    }
                    layer.confirm('确认要删除这些信息吗？',function(index) {
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/ContractServlet",
                            data: "action=deleteAll&ids=" + ids,
                            success: function (msg) {
                                if (msg > 0) {
                                    //捉到所有被选中的，发异步进行删除
                                    layer.msg('成功删除' + msg + '条数据', {icon: 1})
                                } else {
                                    layer.msg('已删除或不存在!', {icon: 2, time: 1000});
                                }
                                location.reload();
                            }
                        });

                    });
                    break;
                case 'toadd':
                    //iframe窗
                    layer.open({
                        type: 2,
                        title: "添加信息",
                        closeBtn: 1, //不显示关闭按钮
                        shade: [0],
                        area: ['800px', '700px'],
                        offset: 'auto', //右下角弹出
                        anim: 2,
                        content: ['contractAdd.jsp'], //iframe的url，no代表不显示滚动条 , 'no'
                        end: function(){ //此处用于演示 关闭之后执行
                            alert(123)
                        }
                    });
                    break;
            };
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){
             /*  console.log("==================");*/
            var data = obj.data;
            //console.log(obj)

            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    layer.close(index);
                    $.ajax({
                        type:"post",
                        url:"<%=request.getContextPath()%>/ContractServlet",
                        data:"action=delete&id="+data.id,
                        success:function(msg){
                            obj.del();
                            if(msg==0){
                                layer.msg("已被删除或不存在",{icon:2,time:2000});
                            }else{
                                layer.msg("删除成功",{icon:1,time:1000});
                            }
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2,
                    title: "修改信息",
                    closeBtn: 1, //不显示关闭按钮
                    area: ['800px', '700px'],
                    offset: 'auto', //右下角弹出
                    anim: 2,
                    content: ['<%=request.getContextPath()%>/ContractServlet?action=queryOneBack&id='+data.id] //iframe的url，no代表不显示滚动条

                });
            }
        });
    });
</script>

</html>


