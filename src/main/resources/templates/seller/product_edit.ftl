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

                    <form class="form-horizontal" action="/seller/product/save">
                        <div class="control-group">
                            <div class="controls">
                                <input type="text" name="productId" hidden="hidden"
                                       value="${(productInfo.getProductId())!}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                名 称：<input type="text" name="productName" value="${(productInfo.getProductName())!}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                价 格：<input type="text" name="productPrice" value="${(productInfo.getProductPrice())!}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                折 扣：<input type="text" name="discount" value="${(productInfo.getDiscount())!}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                库 存：<input type="text" name="productStock" value="${(productInfo.getProductStock())!}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                图片地址：<input type="text" name="productIcon" value="${(productInfo.getProductIcon())!}"/>
                            </div>
                        </div>
                        <div>
                            状 态：
                            <label>
                                <#if (productInfo.getProductStatus())?? && productInfo.getProductStatus()== 0>
                                    <input type="radio" name="productStatus" id="optionsRadios2" checked="checked"
                                           value=0>上架
                                    <input type="radio" name="productStatus" id="optionsRadios2" value=1>下架
                                    &nbsp;&nbsp;&nbsp;
                                <#elseif (productInfo.getProductStatus())?? && productInfo.getProductStatus()== 1>
                                    <input type="radio" name="productStatus" id="optionsRadios2" value=0>上架
                                    <input type="radio" name="productStatus" id="optionsRadios2" checked="checked"
                                           value=1>下架
                                <#else>
                                    <input type="radio" name="productStatus" id="optionsRadios2" value=0>上架
                                    <input type="radio" name="productStatus" id="optionsRadios2" value=1>下架
                                </#if>
                            </label>
                        <#--<label>
                            <#if productInfo.getProductStatus()??>
                                <input type="radio" name="productStatus" id="optionsRadios2" checked=${(productInfo.getProductStatus() == 0)?String("checked","")} value="0">上架
                                &nbsp;&nbsp;&nbsp;
                                <input type="radio" name="productStatus" id="optionsRadios2" (${productInfo.getProductStatus() == 1})?String("checked='checked'",'') value="1">下架
                            <#else >
                                 <input type="radio" name="productStatus" id="optionsRadios2"  value="0">上架
                                 &nbsp;&nbsp;&nbsp;
                                <input type="radio" name="productStatus" id="optionsRadios2"  value="1">下架
                            </#if>
                        </label>-->


                        </div>
                        <div class="radio">

                        </div>
                        <label for="name">分 类：</label>
                        <select name="categoryType">
                        <#list productCategoryList as category>
                            <#if category.getCategoryType() == (productInfo.getCategoryType())!0>
                                <option value="${category.getCategoryType()}"
                                        selected="selected">${category.getCategoryName()}</option>
                            </#if>
                            <option value="${category.getCategoryType()}">${category.getCategoryName()}</option>
                        </#list>
                        </select>
                        <div>
                            描 述： <textarea rows="3"
                                           name="productDescription">${(productInfo.getProductDescription())!}</textarea>
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