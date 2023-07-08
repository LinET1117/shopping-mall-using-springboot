package com.linet.shoppingmallusingspringboot.controller;

import com.linet.shoppingmallusingspringboot.dto.CreateOrderRequest;
import com.linet.shoppingmallusingspringboot.dto.OrderQueryParams;
import com.linet.shoppingmallusingspringboot.model.Order;
import com.linet.shoppingmallusingspringboot.service.OrderService;
import com.linet.shoppingmallusingspringboot.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrders(
            @PathVariable Integer userId,
            @RequestParam(defaultValue ="10") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue ="0") @Min(0) Integer offset
    ){
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId (userId) ;
        orderQueryParams.setLimit (limit);
        orderQueryParams.setOffset (offset);

        // 取得 Order List
        List<Order> orderList = orderService.getOrders(orderQueryParams) ;
        // 取得 Order 總數
        Integer count = orderService.countOrder(orderQueryParams) ;

        // 分頁
        Page<Order> page = new Page<>();
        page.setLimit (limit);
        page.setOffset (offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest) {

        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }
}