package com.study.sell.controller.seller;

import com.study.sell.entity.ProductCategory;
import com.study.sell.entity.ProductInfo;
import com.study.sell.service.ProductCategoryService;
import com.study.sell.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 卖家商品Controller
 *
 * @Auther : 冷科
 * @Date : 2019/3/16 22:55
 */

@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品列表
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        ModelAndView model = new ModelAndView("seller/product_list");
        model.addObject("productInfoPage", productInfoPage);
        model.addObject("currentPage", page);
        return model;
    }

    /**
     * 去到添加与修改的编辑页面
     */
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "productId", required = false) String productId) {
        ModelAndView modelAndView = new ModelAndView("seller/product_edit");
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        modelAndView.addObject("productCategoryList", productCategoryList);
        if (productId != null) {
            ProductInfo productInfo = productInfoService.findById(productId);
            modelAndView.addObject("productInfo", productInfo);
        }
        return modelAndView;
    }

    /**
     * 保存编辑操作
     */
    @RequestMapping("/save")
    //@CachePut更新缓存,由于返回类型必须实现Serilizeble接口,所以没法使用这个
    //@CachePut(cacheNames = "productList", key = "666666")
    //@CacheEvict每次更新完就删除缓存里的数据,下次查询列表会再重新从数据库查找
    @CacheEvict(cacheNames = "productList", key = "666666")
    public ModelAndView save(ProductInfo productInfo) {
        productInfoService.save(productInfo);
        return new ModelAndView("redirect:/seller/product/list");
    }


}
