package com.coffeejug.trafficrules.service;

import com.coffeejug.trafficrules.db.Progress;
import com.coffeejug.trafficrules.db.User;
import com.coffeejug.trafficrules.dto.UserCodeDto;
import com.coffeejug.trafficrules.projection.ProgressProjection;
import com.coffeejug.trafficrules.repository.UserRepository;
import com.coffeejug.trafficrules.util.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProgressService progressService;

    public UserCodeDto generateUserCode() {

        // search for code
        String code;
        while (existsByCode(code = CodeGenerator.generateCode())) ;

        // create new user with this code and save it to DB
        User user = new User(code);
        userRepository.save(user);

        // return DTO with code
        return new UserCodeDto(code);
    }


    public boolean existsByCode(String code) {
        if (code == null) {
            return false;
        }
        return userRepository.existsByCode(code);
    }

    public List<ProgressProjection> getUserProgress(String code) {

        User user = userRepository.findByCode(code);
        if (user == null) return new ArrayList<>();
        return progressService.findAllByUser(user);
    }

    public void saveUserProgress(String code, String mockProgress) {

        User user = userRepository.findByCode(code);
        if (user != null) {
            Progress progress = new Progress(mockProgress, user);
            progressService.save(progress);
        }

    }
}
