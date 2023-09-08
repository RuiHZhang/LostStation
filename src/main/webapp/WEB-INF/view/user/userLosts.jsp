<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2023/8/18
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>userLosts</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<style>
    #searchArea select{
        width: 100px;
        height: 30px;
    }
    #searchArea input{
        width: 100px;
        height: 30px;
    }
    #tab{
        padding: 0 160px;
        background-color: rgb(247,247,247);
    }
</style>
<body>
    <div id="tab">
        <a href="/lost/showPartLosts" >首页</a>
    </div>
    <div style="padding: 0 120px">
        <div id="table">
            <table class="table table-striped table-view">
                <c:forEach items="${losts}" var="lost">
                    <tr>
                        <td><img src="/image/lost/${lost.lostimg}" style="width: 60px;height: 75px"/></td>
                        <td>
                            <p>寻物启示：${lost.lostname}</p>
                            <p>失物类别：${lost.losttype.typename}</p>
                            <p>物品状态：${lost.loststatus.statusdesc}</p>
                        </td>
                        <td>
                            <br>
                            <br>
                            <p>时间：<fmt:formatDate value="${lost.losttime}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
                        </td>
                        <td>
                            <p>失主简要信息</p>
                            <p>失主姓名：${lost.lostuser.username}</p>
                            <p>失主练习方式：${lost.lostuser.usertel}</p>
                        </td>
                        <td>
                            <p>丢失具体情况:</p>
                            <p>&emsp;&emsp;${lost.lostdesc}</p>
                        </td>
                        <td>
                            <p>详细信息</p>
                            <a href="/lost/getLostById/${lost.lostid}">查看详细信息</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</table>
</body>
<script type="text/javascript">

</script>
</html>
