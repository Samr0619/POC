package com.api.paymentService.service;

import com.api.paymentService.model.Orders;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class paymentShippingService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean sendForShipment(Orders order)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String req = mapper.writeValueAsString(order);
        kafkaTemplate.send("createShipment",req);
        System.out.println("Request for Shipment is Sent.");
        return true;
    }

}
