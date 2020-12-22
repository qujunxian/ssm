package com.itheima.ssm.dao.store;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有商品
     *
     * @return 返回商品集合
     */
    List<Product> findAll();

    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    boolean save(Product product);
}
