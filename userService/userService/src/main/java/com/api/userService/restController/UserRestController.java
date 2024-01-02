package com.api.userService.restController;

import com.api.userService.model.Users;
import com.api.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody Users user){
       Users newuser = userService.save(user);
        return ResponseEntity.ok(newuser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getuserData(@PathVariable("userId") Integer userId){
        System.out.println("userId : "+userId);
        Optional<Users> user = userService.findById(userId);
       return ResponseEntity.ok(user);
    }


}
