package com.linet.shoppingmallusingspringboot.dao;

import com.linet.shoppingmallusingspringboot.constant.ProductCategory;
import com.linet.shoppingmallusingspringboot.dto.ProductRequest;
import com.linet.shoppingmallusingspringboot.model. Product;

import java.util.List;


public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest) ;

    void updateProduct (Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}