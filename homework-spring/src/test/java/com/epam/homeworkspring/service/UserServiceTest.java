package com.epam.homeworkspring.service;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.exception.UserAlreadyExistException;
import com.epam.homeworkspring.exception.UserNotFoundException;
import com.epam.homeworkspring.model.User;
import com.epam.homeworkspring.repository.UserRepository;
import com.epam.homeworkspring.service.impl.UserServiceImplement;
import com.epam.homeworkspring.util.UserTestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.epam.homeworkspring.util.UserTestDataUtil.TEST_LOGIN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceImplement userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void getUserTest(){
        User user = UserTestDataUtil.createUser();
        when(userRepository.findByLogin(TEST_LOGIN)).thenReturn(Optional.of(user));

        UserDto userDto = userService.getUser(TEST_LOGIN);

        assertThat(userDto, allOf(
                hasProperty("login", equalTo(user.getLogin())),
                hasProperty("firstName", equalTo(user.getFirstName()))
        ));

    }

    @Test
    void getUserWhenUserNotFoundTest(){
        when(userRepository.findByLogin(TEST_LOGIN)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, ()-> userService.getUser(TEST_LOGIN));
    }

    @Test
    public void createUserTest() {
        User testUser = UserTestDataUtil.createUser();
        UserDto testUserDto = UserTestDataUtil.createUserDto();
        when(userRepository.save(any())).thenReturn(testUser);

        UserDto userDto = userService.createUser(testUserDto);

        assertThat(userDto, allOf(
                hasProperty("firstName", equalTo(testUser.getFirstName())),
                hasProperty("lastName", equalTo(testUser.getLastName())),
                hasProperty("login", equalTo(testUser.getLogin()))
        ));
    }

    @Test
    public void createUserWhenUserAlreadyExistsTest() {
        UserDto testUserDto = UserTestDataUtil.createUserDto();
        when(userRepository.existsByLogin(TEST_LOGIN)).thenReturn(true);

        assertThrows(UserAlreadyExistException.class, () -> userService.createUser(testUserDto));
    }

    @Test
    public void updateUserTest() {
        User testUser = UserTestDataUtil.createUser();
        UserDto testUserDto = UserTestDataUtil.createUserDto();
        when(userRepository.findByLogin(testUserDto.getLogin())).thenReturn(Optional.of(testUser));
        when(userRepository.save(any())).thenReturn(testUser);

        UserDto userDto = userService.updateUser(testUser.getLogin(), testUserDto);

        assertThat(userDto, allOf(
                hasProperty("firstName", equalTo(testUser.getFirstName())),
                hasProperty("lastName", equalTo(testUser.getLastName())),
                hasProperty("login", equalTo(testUser.getLogin()))
        ));
    }

    @Test
    public void updateUserWhenUserNotFoundTest() {
        UserDto testUserDto = UserTestDataUtil.createUserDto();
        when(userRepository.findByLogin(TEST_LOGIN)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.updateUser(testUserDto.getLogin(), testUserDto));
    }

    @Test
    void deleteUserTest(){
        User testUser = UserTestDataUtil.createUser();
        when(userRepository.findByLogin(TEST_LOGIN)).thenReturn(Optional.of(testUser));

        userService.deleteUser(testUser.getLogin());

        verify(userRepository, times(1)).delete(testUser);
    }

    @Test
    void deleteUserWhenUserNotFoundTest(){
        when(userRepository.findByLogin(TEST_LOGIN)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, ()-> userService.deleteUser(TEST_LOGIN));
    }
}
