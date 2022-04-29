package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.FoodOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class FoodOrderController {

    private final FoodOrderService foodOrderService;

    @PostMapping
    public ResponseEntity placeOrder(@RequestBody Order order) throws JsonProcessingException {
        foodOrderService.createFoodOrder(order);
        return ResponseEntity.ok("message sent");
    }
}
