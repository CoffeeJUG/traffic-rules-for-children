package com.coffeejug.trafficrules.service;

import java.util.Optional;
import java.util.UUID;
import com.coffeejug.trafficrules.dto.UserDto;
import com.coffeejug.trafficrules.exception.BadRequestException;
import com.coffeejug.trafficrules.exception.NotFoundException;
import com.coffeejug.trafficrules.model.User;
import com.coffeejug.trafficrules.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, new ModelMapper());
    }

    @Test
    void shouldCreateNewUser() {
        when(userRepository.save(any())).then(a -> a.getArgument(0));
        UUID uuid = UUID.randomUUID();
        UserDto savedUser = userService.save(new UserDto(uuid, 3, "John Doe"));

        assertThat(savedUser).isEqualTo(new UserDto(uuid, 3, "John Doe"));
    }

    @Test
    void shouldFindExistingUser() {
        UUID uuid = UUID.randomUUID();
        when(userRepository.findById(any()))
                .thenReturn(Optional.of(new User(uuid, 5, "James Hatfield")));

        UserDto existingUser = userService.findById(uuid.toString());

        assertThat(existingUser).isEqualTo(new UserDto(uuid, 5, "James Hatfield"));
    }

    @Test
    void shouldThrowNotFoundExceptionForNonExistingUser() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.findById(UUID.randomUUID().toString()))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("User not found");
    }

    @Test
    void shouldThrowBadRequestForInvalidUUID() {
        assertThatThrownBy(() -> userService.findById("this is not UUID"))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Invalid UUID this is not UUID");
    }
}