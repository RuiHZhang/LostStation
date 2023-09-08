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
    <title>updateUser</title>
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
    <form action="/user/updateUser" method="post" enctype="multipart/form-data">
        <p><label for="userimg">用户头像：</label><input type="file" name="userimg" id="userimg"></p>
        <p><label for="userid">用户id：</label><input type="text" name="userid" id="userid" readonly value="${user.userid}"></p>
        <p><label for="username">用户姓名：</label></font><input id="username" name="username" value="${user.username}" type="text" /></p>
        <p><label for="username">用户密码：</label></font><input id="userpass" name="userpass" value="${user.userpass}" type="password" /></p>
        <p><label>用户性别：</label></font><input value="${user.usergender}" type="text" name="usergender"/></p>
        <p><label>用户联系方式：</label></font><input value="${user.usertel}" type="text" name="usertel"/></p>
        <p><label>用户所在年级：</label></font><select name="usergrade" id="grade"></select></p>
        <p><label>用户所在校区：</label></font><select name="userlocation" id="location"></select></p>
<%--        <button id="btn">123</button>--%>
        <input type="submit"  value="点击保存" id="btn">
    </form>
    <button class="button btn-danger" id="cancel" >取消编辑</button>
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
                // console.log(data)
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

    $("#btn").click(function (){
        parent.window.location.reload();
    })

    $("#cancel").click(function () {
        window.location.href = "/user/goUserDetailChild"
    })
</script>
</html>
