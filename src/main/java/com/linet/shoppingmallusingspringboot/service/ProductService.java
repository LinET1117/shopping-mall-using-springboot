package com.linet.shoppingmallusingspringboot.service;

import com.linet.shoppingmallusingspringboot.dto.ProductRequest;
import com.linet.shoppingmallusingspringboot.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest) ;

    void updateProduct (Integer productId, ProductRequest productRequest);

}
