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
    <link rel="stylesheet" href="plugin/editor.md-master/css/editormd.css" />
    <script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="plugin/editor.md-master/editormd.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
<form action="#">
    <div class="col-xs-4">
        <input type="text" class="form-control" placeholder="输入文章标题" style="margin: 10px">
        <input type="text" class="form-control" placeholder="输入类别" style="margin: 10px">
        <input type="text" class="form-control" placeholder="输入标签,多个标签以英文逗号分隔, 例: java,mysql  " style="margin: 10px">
    </div>
    <div id="test-editor" class="test-editor">
        <%--markdown窗口--%>
        <textarea id="window_markdown" class="window_markdown" style="display:none;">### 关于 Editor.md
**Editor.md** 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。
    </textarea>

        <%--html窗口 class = editormd-html-textarea --%>
        <textarea id="window_html" class="window_html" style="display:none;"></textarea>
    </div>
    <input type="button" value="提交文章" style="margin: 10px">
</form>

<script type="text/javascript">
    $(function() {
        var editor = editormd("test-editor", {
            // width  : "70%",
            height : "60%",
            path   : "plugin/editor.md-master/lib/",
            saveHTMLToTextarea : true
        });

        // testEditor.getMarkdown();       // 获取 Markdown 源码
        // testEditor.getHTML();           // 获取 Textarea 保存的 HTML 源码
        // testEditor.getPreviewedHTML();  // 获取预览窗口里的 HTML，在开启 watch 且没有开启 saveHTMLToTextarea 时使用

    });
    $("#button").click(function () {
        var text = $('.window_html').val();
        alert(text);
        var text1 = $('.editormd-html-textarea').val();
        alert(text1);
    })
</script>
</body>
</html>
