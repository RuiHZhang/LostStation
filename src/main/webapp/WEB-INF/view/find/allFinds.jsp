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
    <title>allLosts</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
</head>
<style>
    #searchArea{

    }
    #searchArea #type{
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
        <div id="searchArea">
            <label for="type">分类：</label>
            <select id="type">
            </select>
        </div>
        <div id="table">
            <table class="table table-striped table-view">
                <c:forEach items="${pageBean.list}" var="find">
                    <tr>
                        <td><img src="/image/lost/daily/lostkey01.jpg" style="width: 60px;height: 75px"/></td>
                        <td>
                            <p>寻物启示：${find.findname}</p>
                            <p>失物类别：${find.findtype.typename}</p>
                            <p>物品状态：${find.findstatus.statusdesc}</p>
                        </td>
                        <td>
                            <br>
                            <br>
                            <p>时间：<fmt:formatDate value="${find.findtime}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
                        </td>
                        <td>
                            <p>失主简要信息</p>
                            <p>失主姓名：${find.finduser.username}</p>
                            <p>失主联系方式：${find.finduser.usertel}</p>
                        </td>
                        <td>
                            <p>丢失具体情况:</p>
                            <p>&emsp;&emsp;${find.finddesc}</p>
                        </td>
                        <td>
                            <p>详细信息</p>
                            <a href="/find/getFindById/${find.findid}">查看详细信息</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <%--  分页数字形式  --%>
        <div style="margin: 0 auto;text-align: center">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/find/getFindsByPage?&cp=1&ps=${pageBean.ps}" target="_self">首页</a></li>
                <c:forEach var="i" begin="1" end="${pageBean.totalPage}">
                    <li class="page-item"><a class="page-link" href="/find/getFindsByPage?&cp=${i}&ps=${pageBean.ps}" target="_self">${i}</a></li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="/find/getFindsByPage?&cp=${pageBean.totalPage}&ps=${pageBean.ps}" target="_self">尾页</a></li>
            </ul>
        </div>
    </div>
</table>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            //动态给用户年级select添加值
            type: "get",
            url: "/type/getAllTypes",
            dataType: "json",
            async:false,
            success:function(data) {
                $("#type").empty(); //select置空
                $("#type").append(new Option("全部"));
                // console.log(data)
                var data1 = data.data;  //每一项的数据data
                if (data1.length>0){
                    $.each(data1, function (index, item) {
                        $("#type").append(new Option(item.typename,item.typeid));
                    });
                }
                layui.form.render();    //一定要最后重新渲染一下
            }
        });
    })
</script>
</html>
