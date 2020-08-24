package com.coffeejug.trafficrules.service;

import com.coffeejug.trafficrules.db.User;
import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    private boolean goodUUID(String uuid) {

        if ((uuid != null) && (uuid.length() == 36)) {
            return true;
        }
        return false;
    }


    public UserDto findById(String id) {

        if (goodUUID(id)) {
            return findById(UUID.fromString(id));
        }
        return null;
    }

    public UserDto findById(UUID id) {

        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            user.getLevelsCompleted();
            return modelMapper.map(user, UserDto.class);
        }
        return null;
    }

    public boolean existsById(String uuid) {

        if (goodUUID(uuid)) {
            return userRepository.existsById(UUID.fromString(uuid));
        }
        return false;
    }

    public UserDto save(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }
}
