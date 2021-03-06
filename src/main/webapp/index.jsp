<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>复选框美化下载</title>
    <link rel="stylesheet" href="css/jquery.richUI.min.css" />
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.richUI.min.js"></script>
    <script type="text/javascript" src="js/jquery.browser.min.js"></script>
    <script type="text/javascript">
        $(function() {
            //单选
            /*
            * selected: 默认选中值
            */
            $("input[name='sex']").richradio();
            $("input[name='sex2']").richradio();
            $("input[name='sex3']").richradio({selected:"2"});

            //复选
            /*
            * allBtn:是否出现全选按钮,默认 false
            * checkAll: 全选，默认false
            * selected: 默认选中值
            */
            $("input[name='xingqu']").richcheckbox();
            $("input[name='xingqu2']").richcheckbox({allBtn:true, checkAll:true});
            $("input[name='xingqu3']").richcheckbox({allBtn:true});
            $("input[name='xingqu4']").richcheckbox({allBtn:true, selected:"2,4"});

            //下拉框
            /**
             * type: single(单选，默认)，multi(多选)
             * selected： 默认选中值
             * width： 宽度
             * placeholder: 提示文字
             *
             **/
            $("#mySelect").richselect();
            $("#mySelect2").richselect({selected:"3"});
            $("#mySelect3").richselect({type:"multi", placeholder:"hello"});
            $("#mySelect4").richselect({type:"multi", selected:"4,5", width:"300px"});

        });
    </script>
</head>
<body>
<h1>rich美化</h1>
<form id="form1" action="" method="POST">
    <div style="width: 100%;">
        <span>单选（普通）：</span>
        <input name="sex" value="1" type="radio" lab="男" />
        <input name="sex" value="2" type="radio" lab="女" />
        <br />
        <br />
        <span>单选（默认选中1）：</span>
        <input name="sex2" value="1" type="radio" lab="男" />
        <input name="sex2" value="2" type="radio" lab="女" />
        <input name="sex2" value="3" type="radio" checked="checked" lab="未知" />
        <br />
        <br />
        <span>单选（默认选中2）：</span>
        <input name="sex3" value="1" type="radio" lab="男" />
        <input name="sex3" value="2" type="radio" lab="女" />
        <input name="sex3" value="3" type="radio" lab="未知" />
    </div>

    <div style="width: 100%;">
        <br />
        <span>复选（普通）：</span>
        <input name="xingqu" value="1" type="checkbox" lab="旅行" >
        <input name="xingqu" value="2" type="checkbox" lab="与周公下棋" />
        <input name="xingqu" value="3" type="checkbox" lab="读书" />
        <br />
        <br />
        <span>复选（带全选按钮）：</span>
        <input name="xingqu2" value="1" type="checkbox" lab="旅行" >
        <input name="xingqu2" value="2" type="checkbox" lab="与周公下棋" />
        <input name="xingqu2" value="3" type="checkbox" lab="读书" />
        <input name="xingqu2" value="3" type="checkbox" lab="逛街" />
        <br />
        <br />
        <span>复选（默认选中1）：</span>
        <input name="xingqu3" value="1" type="checkbox" lab="旅行" >
        <input name="xingqu3" value="2" type="checkbox" checked="checked" lab="与周公下棋" />
        <input name="xingqu3" value="3" type="checkbox" checked="checked" lab="读书" />
        <input name="xingqu3" value="3" type="checkbox" checked="checked" lab="逛街" />
        <br />
        <br />
        <span>复选（默认选中2）：</span>
        <input name="xingqu4" value="1" type="checkbox" lab="旅行" >
        <input name="xingqu4" value="2" type="checkbox" lab="与周公下棋" />
        <input name="xingqu4" value="3" type="checkbox" lab="读书" />
        <input name="xingqu4" value="4" type="checkbox" lab="逛街" />
    </div>

    <div style="width: 100%;height: 100px;">
        <br />
        <span>下拉框（普通）：</span>
        <select id="mySelect" name="company">
            <option value="1" >百度</option>
            <option value="2">新浪</option>
            <option value="3">搜狐</option>
            <option value="4">腾讯</option>
            <option value="5">阿里巴巴</option>
        </select>
        <br />
        <br />
        <span>下拉框（普通默认选中）：</span>
        <select id="mySelect2" name="company2">
            <option value="1" >百度</option>
            <option value="2">新浪</option>
            <option value="3">搜狐</option>
            <option value="4">腾讯</option>
            <option value="5">阿里巴巴</option>
        </select>
        <br />
        <br />
        <span>下拉框（多选）：</span>
        <select id="mySelect3" name="company3">
            <option value="1" >百度</option>
            <option value="2">新浪</option>
            <option value="3">搜狐</option>
            <option value="4">腾讯</option>
            <option value="5">阿里巴巴</option>
        </select>
        <br />
        <br />
        <span>下拉框（多选默认选中）：</span>
        <select id="mySelect4" name="company4">
            <option value="1" >百度</option>
            <option value="2">新浪</option>
            <option value="3">搜狐</option>
            <option value="4">腾讯</option>
            <option value="5">阿里巴巴</option>
        </select>
        <br />
        <br />
    </div>
</form>
</body>
</html>
