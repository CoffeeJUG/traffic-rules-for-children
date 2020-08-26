package com.coffeejug.trafficrules.web;

import com.coffeejug.trafficrules.db.User;
import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.exception.NotFoundException;
import com.coffeejug.trafficrules.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;


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
