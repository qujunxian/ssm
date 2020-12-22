package com.itheima.ssm.dao.store;

import com.itheima.ssm.domain.Traveller;

public interface TravellerDao {
    /**
     * 根据id查询订单信息
     *
     * @param ordersId 订单id
     * @return
     */
    Traveller findByOrdersId(String ordersId);
}
