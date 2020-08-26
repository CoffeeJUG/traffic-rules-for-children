package com.coffeejug.trafficrules.service;

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
                .map(user -> modelMapper.map(user, UserDto.class))
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public UserDto save(UserDto userDto) {
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    private UUID parseUUID(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid UUID " + uuid);
        }
    }
}
