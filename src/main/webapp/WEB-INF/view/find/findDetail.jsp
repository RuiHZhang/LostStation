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
    <title>findDetail</title>
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
        }
        body html{
            width: 100%;
            height: 100%;
        }
        #container{
            height: 500px;
            /*background-color: red;*/
            padding: 0 160px;
        }

        #imgArea{
            display: inline-block;
            width: 30%;
            height: 100%;
            /*background-color: lightskyblue;*/
            position: relative;
            float: left;
        }
        #imgArea img{
            display: block;
            width:80%;
            height: 75%;
            text-align: center;
            position: absolute;
            margin: 0px 33px;
        }

        #detailArea{
            display: inline-block;
            width: 30%;
            height: 100%;
            /*background-color: aquamarine;*/
            margin: 0 4%;
        }
        #detailArea p{
            margin: 30px auto;
        }

        #userArea{
            display: inline-block;
            width: 30%;
            height: 100%;
            /*background-color: blue;*/
            float: right;
        }
        #userArea p{
            margin: 30px auto;
        }


        #commentArea{
            padding: 0 160px;
            background-color: rgb(242, 244, 251);
            font-size: 16px;
        }
        #commentArea .row{
            /*margin: 5px 0;*/
        }
        #tab{
            padding: 0 160px;
            background-color: rgb(247,247,247);
        }
    </style>
</head>
<body>
    <div id="tab">
        <a href="/lost/showPartLosts" >首页</a>
    </div>
    <div id="container">
        <div id="imgArea">
            <span style="color: white">123</span>
            <img src="/image/find/huaweiP30.jpg" />
        </div>

        <div id="detailArea">
            <p><font style="font-size: 20px">物品类别：</font>${find.findtype.typename}</p>
            <p><font style="font-size: 20px">物品信息：</font>${find.findname}</p>
            <p><font style="font-size: 20px">具体情况：</font><textarea style="width: 310px;height: 100px">${find.finddesc}</textarea></p>
            <p><font style="font-size: 20px">物品现在状态：</font>${find.findstatus.statusdesc}</p>
            <p><font style="font-size: 20px">丢失大致时间：</font><fmt:formatDate value="${find.findtime}" pattern="yyyy-MM-dd" /></p>
        </div>

        <div id="userArea">
            <p><font style="font-size: 20px">雷锋姓名：</font>${find.finduser.username}</p>
            <p><font style="font-size: 20px">雷锋性别：</font>${find.finduser.usergender}</p>
            <p><font style="font-size: 20px">雷锋联系方式：</font>${find.finduser.usertel}</p>
            <p><font style="font-size: 20px">雷锋所在年级：</font>${find.finduser.usergrade.gradename}</p>
            <p><font style="font-size: 20px">雷锋所在校区：</font>${find.finduser.userlocation.locationname}</p>
        </div>


    </div>
    <div id="commentArea">
        <p>评论区域:</p>
        <div class="container" >
            <div class="row">
                <form>
                    <div class="col-md-9"><input type="text" id="content" placeholder="请发表一条友善的评论" style="width: 100%;height: 60px"/> </div>
                    <div class="col-md-3"><a onclick="postComment(${lost.lostid},${user.userid})" style="cursor: pointer">发表评论</a></div>
                </form>
            </div>
            <div id="commentAllContents">
<%--                动态渲染数据的容器--%>
            </div>
        </div>
    </div>
</body>
<script>
    $(document).ready(function (){
        //在首次进入当前页面时，异步获取这个商品的所有评论信息，然后返回并渲染到评论区
        $.ajax({
            type: "get",
            url: "/comment/getAllCommentsByLostId/${lost.lostid}",
            dataType: "json",
            async:false,
            success:function(data) {
                console.log(data)
                $("#commentAllContents").empty(); //select置空
                var data1 = data.data;  //每一项的数据data
                if (data1.length>0){
                    $.each(data1, function (index, item) {
                        $("#commentAllContents").prepend(
                            `
                                <div class="row">
                                    <div class="col-md-9"><p>${'${item.ccontent}'}</p></div>
                                    <div class="col-md-3"><p>${"${item.user.username}"}&emsp;&emsp;&emsp;${"${item.commenttime}"}</p></div>
                                </div>
                            `
                        );
                    });
                }
                layui.form.render();    //一定要最后重新渲染一下
            }
        });
    })

    //发布评论方法
    function postComment(lostid,userid){
        var content = $("#content").val();
        //当点击发表评论后进行异步请求，获取该物品所有的评论信息动态的展示到评论区
        $.ajax({
            type: "post",
            url: "/comment/addComment?lostid="+lostid+"&userid="+userid+"&content="+content+"",
            dataType: "json",
            async:false,
            success:function(data) {
                $("#commentAllContents").empty(); //select置空
                var data1 = data.data;  //每一项的数据data
                if (data1.length>0){
                    $.each(data1, function (index, item) {
                        $("#commentAllContents").prepend(
                            `
                                <div class="row">
                                    <div class="col-md-9"><p>${'${item.ccontent}'}</p></div>
                                    <div class="col-md-3"><p>${"${item.user.username}"}&emsp;&emsp;&emsp;${"${item.commenttime}"}</p></div>
                                </div>
                            `
                        );
                    });
                }
                layui.form.render();    //一定要最后重新渲染一下
            }
        });
        //暂时以页面刷新代替异步刷新，后序有更好的方法再改
        // window.location.reload();
    }
</script>
</html>
