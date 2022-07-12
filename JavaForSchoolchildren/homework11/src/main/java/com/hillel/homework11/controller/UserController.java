package com.hillel.homework11.controller;

import com.hillel.homework11.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    HashMap<Integer, UserDTO> users = new HashMap<>();

    @PostMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/create")
    public Integer createUser(@RequestBody UserDTO user){
        users.put(user.id(), user);
        return users.size();
    }

    @PostMapping("/post/{id}")
    public UserDTO getUser(@PathVariable Integer id){
        return users.get(id);
    }
}