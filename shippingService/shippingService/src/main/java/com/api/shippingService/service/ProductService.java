package com.api.shippingService.service;

import com.api.shippingService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductService extends MongoRepository<Product,Integer> {
}
