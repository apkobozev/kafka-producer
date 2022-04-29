package com.example.demo.service;

import com.example.demo.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper mapper;
    private final KafkaTemplate<String, String> template;

    public MsgProducer(ObjectMapper mapper, KafkaTemplate<String, String> template) {
        this.mapper = mapper;
        this.template = template;
    }


    public void sendMessage(Order order) throws JsonProcessingException {
        template.send(orderTopic, mapper.writeValueAsString(order));
    }

}
