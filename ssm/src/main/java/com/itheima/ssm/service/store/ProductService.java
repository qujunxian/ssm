package com.itheima.ssm.service.store;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProductService {
    /**
     * 查询所有商品
     *
     * @return 返回商品集合
     */
    PageInfo<Product> getAll(Integer start, Integer pageSize);

    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    @Transactional(readOnly = false)
    boolean save(Product product);
}
