<%--
  Created by IntelliJ IDEA.
  User: 18235
  Date: 2019/5/28
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>博客主页</title>
    <link rel="stylesheet" type="text/css" href="/plugin/layui/css/layui.css">
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <!--加载meta IE兼容文件-->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="header">
    <div class="menu-btn">
        <div class="menu"></div>
    </div>
    <h1 class="logo" style="">
        <a href="/home">
            <span>HELLO,FRIEND!</span>
            <img src="/img/logo.png">
        </a>
    </h1>
    <div class="nav">
        <a href="home" class="active">文章</a>
        <a href="whisper.html">分类</a>
        <a href="msgboard.html">标签</a>
        <a href="album.html">相册</a>
        <a href="about.html">关于</a>
    </div>

    <p class="welcome-text">
        欢迎来到<span class="name">AllEN</span>的博客~
    </p>
</div>

<div class="content whisper-content leacots-content details-content">
    <div class="cont w1000">
        <div class="whisper-list">
            <div class="item-box">
                <div class="review-version">
                    <div class="form-box">
                        <div class="article-cont">
                            <div class="title">
                                <h3>${article.articleTitle}</h3>
                                <p class="cont-info"><span class="data">${article.articleCreateTime}</span><span class="types">散文札记</span></p>
                            </div>
                            ${article.articleContent}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer-wrap">
    <div class="footer w1000">
        <div class="qrcode">
            <img src="/img/erweima.jpg">
        </div>
        <div class="practice-mode">
            <img src="/img/down_img.jpg">
            <div class="text">
                <h4 class="title">我的联系方式</h4>
                <p>微信<span class="WeChat">1234567890</span></p>
                <p>手机<span class="iphone">1234567890</span></p>
                <p>邮箱<span class="email">1234567890@qq.com</span></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({
        base: '/js/util/'
    }).use(['element','laypage','jquery','menu'],function(){
        element = layui.element,laypage = layui.laypage,$ = layui.$,menu = layui.menu;
        laypage.render({
            elem: 'demo'
            ,count: 70 //数据总数，从服务端得到
        });
        menu.init();
    })
</script>
</body>
</html>