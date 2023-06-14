package com.linet.shoppingmallusingspringboot.service.impl;

import com.linet.shoppingmallusingspringboot.constant.ProductCategory;
import com.linet.shoppingmallusingspringboot.dao.ProductDao;
import com.linet.shoppingmallusingspringboot.dto.ProductRequest;
import com.linet.shoppingmallusingspringboot.model.Product;
import com.linet.shoppingmallusingspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductCategory category, String search) {
        return productDao.getProducts(category, search);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest) ;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
