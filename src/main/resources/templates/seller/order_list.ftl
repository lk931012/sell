<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <title>卖家管理平台</title>
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
                            <th>订单号</th>
                            <th>昵称</th>
                            <th>电话</th>
                            <th>地址/th>
                            <th>微信号</th>
                            <th>总金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建日期</th>
                            <th colspan="3">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                         <#list orderDTOPage.getContent() as order>
                         <tr>
                             <td>${order.getOrderId()}</td>
                             <td>${order.getBuyerName()}</td>
                             <td>${order.getBuyerPhone()}</td>
                             <td>${order.getBuyerAddress()}</td>
                             <td>${order.getBuyerOpenid()}</td>
                             <td>${order.getOrderAmount()}</td>
                             <td>${order.getOrderStatusMsg()}</td>
                             <td>${order.getPaymentStatusMsg()}</td>
                             <td>${order.getCreateTime()}</td>
                             <td><a href="http://lengke1.natapp1.cc/seller/order/detail?orderId=${order.getOrderId()}">详情</a>
                             </td>
                             <td><a href="http://lengke1.natapp1.cc/seller/order/cancel?orderId=${order.getOrderId()}">取消</a>
                             </td>
                             <td><a href="http://lengke1.natapp1.cc/seller/order/finish?orderId=${order.getOrderId()}">完结</a>
                             </td>
                         </tr>
                         </#list>
                        </tbody>
                    </table>
                    <ul class="pagination pull-right">
                    <#--首页-->
                        <li>
                            <a href="http://lengke1.natapp1.cc/seller/order/list?page=1">首页</a>
                        </li>
                    <#--上一页-->
                        <#if 1 == currentPage>
                        <li class="disabled">
                            <a href="#">上一页</a>
                        </li>
                        <#else >
                        <li>
                            <a href="http://lengke1.natapp1.cc/seller/order/list?page=${currentPage-1}">上一页</a>
                        </li>
                        </#if>
                    <#--中间页码-->
                        <#list 1..orderDTOPage.getTotalPages() as index>
                            <#if index == currentPage>
                            <li class="disabled">
                                <a href="#">${index}</a>
                            </li>
                            <#else >
                                <li>
                                    <a href="http://lengke1.natapp1.cc/seller/order/list?page=${index}">${index}</a>
                                </li>
                            </#if>
                        </#list>
                    <#--下一页-->
                        <#if orderDTOPage.getTotalPages() == currentPage>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else >
                            <li>
                                <a href="http://lengke1.natapp1.cc/seller/order/list?page=${currentPage+1}">下一页</a>
                            </li>
                        </#if>
                    <#--尾页-->
                        <li>
                            <a href="http://lengke1.natapp1.cc/seller/order/list?page=${orderDTOPage.getTotalPages()}">尾页</a>
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