package com.linet.shoppingmallusingspringboot.dao;

import com.linet.shoppingmallusingspringboot.dto.OrderQueryParams;
import com.linet.shoppingmallusingspringboot.model.Order;
import com.linet.shoppingmallusingspringboot.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryParams orderQueryParams) ;

    List<Order> getOrders(OrderQueryParams orderQueryParams) ;

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId) ;

    Integer createOrder(Integer userId, Integer totalAmount) ;

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList) ;

}
