package com.coffeejug.trafficrules.service;

import com.coffeejug.trafficrules.db.User;
import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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


    public Optional<User> findById(String id) {

        if (goodUUID(id)) {
            return findById(UUID.fromString(id));
        }
        return Optional.empty();
    }

    public Optional<User> findById(UUID id) {

        return userRepository.findById(id);
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
