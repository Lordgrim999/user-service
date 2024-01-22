package com.ecommerce.user.controller;

import com.ecommerce.user.DTO.UserDTO;
import com.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> fetchAllUsers()
    {
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/fetchById/{Id}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable String Id)
    {
        return new ResponseEntity<>(userService.fetchRestaurantById(Id), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO)
    {
        UserDTO result=userService.saveUser(userDTO);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
