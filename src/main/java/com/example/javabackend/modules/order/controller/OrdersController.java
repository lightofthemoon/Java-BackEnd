//package com.example.javabackend.modules.order.controller;
//
//import java.util.List;
//
//import com.example.javabackend.modules.order.service.OrderService;
//import jakarta.persistence.criteria.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrdersController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping("/")
//    public Order createOrder(@RequestParam Long accountId, @RequestBody List<OrderItemDTO> orderItems) throws Exception {
//        return orderService.createOrder(accountId, orderItems);
//    }
//
//    @GetMapping("/{orderId}")
//    public Orders getOrderById(@PathVariable Long orderId) throws Exception {
//        return orderService.getOrderById(orderId);
//    }
//
//    @GetMapping("/")
//    public List<Orders> getOrdersByAccountId(@RequestParam Long accountId) {
//        return orderService.getOrdersByAccountId(accountId);
//    }
//
//    @PutMapping("/{orderId}/cancel")
//    public void cancelOrder(@PathVariable Long orderId) throws Exception {
//        orderService.cancelOrder(orderId);
//    }
//}