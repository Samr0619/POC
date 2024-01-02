package com.api.paymentService.configuration;

import com.api.paymentService.model.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class KafkaPaymentConsumerConfig {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @KafkaListener(topics = "NewOrder-Topic",groupId = "group-1")
    public void kafkaPaymentReceiver(String record) throws ParseException, JsonProcessingException {
        System.out.println("Obj : "+ record);
        String res = record;

        ObjectMapper mapper = new ObjectMapper();
        Orders list  = mapper.readValue(res, new TypeReference<Orders>() {
        });

        System.out.println("Items : "+list.getItems().size());



        String out= mapper.writeValueAsString(list);
        kafkaTemplate.send("createShipment",out);


    }



}
