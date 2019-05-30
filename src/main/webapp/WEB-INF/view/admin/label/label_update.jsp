<%--
  Created by IntelliJ IDEA.
  User: 18235
  Date: 2019/5/27
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/plugin/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]--></head>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">
                    <span class="x-red">*</span>标签</label>
                <div class="layui-input-inline">
                    <input type="text" id="L_email" name="email" required="" lay-verify="email" autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>输入修改后的标签名</div></div>
            <div class="layui-form-item">
                <label  class="layui-form-label"></label>
                <button class="layui-btn" onclick="updateLabel()">确认修改</button></div>
        </form>
    </div>
</div>
<script type="text/javascript">
    <%--添加按钮点击之后添加到数据库操作--%>
    function updateLabel(){
        var update_name = $("#L_email").val();
        if(update_name==""){
            alert("修改的名字不能为空!!");
        }else{
            $.ajax({
                async: false,//同步，待请求完毕后再执行后面的代码
                type: "POST",
                url: '/label_update',
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data: {
                    "id":${id},
                    "new_name":update_name
                },
                dataType: "json",
                success: function (data) {
                    if(data.code==1) {
                        layer.msg('添加成功',{icon:1,time:3000});
                    } else {
                        layer.msg('添加失败',{icon:1,time:1000});
                    }
                },
                error: function () {
                    alert("数据获取失败")
                }
            })
        }
    }
</script>
</body>
</html>
