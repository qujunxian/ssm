package com.itheima.ssm.controller.store;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.store.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/product/findAll")
    public ModelAndView findAll(Integer start, Integer pageSize,ModelAndView modelAndView){
        if (start==null)
            start=1;
        if (pageSize==null)
            pageSize=5;
        PageInfo<Product> productList = productService.getAll(start,pageSize);
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("/pages/product-list.jsp");
        return modelAndView;
    }
    @RequestMapping("/product/save")
    public ModelAndView save(Product product,ModelAndView modelAndView){
        productService.save(product);
        findAll(null,null,modelAndView);
        modelAndView.setViewName("/pages/product-list.jsp");
        return modelAndView;
    }
}
