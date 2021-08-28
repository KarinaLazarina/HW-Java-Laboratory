package com.epam.homeworkspring.service.impl;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.exception.GroupNotFoundException;
import com.epam.homeworkspring.exception.PasswordNotValidException;
import com.epam.homeworkspring.exception.UserAlreadyExistException;
import com.epam.homeworkspring.exception.UserNotFoundException;
import com.epam.homeworkspring.model.Group;
import com.epam.homeworkspring.model.User;
import com.epam.homeworkspring.repository.GroupRepository;
import com.epam.homeworkspring.repository.UserRepository;
import com.epam.homeworkspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @Override
    public UserDto getUser(String login) {
        log.info("Searching for user with login " + login);
        User user = userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        log.info("Find user with login " + login);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getUsers(Pageable pageable) {
        log.info("Searching for users");
        Page<User> users = userRepository.findAll(pageable);

        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            userDtoList.add(mapUserToUserDto(user));
        }
        log.info("Find users: {}", users);
        return userDtoList;
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        log.info("Creating user {} {} with login {}",
                userDto.getFirstName(), userDto.getLastName(), userDto.getLogin());
        if (userRepository.existsByLogin(userDto.getLogin())) {
            throw new UserAlreadyExistException();
        }

        User user = userRepository.save(mapUserDtoToUser(userDto));
        log.info("Creat user {} {} with login {}",
                user.getFirstName(), user.getLastName(), user.getLogin());
        return mapUserToUserDto(user);
    }

    @Override
    @Transactional
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
        Integer age = userDto.getAge();
        if (Objects.nonNull(age)) {
            persistedUser.setAge(age);
        }
        if (userDto.getGroupId() > 0) {
            Group group = groupRepository.findById(userDto.getGroupId())
                    .orElseThrow(GroupNotFoundException::new);
            if (Objects.nonNull(group)) {
                persistedUser.setGroup(group);
            }
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
        UserDto userDto = UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .login(user.getLogin())
                .build();

        Group group = user.getGroup();
        if (Objects.nonNull(group)) {
            userDto.setGroupId(group.getId());
        }
        return userDto;
    }

    private User mapUserDtoToUser(UserDto userDto) {
        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .login(userDto.getLogin())
                .password(extractPassword(userDto))
                .build();
        if (userDto.getGroupId() > 0) {
            Group group = groupRepository.findById(userDto.getGroupId())
                    .orElseThrow(GroupNotFoundException::new);
            user.setGroup(group);
        }
        return user;
    }

    private String extractPassword(UserDto userDto) {
        if (userDto.getPassword() != null &&
                Objects.equals(userDto.getPassword(), userDto.getRepeatPassword())) {
            return userDto.getPassword();
        } else {
            throw new PasswordNotValidException();
        }
    }

}
