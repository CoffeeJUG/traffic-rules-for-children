package com.coffeejug.trafficrules.web;

import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.projection.ProgressProjection;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public UserDto createNew() {
        return userService.createNew();
    }

    @GetMapping("/{uuid}/progress")
    public List<ProgressProjection> getUserProgress(@PathVariable String uuid) {

        return userService.getUserProgress(uuid);
    }

    @PostMapping("/{uuid}/progress")
    public List<ProgressProjection> setUserProgress(@PathVariable String uuid,
                                                      @RequestParam String progress) {

        return userService.saveUserProgress(uuid, progress);
    }

}
