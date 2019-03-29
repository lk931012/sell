package com.study.sell.controller.seller;

import com.study.sell.entity.ProductCategory;
import com.study.sell.entity.ProductInfo;
import com.study.sell.service.ProductCategoryService;
import com.study.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 卖家类目Controller
 *
 * @Auther : 冷科
 * @Date : 2019/3/16 22:55
 */

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 分类列表
     */
    @RequestMapping("/list")
    public ModelAndView list() {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        return new ModelAndView("seller/category_list", "productCategoryList", productCategoryList);
    }


    /**
     * 去到编辑分类编辑页面
     */
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "categoryId", required = false) Integer categoryId) {
        ProductCategory category = null;
        if (categoryId != null) {
            category = productCategoryService.findById(categoryId);
        }
        return new ModelAndView("seller/category_edit", "category", category);
    }


    /**
     * 保存新增或者修改操作
     */
    @RequestMapping("/save")
    public ModelAndView save(ProductCategory productCategory) {
        productCategoryService.save(productCategory);
        return new ModelAndView("redirect:/seller/category/list");
    }
}
