<%--
  Created by IntelliJ IDEA.
  User: 18235
  Date: 2019/5/24
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--markdown+jqery+bootstrap--%>
    <link rel="stylesheet" href="lib/editor.md-master/css/editormd.css" />
    <link rel="stylesheet" href="lib/layui/css/layui.css" />
    <script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="plugin/editor.md-master/editormd.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

    <%--复选框美化--%>
        <link rel="stylesheet" href="css/jquery.richUI.min.css" />
        <script type="text/javascript" src="js/jquery.richUI.min.js"></script>
        <script type="text/javascript" src="js/jquery.browser.min.js"></script>
    <script type="text/javascript">
        $(function() {
            //单选
            /*
            * selected: 默认选中值
            */
            $("input[name='status']").richradio();
        });
    </script>
</head>
<body>
<form action="#" id="articleForm">
    <div class="col-xs-4">
        <input type="text" class="form-control" placeholder="输入文章标题" style="margin: 10px" name="articleTitle">
        <input type="text" class="form-control" placeholder="输入类别" style="margin: 10px" name="articleCategory">
        <input type="text" class="form-control" placeholder="输入标签,多个标签以英文逗号分隔, 例: java,mysql  " name="articleLabel" style="margin: 10px">
    </div>
    <div id="test-editor" class="test-editor">
        <%--markdown窗口--%>
        <textarea id="window_markdown" class="window_markdown" style="display:none;">### 关于 Editor.md
**Editor.md** 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。
    </textarea>

        <%--html窗口 class = editormd-html-textarea --%>
        <textarea id="window_html" class="window_html" style="display:none;"></textarea>
    </div>
    <div class="col-xs-4">
        <input name="status" value="1" type="radio" lab="发布" style="margin: 10px" />
        <input name="status" value="2" type="radio" lab="草稿" style="margin: 10px" />
    </div>
    <br>
    <input type="button" id="button" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal" value="提交文章" style="left: 50%;">
</form>

<script type="text/javascript">
    $(function() {
        var editor = editormd("test-editor", {
            // width  : "70%",
            height : "60%",
            path   : "plugin/editor.md-master/lib/",
            saveHTMLToTextarea : true
        });
    });
    $("#button").click(function () {
        var status = $('input:radio:checked').val();


        if(status == '1'){
            $.ajax({
                async: false,//同步，待请求完毕后再执行后面的代码
                type: "POST",
                url: '/article_add',
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data: $("#articleForm").serialize(),
                dataType: "json",
                success: function (data) {
                    if(data.code==1) {
                        alert("文章添加成功!!");
                    } else {
                        alert("添加失败!!");
                    }
                },
                error: function () {
                    alert("数据获取失败")
                }
            })
        }
    })
</script>
</body>
</html>
