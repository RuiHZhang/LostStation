<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2023/8/23
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userDetailChild</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<style>
    #details{
        padding: 0 50px;
        margin-top: 50px;
    }
    #details select{
        width: 150px;
        height: 30px;
    }
    #details p{
        margin: 30px auto;
    }
</style>
<body>
<div id="details">
    <p><label>用户id：</label><span>${user.userid}</span></p>
        <p><label>用户姓名：</label><span>${user.username}</span></p>
        <p><label>用户密码：</label><span>${user.userpass}</span></p>
        <p><label>用户性别：</label><span>${user.usergender}</span></p>
        <p><label>用户联系方式：</label><span>${user.usertel}</span></p>
        <p><label>用户所在年级：</label><span>${user.usergrade.gradename}</span></p>
        <p><label>用户所在校区：</label><span>${user.userlocation.locationname}</span></p>
<%--        <button id="btn">123</button>--%>
        <p><button class="button btn-large" id="btn">点击编辑</button> </p>
</div>
</body>
<script>

    $("#btn").click(function (){
        window.location.href = "/user/goUpdateUser";
    })
</script>
</html>
