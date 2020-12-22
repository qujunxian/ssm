package com.itheima.ssm.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.store.ProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.store.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public PageInfo<Product> getAll(Integer start, Integer pageSize) {
        PageHelper.startPage(start, pageSize);
        List<Product> all = productDao.findAll();
        return new PageInfo<Product>(all);
    }

    @Override
    public boolean save(Product product) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        product.setId(id);
        return productDao.save(product);
    }
}
