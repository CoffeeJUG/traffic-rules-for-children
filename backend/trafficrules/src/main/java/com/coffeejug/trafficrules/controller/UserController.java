package com.coffeejug.trafficrules.controller;

import java.util.Optional;
import com.coffeejug.trafficrules.model.User;
import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.exception.NotFoundException;
import com.coffeejug.trafficrules.service.UserService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/{uuid}")
    public UserDto getOne(@PathVariable("uuid") String uuid) {

        Optional<User> user = userService.findById(uuid);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        throw new NotFoundException("User not found");
    }


    @PostMapping
    public UserDto getUserProgress(@RequestBody UserDto user) {

        return userService.save(user);
    }

}
