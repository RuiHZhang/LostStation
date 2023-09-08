<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2023/8/18
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userDetail</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
    <style>
        *{
            padding: 0;
            margin: 0;
            font-size: 16px;
        }
        a{
            cursor: pointer;
            text-decoration: none;
        }
        body html{
            width: 100%;
            height: 100%;
        }
        #tab{
            padding: 0 160px;
            background-color: rgb(247,247,247);
        }
        #container{
            height: 700px;
            background-color: rgb(247, 247, 247);
            padding: 0 160px;
        }

        #imgArea{
            display: inline-block;
            width: 20%;
            height: 100%;
            /*background-color: lightskyblue;*/
            position: relative;
            float: left;
        }
        #imgArea #top{
            height: 40%;
            background-color: rgb(244, 244, 244);
            position: relative;

        }
        #top div{
            width: 50%;
            position: absolute;
            top:165px;
            left: 25%;
            text-align: center;
            font-size: 16px;
        }
        #imgArea #bottom{
            height: 60%;
            background-color: rgb(255, 255, 255);
        }

        #bottom div{
            height: 20%;
            line-height: 80px;
            text-align: center;
        }

        #imgArea img{
            display: block;
            width:50%;
            height: 60%;
            text-align: center;
            position: absolute;
            left: 25%;
            border-radius: 100px;
        }

        #userArea{
            display: inline-block;
            width: 45%;
            height: 100%;
            background-color: white;
            margin-left: 30px;
            float: left;
        }
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
        #userArea p{
            margin: 30px auto;
        }
    </style>
</head>
<body>
    <div>
        <div id="tab">
            <a href="/lost/showPartLosts" >首页</a>
        </div>
        <div id="container">
            <%--        <div><a style="cursor: pointer">首页</a></div>--%>
            <div id="imgArea">
                <div id="top">
                    <img src="/image/user/${user.userimg}" />
                    <div>${user.username}</div>
                    <div style="top: 195px">${user.usertel}</div>
                </div>

                <div id="bottom">
                    <div><a href="/user/goUserDetailChild" target="iframe">个人信息</a></div>
                    <div><a href="/lost/getLostsByUserId" target="iframe">我发布的丢失物品信息</a></div>
                    <div><a>隐私中心</a></div>
                    <div><a>绑定授权</a></div>
                    <div><a>帮助中心</a></div>
                </div>

            </div>

            <div id="userArea">
                <iframe height="700px" width="1000px" name="iframe" src="/user/goUserDetailChild">

                </iframe>
            </div>
        </div>
    </div>
</body>
<script>

</script>
</html>
