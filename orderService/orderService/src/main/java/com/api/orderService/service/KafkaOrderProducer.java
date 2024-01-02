package com.api.orderService.service;

import com.api.orderService.model.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KafkaOrderProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean generatePaymentforOrder(Orders obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String out= mapper.writeValueAsString(obj);
        kafkaTemplate.send("NewOrder-Topic",out);
        return true;
    }
}
