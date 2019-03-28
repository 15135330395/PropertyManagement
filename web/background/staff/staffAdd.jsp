<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28 0028
  Time: 上午 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../commons/info.jsp"%>
<html>
<head>
    <title>编辑信息</title>
</head>
<body>
<div class="layui-container" style="padding: 20px">
    <form class="layui-form" action="">
        <input type="hidden" name="staffId" value="${staff.staffId}" autocomplete="off" class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名：</label>
            <div class="layui-input-inline">
                <input type="text" name="staffName" required value="${staff.staffName}"  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">年龄：</label>
            <div class="layui-input-inline">
                <input type="number" name="age" required value="${staff.age}"  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-upload "align="right" >
                <button type="button" class="layui-btn layui-btn-sm" id="test2" >上传照片</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo1" style="width: 87px;height: 130px;">
                    <p id="demoText"></p>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号：</label>
            <div class="layui-input-inline">
                <input type="text" name="identityCard" required lay-verify="identity" value="${staff.identityCard}"  placeholder="请输入身份证" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">家庭住址：</label>
            <div class="layui-input-inline">
                <input type="text" name="address" required lay-verify="required" value="${staff.address}"  placeholder="请输入家庭住址" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-inline">
                <c:if test="${staff.sex=='男'}">
                    <input type="radio" name="sex"  value="${staff.sex}" title="男" checked  >
                </c:if>
                <c:if test="${staff.sex!='男'}">
                    <input type="radio" name="sex"  value="${staff.sex}" title="男"   >
                </c:if>
                <c:if test="${staff.sex=='女'}">
                    <input type="radio" name="sex"  value="${staff.sex}" title="女" checked  >
                </c:if>
                <c:if test="${staff.sex!='女'}">
                    <input type="radio" name="sex"  value="${staff.sex}" title="女"   >
                </c:if>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱：</label>
            <div class="layui-input-inline">
                <input type="text" name="email" required lay-verify="email" value="${staff.email}"  placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">所在城市：</label>
            <div class="layui-input-inline">
                <input type="text" name="city" required lay-verify="required" value="${staff.city}"  placeholder="请输入所在城市" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">籍贯：</label>
            <div class="layui-input-inline">
                <input type="text" name="household" required lay-verify="required" value="${staff.household}"  placeholder="请输入籍贯" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职位：</label>
            <div class="layui-input-inline">
                <input type="text" name="station" required lay-verify="required" value="${staff.station}"  placeholder="请输入职位" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">学历：</label>
            <div class="layui-input-inline">
                <input type="text" name="education" required lay-verify="required" value="${staff.education}"  placeholder="请输入学历" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">电话号码：</label>
            <div class="layui-input-inline">
                <input type="tel" name="phone" required lay-verify="phone" value="${staff.phone}"  placeholder="请输入电话号码" autocomplete="off" class="layui-input">
            </div>

        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">所属部门：</label>
            <div class="layui-input-block">
                <input type="hidden" name="departmentId" value="${staff.departmentId}" autocomplete="off" class="layui-input">
                <%--<select name="" >
                    <option value=""></option>
                    <c:forEach items="${typeList}" var="type">
                        <c:if test="${type.typeId == news.typeId}">
                            <option selected value="${type.typeId}">${type.typeName}</option>
                        </c:if>
                        <c:if test="${type.typeId != news.typeId}">
                            <option value="${type.typeId}">${type.typeName}</option>
                        </c:if>

                    </c:forEach>
                </select>--%>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">入职时间：</label>
            <div class="layui-input-inline">
                <input type="text" name="joinTime" value="${staff.joinTime}"  lay-verify="required" placeholder="请选择入职时间"class="layui-input" id="test1">
            </div>
            <label class="layui-form-label">社保号：</label>
            <div class="layui-input-inline">
                <input type="text" name="securityInsuranceId" value="${staff.securityInsuranceId}"  lay-verify="required" class="layui-input" placeholder="请输入社保号" >
            </div>
            <label class="layui-form-label">工资号：</label>
            <div class="layui-input-inline">
                <input type="text" name="salaryId" value="${staff.salaryId}"  lay-verify="required" class="layui-input" placeholder="请输入工资号">
            </div>

        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="submitSave">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    //Demo
    layui.use(['laydate','form','upload'], function(){
        var form = layui.form;
        var laydate = layui.laydate;
        var $ = layui.jquery
            ,upload = layui.upload;
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test2'
            ,url: '<%=request.getContextPath()%>/uploadImage'

            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
        //监听提交
        form.on('submit(submitSave)', function(data){
            var staffId = data.field.staffId;
            var staffName = data.field.staffName;
            var identityCard = data.field.identityCard;
            var age = data.field.age;
            var sex = data.field.sex;
            var address = data.field.address;
            var phone = data.field.phone;
            var email = data.field.email;
            var city = data.field.city;
            var household = data.field.household;
            var station = data.field.station;
            var departmentId = data.field.departmentId;
            var salaryId = data.field.salaryId;
            var securityInsuranceId = data.field.securityInsuranceId;
            var joinTime = data.field.joinTime;



            if(staffId!=""){
                $.ajax({
                    type:"post",
                    url:"StaffServlet",
                    data:{
                        "action":"update",
                        "staffId":staffId,
                        "staffName":staffName,
                        "identityCard":identityCard,
                        "age":age,
                        "sex":sex,
                        "address":address,
                        "phone":phone,
                        "email":email,
                        "city":city,
                        "household":household,
                        "station":station,
                        "departmentId":departmentId,
                        "salaryId":salaryId,
                        "securityInsuranceId":securityInsuranceId,
                        "joinTime":joinTime
                    },
                    success:function(msgData){
                        layer.msg("修改成功",{icon:1,time:1000});
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        setTimeout("parent.layer.close(index)",1000)
                        setTimeout("window.parent.location.reload()",1000)
                    }
                })
            }else {
                $.ajax({
                    type:"post",
                    url:"NewsServlet",
                    data:{
                        "action":"add",
                        "staffName":staffName,
                        "identityCard":identityCard,
                        "age":age,
                        "sex":sex,
                        "address":address,
                        "phone":phone,
                        "email":email,
                        "city":city,
                        "household":household,
                        "station":station,
                        "departmentId":departmentId,
                        "salaryId":salaryId,
                        "securityInsuranceId":securityInsuranceId,
                        "joinTime":joinTime
                    },
                    success:function(msgData){
                        layer.msg("添加成功",{icon:1,time:1000});
                        setTimeout("location.reload()",1000)
                    }
                })
            }

            return false;
        });
        laydate.render({
            elem: '#test1', //指定元素
            type:'datetime'
        });
    });
</script>
</body>
</html>
