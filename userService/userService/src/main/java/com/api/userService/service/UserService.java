package com.api.userService.service;

import com.api.userService.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends MongoRepository<Users,Integer> {


}
