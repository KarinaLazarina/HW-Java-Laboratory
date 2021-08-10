package com.epam.homeworkspring.service;

import com.epam.homeworkspring.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto getUser(String login);

    List<UserDto> getUsers(Pageable pageable);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String login, UserDto userDto);

    void deleteUser(String login);
}
