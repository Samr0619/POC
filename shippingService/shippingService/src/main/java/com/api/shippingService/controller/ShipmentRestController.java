package com.api.shippingService.controller;

import com.api.shippingService.model.Product;
import com.api.shippingService.model.ShipmentDetailsBean;
import com.api.shippingService.service.ProductService;
import com.api.shippingService.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentRestController {

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private ProductService productService;


    @GetMapping("/shipmentDetails")
    public ResponseEntity<?> getShipmentDetails(@RequestParam Integer userId,
                                                @RequestParam Integer orderId){
        ShipmentDetailsBean shipment = null;
        try{
             shipment  =
                    shipmentService.getShipmentDetailsByUserId(userId,orderId);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(shipment);
    }


    @PostMapping("/add-prod-master")
    public ResponseEntity<?> saveprodmaster(@RequestBody Product prod){
        Product newprod = null;

        try {
            newprod = productService.save(prod);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(newprod);
    }
}
