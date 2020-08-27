package com.coffeejug.trafficrules.controller;

import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{uuid}")
    public UserDto getOne(@PathVariable("uuid") String uuid) {
        return userService.findById(uuid);
    }

    @PostMapping
    public UserDto getUserProgress(@RequestBody UserDto user) {
        return userService.save(user);
    }

}
