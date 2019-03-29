<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <title>base</title>
</head>
<body>
<div class="container">
    <#include "../head.ftl">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <#include "../left.ftl">
                <div class="col-md-10 column">
                    <table class="table table-condensed table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>商品名称</th>
                            <th>单价</th>
                            <th>折扣</th>
                            <th>库存</th>
                            <th>图片</th>
                            <th>所属分类</th>
                            <th>状态</th>
                            <th>创建日期</th>
                            <th>修改日期</th>
                            <th colspan="3">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                         <#list productInfoPage.getContent() as product>
                         <tr>
                             <td>${product.getProductName()}</td>
                             <td>${product.getProductPrice()}</td>
                             <td>${product.getDiscount()}</td>
                             <td>${product.getProductStock()}</td>
                             <td><img src="${product.getProductIcon()}" width="80px" , height="80px"></a></td>
                             <td>${product.getCategoryType()}</td>
                             <td>${product.getStatusMsg()}</td>
                             <td>${product.getCreateTime()}</td>
                             <td>${product.getUpdateTime()}</td>
                             <td><a href="/seller/product/edit?productId=${product.getProductId()}">修改</a></td>
                         </tr>
                         </#list>
                        </tbody>
                    </table>
                    <ul class="pagination pull-right">
                    <#--首页-->
                        <li>
                            <a href="http://lengke1.natapp1.cc/seller/product/list?page=1">首页</a>
                        </li>
                    <#--上一页-->
                        <#if 1 == currentPage>
                        <li class="disabled">
                            <a href="#">上一页</a>
                        </li>
                        <#else >
                        <li>
                            <a href="http://lengke1.natapp1.cc/seller/product/list?page=${currentPage-1}">上一页</a>
                        </li>
                        </#if>
                    <#--中间页码-->
                        <#list 1..productInfoPage.getTotalPages() as index>
                            <#if index == currentPage>
                            <li class="disabled">
                                <a href="#">${index}</a>
                            </li>
                            <#else >
                                <li>
                                    <a href="http://lengke1.natapp1.cc/seller/product/list?page=${index}">${index}</a>
                                </li>
                            </#if>
                        </#list>
                    <#--下一页-->
                        <#if productInfoPage.getTotalPages() == currentPage>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else >
                            <li>
                                <a href="http://lengke1.natapp1.cc/seller/product/list?page=${currentPage+1}">下一页</a>
                            </li>
                        </#if>
                    <#--尾页-->
                        <li>
                            <a href="http://lengke1.natapp1.cc/seller/order/list?page=${productInfoPage.getTotalPages()}">尾页</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <#include "../foot.ftl">
</div>
</body>
</html>