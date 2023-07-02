package com.linet.shoppingmallusingspringboot.service;

import com.linet.shoppingmallusingspringboot.dto.CreateOrderRequest;
import com.linet.shoppingmallusingspringboot.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) ;

}
