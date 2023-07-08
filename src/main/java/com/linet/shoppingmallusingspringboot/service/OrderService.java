package com.linet.shoppingmallusingspringboot.service;

import com.linet.shoppingmallusingspringboot.dto.CreateOrderRequest;
import com.linet.shoppingmallusingspringboot.dto.OrderQueryParams;
import com.linet.shoppingmallusingspringboot.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) ;

    Integer countOrder(OrderQueryParams orderQueryParams) ;

    List<Order> getOrders(OrderQueryParams orderQueryParams) ;


}
