package com.linet.shoppingmallusingspringboot.service.impl;

import com.linet.shoppingmallusingspringboot.dao.ProductDao;
import com.linet.shoppingmallusingspringboot.model.Product;
import com.linet.shoppingmallusingspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
