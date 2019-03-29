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
                            <th>分类ID</th>
                            <th>分类名称</th>
                            <th>分类编号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                         <#list productCategoryList as category>
                         <tr>
                             <td>${category.getCategoryId()}</td>
                             <td>${category.getCategoryName()}</td>
                             <td>${category.getCategoryType()}</td>
                             <td><a href="/seller/category/edit?categoryId=${category.getCategoryId()}">修改</a></td>
                         </tr>
                         </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <#include "../foot.ftl">
</div>
</body>
</html>