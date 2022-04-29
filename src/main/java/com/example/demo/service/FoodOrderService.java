package com.example.demo.service;

import com.example.demo.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class FoodOrderService {

    private final MsgProducer producer;

    public void createFoodOrder(Order order) throws JsonProcessingException {
        producer.sendMessage(order);
    }

}
