package com.example.orderservice.controller;

import com.example.orderservice.dto.ProductResponse;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/check-stock/{code}")
    public ProductResponse checkStock(@PathVariable String code) {
        return orderService.checkProductStock(code);
    }
}
