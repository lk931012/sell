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

                    <form class="form-horizontal" action="/seller/category/save">
                        <div class="control-group">
                            <div class="controls">
                                分类ID：${(category.getCategoryId())!}
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                分类名称：<input type="text" name="categoryName" value="${(category.getCategoryName())!}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                分类编号：<input type="text" name="categoryType" value="${(category.getCategoryType())!}"/>
                            </div>
                        </div>
                        <div>
                            <button type="submit" class="btn">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <#include "../foot.ftl">
</div>
</body>
</html>