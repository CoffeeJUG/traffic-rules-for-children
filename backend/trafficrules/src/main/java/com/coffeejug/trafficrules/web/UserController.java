package com.coffeejug.trafficrules.web;

import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.exception.NotFoundException;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{uuid}")
    public UserDto getOne(@PathVariable("uuid") String uuid) {

        if (userService.existsById(uuid)) {
            return userService.findById(uuid);
        }
        throw new NotFoundException("User not found");
    }


    @PostMapping
    public UserDto getUserProgress(@RequestBody UserDto user) {

        return userService.save(user);
    }

}
