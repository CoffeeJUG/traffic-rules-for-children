package com.coffeejug.trafficrules.service;

import com.coffeejug.trafficrules.db.Progress;
import com.coffeejug.trafficrules.db.User;
import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.projection.ProgressProjection;
import com.coffeejug.trafficrules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProgressService progressService;


    public UserDto createNew() {

        User user = new User();
        user = userRepository.save(user);
        UserDto userDto = new UserDto(user.getUuid().toString());
        return userDto;
    }

    public List<ProgressProjection> getUserProgress(String uuid) {

        if (goodUUID(uuid)) {

            User user = userRepository.getOne(UUID.fromString(uuid));
            if (user != null) {
                return progressService.findAllByUser(user);
            }
        }
        return new ArrayList<>();
    }

    private boolean goodUUID(String uuid) {

        if ((uuid != null) && (uuid.length() == 36)) {
            return true;
        }
        return false;
    }


    public User getOne(UUID id) {

        if (userRepository.existsById(id)) {
            return userRepository.getOne(id);
        }
        return null;
    }


    public List<ProgressProjection> saveUserProgress(String uuid, String progress) {

        if (goodUUID(uuid)) {
            User user = getOne(UUID.fromString(uuid));
            if (user != null) {
                Progress userProgress = new Progress(progress, user);
                progressService.save(userProgress);
            }
        }
        return null;
    }
}
