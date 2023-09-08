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
    <title>login</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
</head>
<body>
<div class="container" id="app" style="width: 40%;height: 100px ;margin: 0 auto">
    <div class="row">
        <div class="col-md-6 col-md-offset-3" style="height: 410px;border: 1px solid black;margin-top: 80px; border-radius: 8px; ">
            <div class="row">
                <div class="col-md-12" style="text-align: center;font-size: 50px;font-weight: bold;margin-top: 50px;">
                    用户登录
                </div>
<%--                <form method="post" action="/user/login" class="">--%>
<%--                    username:<input name="username" type="text" /><br>--%>
<%--                    userpass:<input name="userpass" type="password" /><br>--%>
<%--                    <input type="submit" value="登录" />--%>
<%--                </form>--%>
                <form class="layui-form" action="/user/login" method="post">
                    <div class="layui-form-item" style="width: 60%;margin: 15px auto">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="username" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item" style="width: 60%;margin: 15px auto">
                        <label class="layui-form-label">密码框</label>
                        <div class="layui-input-block">
                            <input type="password" name="userpass" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
<%--                        <div class="layui-form-mid layui-word-aux">辅助文字</div>--%>
                    </div>
                    <div class="layui-form-item" align="center" >
                        <div class="layui-input-block" style="left: -55px">
                            <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit">登录</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            <button class="layui-btn"><a href="/user/goRegister" style="color: white">前往注册</a></button>
                        </div>
                    </div>
                </form>
        </div>
    </div>
</div>
</div>
</body>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</html>
