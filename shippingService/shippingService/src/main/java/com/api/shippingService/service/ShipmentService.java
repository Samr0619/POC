package com.api.shippingService.service;

import com.api.shippingService.model.Product;
import com.api.shippingService.model.ShipmentDetailsBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShipmentService extends MongoRepository<ShipmentDetailsBean,Integer> {

    @Query("{$and:[{userId:?0},{orderId:?1}]}")
    ShipmentDetailsBean getShipmentDetailsByUserId(Integer id,Integer orderId);

}
