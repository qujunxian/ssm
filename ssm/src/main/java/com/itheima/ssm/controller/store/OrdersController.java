package com.itheima.ssm.controller.store;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.store.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/orders/findAll")
    public ModelAndView findAll(Integer start,Integer pageSize,ModelAndView modelAndView){
        if (start==null)
            start=1;
        if (pageSize==null)
            pageSize=5;
        PageInfo<Orders> ordersList = ordersService.getAll(start,pageSize);
        modelAndView.addObject("ordersList",ordersList);
        modelAndView.setViewName("/pages/orders-list.jsp");
        return modelAndView;
    }
    @RequestMapping("/orders/findById")
    public ModelAndView findById(String id,ModelAndView modelAndView){
        Orders orders = ordersService.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("/pages/orders-show.jsp");
        return modelAndView;
    }
}
