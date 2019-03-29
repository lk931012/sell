<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <title>卖家管理平台</title>
</head>
<body>
<div class="container">
    <#include "head.ftl">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-10 column">
                    <form role="form" action="/user/login">
                        用户名<input type="text" name="userName" width="100px"/>
                        密 码<input type="password" name="password"/>
                        <button type="submit" class="btn btn-default">提交</button>
                    ${msg!}
                    </form>
                </div>
            </div>
        </div>
    </div>
    <#include "foot.ftl">
</div>
</body>
</html>