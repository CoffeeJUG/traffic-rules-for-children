package com.coffeejug.trafficrules.service;

import java.util.Optional;
import java.util.UUID;
import com.coffeejug.trafficrules.exception.BadRequestException;
import com.coffeejug.trafficrules.model.User;
import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(UUID.fromString(id));
    }

    public UserDto save(UserDto userDto) {
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    private UUID parseUUID(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException();
        }
    }
}
