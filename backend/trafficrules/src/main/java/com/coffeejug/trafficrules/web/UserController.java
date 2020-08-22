package com.coffeejug.trafficrules.web;

import com.coffeejug.trafficrules.dto.UserCodeDto;
import com.coffeejug.trafficrules.exception.BadRequestException;
import com.coffeejug.trafficrules.projection.ProgressProjection;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

        if (code == null || code.length() != 10) {
            throw new BadRequestException("Wrong code");
        }
        if (!userService.existsByCode(code)) {
            throw new BadRequestException("Code does not exists");
        }
        return userService.getUserProgress(code);
    }

    @PostMapping("/progress")
    public void saveProgress(@RequestParam String code,
                             @RequestParam String mockProgress) {

        if (code == null || code.length() != 10) {
            throw new BadRequestException("Wrong code");
        }
        if (!userService.existsByCode(code)) {
            throw new BadRequestException("Code does not exists");
        }
        userService.saveUserProgress(code, mockProgress);
    }


}
