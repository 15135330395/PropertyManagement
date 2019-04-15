<%--
 Created by IntelliJ IDEA.
 User: Administrator
 Date: 2019/3/28
 Time: 10:17
 To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../Background/info.jsp" %>

<html>
<head>
    <title>签报列表</title>

    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%-- <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />--%>
    <meta http-equiv="Cache-Control" content="no-siteapp" />
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a><cite>签报列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-hide" id="tab" lay-filter="test"></table> <%--头工具栏操纵"test"--%>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">

            <button class="layui-btn layui-btn-danger"  lay-event="deleteAll"><i class="layui-icon"></i>批量删除</button>

        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/javascript" id="publishDate">
        {{ dateFormat(d.publishDate) }}
    </script>
</div>
</body>
<%--<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
--%>
<script>
    layui.use('table', function(){
        var table = layui.table;
       alert(123)
        table.render({

            elem: '#tab'
            //Servlet 返回一个json字符串
            ,url:'<%=request.getContextPath()%>/BookServlet?action=queryPage'  //layui中URL：绝对路径和servlet之间没有加/,
            ,toolbar: '#toolbarDemo'
            ,title: '签报列表'
            ,cols: [[
                {type:'checkbox', fixed: 'left'}  //左边的选择框
                ,{field:'bId', title:'ID', width:'10%', fixed: 'left', unresize: true, sort: true} //sort 排序
                ,{field:'name', title:'书名', width:'10%' }
                ,{field:'price', title:'价格', width:'10%'}
                ,{field:'publishDate', title:'出版日期', width:'10%' , templet:'#publishDate'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
            ]]
            ,page: true  //传入json字符串后，自动分页
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            if(obj.event=='deleteAll'){

                /* alert(123)*/
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                if(data==""){
                    layer.msg('请至少选择1条数据');
                    return;
                }
                var ids="";
                for(var i=0;i<data.length;i++){
                    ids+=data[i].reportId;
                    ids+=","
                }
                layer.confirm('确认删除这些信息吗?',function(index){
                    $.ajax({
                        type: "post",
                        url: "<%=request.getContextPath()%>/BookServlet",
                        data: "action=deleteAll&ids="+ids,
                        success: function(msg){
                            if(msg>0){
                                layer.msg('删除'+ msg +'条数据成功',{icon:1,time:1000});
                            }else {
                                layer.msg('已删除或不存在!',{icon:2,time:1000});
                            }
                            setTimeout("location.reload()",2000);
                        }
                    });
                });
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){

                    $.ajax({
                        type:"POST",
                        url:"<%=request.getContextPath()%>/BookServlet" ,
                        data: "action=delete&reportId="+data.reportId ,
                        success : function(msg){
                            /*var rc=eval("("+msg+")");*//* 转js对象*/
                            if(msg==0){
                                layer.msg("签报已删除或不存在",{icon:2,time:2000} );
                            }else{
                                layer.msg("删除成功",{icon:1,time:2000} );
                                location.reload();
                            }
                        }
                    });
                    /*  layer.close(index);*/
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type:2,
                    title: "修改信息" ,
                    closeBtn: 1, //不显示关闭按钮
                    area: [ '800px','700px'],
                    offset: 'auto' , //右下角弹出
                    anim: 2,
                    content: ['<%=request.getContextPath()%>/BookServlet?action=queryOneBack&reportId='+data.reportId]  //iframe的url，no代表不显示滚动条
                })
            }
        });
    });
</script>




<%--<script>
   /*弹出hello world 信息表示成功进入该页面。
    地址发生改变，有没有获取到数据时，测试
    可以在转发，进入新的页面，jsp时都弹出信息，打印信息，来测试是否传递成功
   */
    layui.use(['layer','form'],function(){
        var layer=layui.layer
            ,form=layui.form;
        layer.msg('Hello World')

    });

</script>--%>


</html>
