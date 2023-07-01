package com.linet.shoppingmallusingspringboot.dao;

import com.linet.shoppingmallusingspringboot.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount) ;

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList) ;

}
