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
        <a href="index.html">
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

<div class="banner">
    <div class="cont w1000">
        <div class="title">
            <h3>HELLO<br /><br />MY FRIEND</h3>
            <%--<h4>well-balanced heart</h4>--%>
        </div>
    </div>
</div>

<div class="content">
    <div class="cont w1000">
        <div class="title">
        <span class="layui-breadcrumb" lay-separator="|">
          <a href="javascript:;" class="active">技术文章</a>
          <a href="javascript:;">杂记</a>
        </span>
        </div>
        <div class="list-item">
            <c:forEach items="${pageInfo.list}" var="c" varStatus="st">
                <div class="item">
                    <div class="layui-fluid">
                        <div class="layui-row">
                            <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">
                                <div class="img"><img src="/img/sy_img1.jpg" alt=""></div>
                            </div>
                            <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">
                                <div class="item-cont">
                                    <h3>${c.articleTitle}<button class="layui-btn layui-btn-danger new-icon">new</button></h3>
                                    <h5>${c.articleCreateTime}</h5>
                                    <p>${c.articleContentSum}</p>
                                    <a href="/article/${c.articleId}" class="go-icon"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="layui-card-body ">
            <div class="page">
                <div class="col-md-6">
                    当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
                </div>
                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">

                            <li><a href="${pageContext.request.contextPath}/home?pn=1">首页</a></li>

                            <!--上一页-->
                            <li>
                                <c:if test="${pageInfo.hasPreviousPage}">
                                    <a href="${pageContext.request.contextPath}/home?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == pageInfo.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != pageInfo.pageNum}">
                                    <li><a href="${pageContext.request.contextPath}/home?pn=${page_num}">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <a href="${pageContext.request.contextPath}/home?pn=${pageInfo.pageNum+1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>

                            <li><a href="${pageContext.request.contextPath}/home?pn=${pageInfo.pages}">尾页</a></li>
                        </ul>
                    </nav>
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