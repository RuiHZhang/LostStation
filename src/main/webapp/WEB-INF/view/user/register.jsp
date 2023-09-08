<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2023/7/25
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
</head>
<body>
<div class="container" id="app" style="width: 40%;margin: 0 auto">
    <div class="row">
        <div class="col-md-6 col-md-offset-3" style="height: 520px;border: 1px solid black;margin-top: 80px; border-radius: 8px; ">
            <div class="row">
                <div class="col-md-12" style="text-align: center;font-size: 50px;font-weight: bold;margin-top: 50px;">
                    用户注册
                </div>
                <form class="layui-form" action="/user/register" method="post">
                    <div class="layui-form-item" style="width: 60%;margin: 15px auto">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" required id="username" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux" id="helpText"></div>
                    </div>
                    <div class="layui-form-item" style="width: 60%;margin: 15px auto">
                        <label class="layui-form-label">密码框</label>
                        <div class="layui-input-block">
                            <input type="password" name="userpass" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
<%--                        <div class="layui-form-mid layui-word-aux">辅助文字</div>--%>
                    </div>
                    <div class="layui-form-item" style="width: 60%;margin: 15px auto">
                        <label class="layui-form-label">手机号码</label>
                        <div class="layui-input-block">
                            <input type="text" name="usertel" required  lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div style="width: 50%;margin: 15px auto">
                        <select name="usergender" lay-verify="" >
                            <option value="">请选择您的性别</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                    <div style="width: 50%;margin: 15px auto">
                        <select name="usergrade" lay-verify="" id="grade">

                        </select>
                    </div>
                    <div style="width: 50%;margin: 15px auto">
                        <select name="userlocation" lay-verify="" id="location">
                        </select>
                    </div>

                    <div class="layui-form-item" align="center" >
                        <div class="layui-input-block" style="left: -55px">
                            <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit">立即注册</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            <button class="layui-btn"><a href="/user/goLogin" style="color: white">前往登录</a></button>
                        </div>
                    </div>
                </form>
        </div>
    </div>
</div>
</div>
</body>
<script>
    $(document).ready(function () {
        $.ajax({
            //动态给用户年级select添加值
            type: "get",
            url: "/grade/getAllGrades",
            dataType: "json",
            async:false,
            success:function(data) {
                $("#grade").empty(); //select置空
                $("#grade").append(new Option("请选择您的年级"));
                // console.log(data)
                var data1 = data.data;  //每一项的数据data
                if (data1.length>0){
                    $.each(data1, function (index, item) {
                        $("#grade").append(new Option(item.gradename,item.gradeid));
                    });
                }
                layui.form.render();    //一定要最后重新渲染一下
            }
        });

        $.ajax({
            //动态给select添加值
            type: "get",
            url: "/location/getAllLocations",
            dataType: "json",
            async:false,
            success:function(data) {
                $("#location").empty(); //select置空
                $("#location").append(new Option("请选择您的校区"));
                // console.log(data)
                var data1 = data.data;  //每一项的数据data
                if (data1.length>0){
                    $.each(data1, function (index, item) {
                        $("#location").append(new Option(item.locationname,item.locationid));
                    });
                }
                layui.form.render();    //一定要最后重新渲染一下
            }
        });
    })

    $("#username").blur(function () {
        $.ajax({
            type:'get',
            url:'/user/userNameIsExist?username='+this.value,
            dataType:'json',
            async:false,
            success:function (data) {
                if(true == data){
                    $("#helpText").html(`<font color = red>exists</font>`)
                }else{
                    $("#helpText").html(`<font color = green>able</font>`)
                }
            }
        })
    })
</script>
</html>
