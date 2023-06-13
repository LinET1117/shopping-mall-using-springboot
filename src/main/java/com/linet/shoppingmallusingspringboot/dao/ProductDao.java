package com.linet.shoppingmallusingspringboot.dao;

import com.linet.shoppingmallusingspringboot.model. Product;


public interface ProductDao {

    Product getProductById(Integer productId);
}