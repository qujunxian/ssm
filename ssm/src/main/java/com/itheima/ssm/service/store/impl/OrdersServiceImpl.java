package com.itheima.ssm.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.store.OrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.store.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public PageInfo<Orders> getAll(Integer start, Integer pageSize) {
        PageHelper.startPage(start, pageSize);
        List<Orders> all = ordersDao.findAll();
        return new PageInfo<Orders>(all);
    }

    @Override
    public Orders findById(String id) {
        Orders orders = ordersDao.findById(id);
        return orders;
    }
}
