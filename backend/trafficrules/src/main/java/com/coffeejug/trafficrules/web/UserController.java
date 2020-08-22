package com.coffeejug.trafficrules.web;

import com.coffeejug.trafficrules.dto.UserCodeDto;
import com.coffeejug.trafficrules.exception.BadRequestException;
import com.coffeejug.trafficrules.projection.ProgressProjection;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/code")
    public UserCodeDto generateUserCode() {
        return userService.generateUserCode();
    }

    @GetMapping("/progress")
    public List<ProgressProjection> getUserProgress(@RequestParam String code) {

        return userService.getUserProgress(code);
    }

    @PostMapping("/progress")
    public void saveProgress(@RequestParam String code,
                             @RequestParam String mockProgress) {

        userService.saveUserProgress(code, mockProgress);
    }


}
