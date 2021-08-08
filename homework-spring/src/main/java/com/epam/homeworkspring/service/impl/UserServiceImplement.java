package com.epam.homeworkspring.service.impl;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.exception.UserNotFoundException;
import com.epam.homeworkspring.model.User;
import com.epam.homeworkspring.repository.UserRepository;
import com.epam.homeworkspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        log.info("Searching for user with login " + login);
        User user = userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        log.info("Find user with login " + login);
        return mapUserToUserDto(user);
    }

    @Override
//    @Transactional
    public UserDto createUser(UserDto userDto) {
        log.info("Creating user {} {} with login {}",
                userDto.getFirstName(), userDto.getLastName(), userDto.getLogin());
        if(userRepository.existsByLogin(userDto.getLogin())){
            throw new RuntimeException("User is already exist");
        }

        User user = userRepository.save(mapUserDtoToUser(userDto));
        log.info("Creat user {} {} with login {}",
                user.getFirstName(), user.getLastName(), user.getLogin());
        return mapUserToUserDto(user);
    }

    @Override
//    @Transactional
    public UserDto updateUser(String login, UserDto userDto) {
        log.info("Updating user with login {}", login);

        User persistedUser = userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        String firstName = userDto.getFirstName();
        if (Objects.nonNull(firstName)) {
            persistedUser.setFirstName(firstName);
        }
        String lastName = userDto.getLastName();
        if (Objects.nonNull(lastName)) {
            persistedUser.setLastName(lastName);
        }

        User storedUser = userRepository.save(persistedUser);
        log.info("User with login {} successfully updated", storedUser.getLogin());
        return mapUserToUserDto(storedUser);
    }

    @Override
    public void deleteUser(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        log.info("Used with login {} deleted", login);
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
