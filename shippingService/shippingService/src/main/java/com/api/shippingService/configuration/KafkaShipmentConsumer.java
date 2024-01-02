package com.api.shippingService.configuration;

import com.api.shippingService.model.ShipmentDetailsBean;
import com.api.shippingService.model.Orders;
import com.api.shippingService.model.Product;
import com.api.shippingService.model.Users;
import com.api.shippingService.service.ProductService;
import com.api.shippingService.service.ShipmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class KafkaShipmentConsumer {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private ShipmentService shipmentService;


    @KafkaListener(topics = "createShipment",groupId = "group-1")
    public void kafkaShipmentReceiver(String record) throws ParseException, JsonProcessingException {

        System.out.println("Rec  : "+ record);

        String res = record;

        ObjectMapper mapper = new ObjectMapper();
        Orders list  = mapper.readValue(res, new TypeReference<Orders>() {
        });

        Users users = restTemplate.getForObject("http://USER-SERVICE/user/"+list.getUserId(),
                Users.class);

        System.out.println("User : "+users);


        ShipmentDetailsBean shipbean = new ShipmentDetailsBean();
        shipbean.setOrderId(list.getOrderId());
        shipbean.setUserId(list.getUserId());
        shipbean.setUsername(users.getUsername());
        shipbean.setOrdNum(list.getOrderNum());

        List<ShipmentDetailsBean.Item> itemls = new ArrayList<>();
        float totalOrdamt= 0f;
            for (Orders.Item item : list.getItems()) {
                int id = (int)item.getProdId();
                Optional<Product> prod = productService.findById(id);

                ShipmentDetailsBean.Item items = new ShipmentDetailsBean.Item();
                items.setProdId(item.getProdId());
                items.setPrice(item.getPrice());
                items.setQty(item.getQty());
                items.setProdName(prod.get().getProd_name());

                totalOrdamt += item.getPrice();

                itemls.add(items);
            }

        shipbean.setItems(itemls);
        shipbean.setTotalOrderAmount(totalOrdamt);
        totalOrdamt = 0f;
        shipbean.setId((int)shipbean.getOrderId());
        shipmentService.save(shipbean);
    }

}
