package com.linet.shoppingmallusingspringboot.dao;

import com.linet.shoppingmallusingspringboot.dto.ProductRequest;
import com.linet.shoppingmallusingspringboot.model. Product;


public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest) ;

    void updateProduct (Integer productId, ProductRequest productRequest);
}