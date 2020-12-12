package com.coffeejug.trafficrules.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.exception.BadRequestException;
import com.coffeejug.trafficrules.exception.NotFoundException;
import com.coffeejug.trafficrules.model.User;
import com.coffeejug.trafficrules.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto findById(String id) {
        return userRepository.findById(parseUUID(id))
                .map(user -> {
                    user.setLastActivity(LocalDateTime.now());
                    return userRepository.save(user);
                })
                .map(user -> modelMapper.map(user, UserDto.class))
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public UserDto save(UserDto userDto) {
        User user = null;
        if (userDto != null && userDto.getUuid() != null) {
            user = userRepository.findById(userDto.getUuid()).orElse(new User());
        }
        if (user == null) {
            user = new User();
        }
        modelMapper.map(userDto, user);
        user.setLastActivity(LocalDateTime.now());
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    private UUID parseUUID(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid UUID " + uuid);
        }
    }

    public long count() {
        return userRepository.count();
    }

    public long countAllByRegisteredAfter(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return count();
        }
        return userRepository.countAllByRegisteredAfter(localDateTime);
    }

    public long countAllByLastActivityAfter(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return count();
        }
        return userRepository.countAllByLastActivityAfter(localDateTime);
    }

}
