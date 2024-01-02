package com.api.orderService.service;

import com.api.orderService.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderService extends MongoRepository<Orders,Integer> {
}
