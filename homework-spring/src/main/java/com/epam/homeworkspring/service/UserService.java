package com.epam.homeworkspring.service;

import com.epam.homeworkspring.dto.UserDto;

public interface UserService {
    UserDto getUser(String login);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String login, UserDto userDto);

    void deleteUser(String login);
}
