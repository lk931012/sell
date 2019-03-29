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
                    div class="row clearfix">
                    <div class="col-md-12 column">
                        <dl class="dl-horizontal">
                            <dt>订单号</dt>
                            <dd>${orderDTO.getOrderId()}</dd>
                            <dt>订单总金额</dt>
                            <dd>${orderDTO.getOrderAmount()}</dd>
                        </dl>
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>订单详情ID</th>
                                <th>商品名称</th>
                                <th>商品价格</th>
                                <th>购买数量</th>
                                <th>商品图片</th>
                                <th>创建日期</th>
                                <th>修改日期</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list orderDTO.getOrderDetailList() as detail>
                    <tr>
                        <td>${detail.getDetailId()}</td>
                        <td>${detail.getProductName()}</td>
                        <td>${detail.getProductPrice()}</td>
                        <td>${detail.getProductQuantity()}</td>
                        <td>${detail.getProductIcon()}</td>
                        <td>${detail.getCreateTime()}</td>
                        <td>${detail.getUpdateTime()}</td>
                    </tr>
                    </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <#include "../foot.ftl">
</div>
</body>
</html>