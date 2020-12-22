package com.itheima.ssm.service.store;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface OrdersService {
    /**
     * 查询所有订单
     *
     * @return 返回订单集合
     */
    PageInfo<Orders> getAll(Integer start, Integer pageSize);

    /**
     * 根据ID查询订单
     *
     * @param id
     * @return
     */
    Orders findById(String id);
}
