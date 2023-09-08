<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2023/7/29
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>main</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
    <style type="text/css">
      *{
        margin: 0;
        padding: 0;
      }
      html,body{
        width: 100%;
      }
      a{
        text-decoration: none;
      }
      #fix-part{
        position: fixed;
        width: 100%;
        height: 60px;
        background-color: black;
        z-index: 99;
      }
      #fix-left{
        display: inline-block;
        width: 40px;
        height: 40px;
        margin: 10px;
        position: absolute;
      }
      #fix-left img{
        width: 100%;
        height: 100%;
      }
      #fix-center{
        display: inline-block;
        width: 75%;
        height: 60px;
        margin: 0 auto;
        position: absolute;
        left: 12.5%;
        /*background-color: red;*/
        overflow: hidden;
      }
      #fix-center a{
        display: inline-block;
        margin: 15px;
        margin-top: 18px;
        color: white;
        font-size: 15px;
      }
      #fix-center a:first-child{
        margin-left: 0;
      }
      #fix-center a:last-child{
        margin-right: 10px;
      }
      #fix-center a:hover{
        color: orange;
      }
      #fix-right{
        display: inline-block;
        /*background-color: red;*/
        position: absolute;
        right: 10px;
      }
      #fix-right a{
        display: inline-block;
        margin: 15px;
        color: white;
      }
      #fix-right a:hover{
        color: orange;
      }
      #fix-right span{
        color: white;
      }

      #content-body{
        padding-top: 60px;
        height: 800px;
        position: relative;
        /*background-color: lightskyblue;*/
      }

      #content-body table{
        font-size: 14px;
      }

      #content-body .myRow-right{
        width: 100%;
        height: 100%;
        /*background-color: aqua;*/
        display: inline-block;
        float: right;
      }

      .myRow-right table{
        width: 100%;
        height: 100%;
        border: none;
        text-align: center;
      }

      .myRow-right table tr td{
        display: inline-block;
      }

      .myRow-right table img{
        display: inline-block;
        width: 50%;
        height: 50%;
        position: relative;
        right: -4px;
      }

      .myRow-right table tr{
        width: 100%;
        height: 50%;
      }

      .myRow-right table tr td{
        display: inline-block;
        width: 23%;
        height: 100%;
        padding: 10px;
      }
      .myRow-right table tr td p{
        font-size: 14px;
        margin: 25px 0;
      }
      #carousel img{
        width: 100%;
        height: 100%;
      }

    </style>
  </head>
  <body>
  <div id="content">
    <div id="fix-part">
      <div id="fix-left">
      </div>

      <div id="fix-center">
        <a href="/user/goMain"><span style="color: orange;">网站首页</span></a>
        <a href="/find/showPartFinds">失物招领大厅</a>
        <a href="/find/goPostFind">失物信息发布</a>
        <a href="/lost/showPartLosts">寻物大厅</a>
        <a href="/lost/goPostLost">寻物发布</a>
      </div>

      <div id="fix-right">
        <c:if test="${user != null}">
          <a href="/user/goUserDetail" >您好！${user.username}</a>
        </c:if>
        <c:if test="${user == null}">
          <a href="/user/goLogin" >登录</a>
        </c:if>

        <span id="">|</span>

        <c:if test="${user != null}">
          <a href="/user/exitLogin" >退出登录</a>
        </c:if>
        <c:if test="${user == null}">
          <a href="/user/goRegister" >注册</a>
        </c:if>
      </div>
    </div>

    <div id="content-body">
      <div class="myRow-right">
        <div class="layui-carousel" id="test1" lay-filter="test1">
          <div carousel-item="" id="carousel">
            <div><img src="/image/main/scenery1.jpg" /> </div>
            <div><img src="/image/main/scenery2.jpg" /> </div>
            <div><img src="/image/main/scenery3.jpg" /> </div>
            <div><img src="/image/main/scenery5.jpg" /> </div>
            <div><img src="/image/main/scenery4.jpg" /> </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
  <script>
    layui.use(['carousel', 'form'], function(){
      var carousel = layui.carousel
      var form = layui.form;

      //改变下时间间隔、动画类型、高度
      carousel.render({
        elem: '#test1'
        ,interval: 1800
        ,anim: 'fade'
        ,arrow:'always'
        ,height: '730px'
        ,width: '1580px'
        ,autoplay:'true'
      });
    });
  </script>
</html>
