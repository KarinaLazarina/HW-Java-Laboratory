package com.epam.homeworkspring.service.impl;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.model.User;
import com.epam.homeworkspring.repository.UserRepository;
import com.epam.homeworkspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        return mapUserToUserDto(userRepository.getUser(login));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userRepository.createUser(mapUserDtoToUser(userDto));
        return userDto;
    }

    @Override
    public UserDto updateUser(String login, UserDto userDto) {
        userRepository.updateUser(login, mapUserDtoToUser(userDto));
        return userDto;
    }

    @Override
    public void deleteUser(String login) {
        userRepository.deleteUser(login);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .login(user.getLogin())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
    }

}
