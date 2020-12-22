package com.itheima.ssm.dao.store;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface OrdersDao {
    /**
     * 查询全部订单
     *
     * @return
     */
    List<Orders> findAll();

    /**
     * 根据id查询订单信息
     *
     * @param id
     * @return
     */
    Orders findById(String id);
}
