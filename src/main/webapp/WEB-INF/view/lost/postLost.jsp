<%--
  Created by IntelliJ IDEA.
  User: zrh
  Date: 2023/8/21
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>postLost</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js"></script>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    html body{
        width: 100%;
        height: 100%;
    }
    #container{
        height: 740px;
        background-color: rgb(247,247,247);
        padding: 0 160px;
        margin: 0 auto;
    }
    #formArea{
        width: 50%;
        height: 620px;
        margin: 0 auto;
        padding: 40px;
        border-radius: 50px;
        background-color: rgb(127, 255, 212);
    }
</style>
<body>
    <div id="container">
        <div id="formArea">
            <h1 style="text-align: center">丢失物品发布</h1><br>
            <form class="layui-form" action="/lost/postLost" enctype="multipart/form-data" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">物品名称：</label>
                    <div class="layui-input-block">
                        <input type="text" name="lostname" lay-verify="title" autocomplete="off" placeholder="请输入丢失物品名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">物品图片：</label>
                    <div class="layui-upload-drag" id="test10">
                        <i class="layui-icon"></i>
                        <p>点击上传，或将文件拖拽到此处</p>
                        <div class="layui-hide" id="uploadDemoView">
                            <hr>
                            <img src="" alt="上传成功后渲染" style="max-width: 50px">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">详细描述：</label>
                    <div class="layui-input-block">
                        <textarea name="lostdesc" placeholder="请输入丢失物品详细信息" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">丢失时间：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="losttime" id="date" lay-verify="datetime" placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">物品类别：</label>
                    <div class="layui-input-block">
                        <select name="losttype" lay-filter="aihao" id="losttype">
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">物品状态：</label>
                    <div class="layui-input-block">
                        <select name="loststatus" lay-filter="aihao" id="loststatus">
                        </select>
                    </div>
                </div>

                <div class="layui-form-item" >
                    <div class="layui-input-block" style="margin: 0 auto;left: 230px">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即发布</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
    layui.use(['form', 'layedit', 'laydate','upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate
            ,upload = layui.upload;

        //日期，可以设置时间的格式，是否包含时间等
        laydate.render({
            elem: '#date',
            type:'datetime'
        });

        //拖曳上传的js动态效果
        upload.render({
            elem: '#test10'
            ,type:'post'
            ,url: '/lost/fileUpLoad' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
            ,done: function(res){
                console.log(res);
                layer.msg('上传成功');
                layui.$('#uploadDemoView').removeClass('layui-hide').find('img').attr('src', res.file);

            }
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });
    });

    //页面加载时从数据库中获取类型、状态的值动态加到select上
    $(document).ready(function () {
        $.ajax({
            //动态给elect添加商品类型值
            type: "get",
            url: "/type/getAllTypes",
            dataType: "json",
            async:false,
            success:function(data) {
                $("#losttype").empty(); //select置空
                $("#losttype").append(new Option("请选择物品类型"));
                console.log(data)
                var data1 = data.data;  //每一项的数据data
                if (data1.length>0){
                    $.each(data1, function (index, item) {
                        $("#losttype").append(new Option(item.typename,item.typeid));
                    });
                }
                layui.form.render();    //一定要最后重新渲染一下
            }
        });

        $.ajax({
            //动态给select添加值
            type: "get",
            url: "/status/getAllStatus",
            dataType: "json",
            async:false,
            success:function(data) {
                $("#loststatus").empty(); //select置空
                $("#loststatus").append(new Option("请选择商品状态"));
                console.log(data)
                var data1 = data.data;  //每一项的数据data
                if (data1.length>0){
                    $.each(data1, function (index, item) {
                        $("#loststatus").append(new Option(item.statusdesc,item.statusid));
                    });
                }
                layui.form.render();    //一定要最后重新渲染一下
            }
        });
    })
</script>
</html>
