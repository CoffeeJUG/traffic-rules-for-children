package com.coffeejug.trafficrules.web;

import com.coffeejug.trafficrules.dto.UserCodeDto;
import com.coffeejug.trafficrules.projection.ProgressPrj;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/v1/user/code")
    public ResponseEntity<UserCodeDto> generateUserCode() {
        return new ResponseEntity<UserCodeDto>(userService.generateUserCode(), HttpStatus.OK);
    }

    @GetMapping("/v1/user/progress")
    public ResponseEntity<List<ProgressPrj>> getUserProgress(@RequestParam String code) {

        if (code == null || code.length() != 10) {
            return new ResponseEntity("Wrong code", HttpStatus.BAD_REQUEST);
        }
        if (!userService.existsByCode(code)) {
            return new ResponseEntity("Code does not exists", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.getUserProgress(code), HttpStatus.OK);
    }

    @PostMapping("/v1/user/progress")
    private ResponseEntity saveProgress(@RequestParam String code,
                                        @RequestParam String mockProgress) {

        if (code == null || code.length() != 10) {
            return new ResponseEntity("Wrong code", HttpStatus.BAD_REQUEST);
        }
        if (!userService.existsByCode(code)) {
            return new ResponseEntity("Code does not exists", HttpStatus.BAD_REQUEST);
        }
        userService.saveUserProgress(code, mockProgress);
        return new ResponseEntity(HttpStatus.OK);

    }


}
