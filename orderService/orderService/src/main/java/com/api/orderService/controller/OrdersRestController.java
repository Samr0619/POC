package com.api.orderService.controller;

import com.api.orderService.model.Orders;
import com.api.orderService.service.KafkaOrderProducer;
import com.api.orderService.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.json.JSONParser;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersRestController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private KafkaOrderProducer kafkaOrderProducer;



    @PostMapping("/NewOrders")
    public ResponseEntity<?> getNewOrders(@RequestBody Orders orders) {
        Orders neworders = null;

        try{
            neworders = orderService.save(orders);
            boolean flag=   kafkaOrderProducer.generatePaymentforOrder(neworders);
            System.out.println("order sent :"+flag);


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(neworders);
    }



}
