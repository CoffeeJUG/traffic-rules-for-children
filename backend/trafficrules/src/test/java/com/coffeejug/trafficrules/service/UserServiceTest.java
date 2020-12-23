package com.coffeejug.trafficrules.service;

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

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

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
    void shouldFindExistingUser() {
        UUID uuid = UUID.randomUUID();
        when(userRepository.findById(any()))
                .thenReturn(Optional.of(new User(uuid, 5, "James Hatfield")));
        when(userRepository.save(any())).then(a -> a.getArgument(0));

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

    @Test
    void shouldCreateNewUser() {
        UUID uuid = UUID.randomUUID();
        when(userRepository.findById(uuid)).thenReturn(Optional.empty());
        when(userRepository.save(any())).then(a -> a.getArgument(0));
        UserDto savedUser = userService.save(new UserDto(uuid, 3, "John Doe"));
        assertThat(savedUser).isEqualTo(new UserDto(uuid, 3, "John Doe"));
    }

    @Test
    void shouldChangeExistingUser() {
        UUID uuid = UUID.randomUUID();
        User user = new User();
        user.setUuid(uuid);
        user.setLevelsCompleted(3);
        user.setName("John Doe");
        when(userRepository.findById(uuid)).thenReturn(Optional.of(user));
        when(userRepository.save(any())).then(a -> a.getArgument(0));
        UserDto savedUser = userService.save(new UserDto(uuid, 4, "John Doe"));
        assertThat(savedUser).isEqualTo(new UserDto(uuid, 4, "John Doe"));
    }

    @Test
    void shouldCount() {
        when(userRepository.count()).thenReturn(5L);
        assertThat(userService.count()).isEqualTo(5L);
    }

    @Test
    void shouldCountAllByRegisteredAfterIfTimeNull() {
        when(userService.count()).thenReturn(7L);
        assertThat(userService.countAllByRegisteredAfter(null)).isEqualTo(7L);
    }

    @Test
    void shouldCountAllByRegisteredAfterIfTimeNotNull() {
        LocalDateTime localDateTime = LocalDateTime.now();
        when(userRepository.countAllByRegisteredAfter(localDateTime)).thenReturn(2L);
        assertThat(userService.countAllByRegisteredAfter(localDateTime)).isEqualTo(2L);
    }

    @Test
    void shouldCountAllByLastActivityAfterIfTimeNull() {
        when(userService.count()).thenReturn(6L);
        assertThat(userService.countAllByLastActivityAfter(null)).isEqualTo(6L);
    }

    @Test
    void shouldCountAllByLastActivityAfterIfTimeNotNull() {
        LocalDateTime localDateTime = LocalDateTime.now();
        when(userRepository.countAllByLastActivityAfter(localDateTime)).thenReturn(11L);
        assertThat(userService.countAllByLastActivityAfter(localDateTime)).isEqualTo(11L);
    }
}