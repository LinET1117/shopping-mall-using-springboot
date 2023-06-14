package com.linet.shoppingmallusingspringboot.dao;

import com.linet.shoppingmallusingspringboot.dto.ProductQueryParams;
import com.linet.shoppingmallusingspringboot.dto.ProductRequest;
import com.linet.shoppingmallusingspringboot.model. Product;

import java.util.List;


public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest) ;

    void updateProduct (Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}