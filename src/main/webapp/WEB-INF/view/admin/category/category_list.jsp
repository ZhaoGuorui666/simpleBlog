<%@ page import="com.zgr666.ssm.blog.entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: 18235
  Date: 2019/5/25
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script src="/plugin/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="x-nav">
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                    <button class="layui-btn" onclick="xadmin.open('添加用户','/category_add.html',600,200)"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th>ID</th>
                            <th>类别名</th>
                            <th>文章数</th>
                            <th>操作</th></tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="c" varStatus="st">
                            <tr>

                                <td>
                                    <input type="checkbox" name="id" value="${c.categoryId}"   lay-skin="primary">
                                </td>
                                <td>${c.categoryId}</td>
                                <td>${c.categoryName}</td>
                                <td>${c.categoryArticleNum}</td>
                                <td class="td-manage">
                                    <a onclick="xadmin.open('修改分类','category_update.html/'+${c.categoryId},600,200)" title="修改分类" href="javascript:;">
                                        <i class="layui-icon">&#xe631;</i>
                                    </a>
                                    <a title="删除" onclick="member_del(this,${c.categoryId})" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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

                                    <li><a href="${pageContext.request.contextPath}/category_list.html?pn=1">首页</a></li>

                                    <!--上一页-->
                                    <li>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <a href="${pageContext.request.contextPath}/category_list.html?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                                            <li><a href="${pageContext.request.contextPath}/category_list.html?pn=${page_num}">${page_num}</a></li>
                                        </c:if>
                                    </c:forEach>

                                    <!--下一页-->
                                    <li>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <a href="${pageContext.request.contextPath}/category_list.html?pn=${pageInfo.pageNum+1}"
                                               aria-label="Next">
                                                <span aria-hidden="true">»</span>
                                            </a>
                                        </c:if>
                                    </li>

                                    <li><a href="${pageContext.request.contextPath}/category_list.html?pn=${pageInfo.pages}">尾页</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;


        // 监听全选
        form.on('checkbox(checkall)', function(data){

            if(data.elem.checked){
                $('tbody input').prop('checked',true);
            }else{
                $('tbody input').prop('checked',false);
            }
            form.render('checkbox');
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });


    });

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                async: false,//同步，待请求完毕后再执行后面的代码
                type: "POST",
                url: '/category_del/'+id,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    if(data.code==1) {
                        layer.msg('已删除!',{icon:1,time:1000});
                        $(obj).parents("tr").remove();
                    } else {
                        alert("删除失败!!!");
                    }
                },
                error: function () {
                    alert("数据获取失败")
                }
            })
        });
    }



    function delAll (argument) {
        var ids = [];

        // 获取选中的id
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
                ids.push($(this).val())
            }
        });

        layer.confirm('确认要删除吗？'+ids.toString(),function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
</html>
