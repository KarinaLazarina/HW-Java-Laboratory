package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.api.UserApi;
import com.epam.homeworkspring.controller.assembler.UserAssembler;
import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.controller.model.UserModel;
import com.epam.homeworkspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {
    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public List<UserModel> getUsers(int page) {
        Pageable sortedByLogin = PageRequest.of(page, 2, Sort.by("login"));
        List<UserDto> users = userService.getUsers(sortedByLogin);

        List<UserModel> userModels = new ArrayList<>();
        for (UserDto user : users) {
            userModels.add(userAssembler.toModel(user));
        }
        return userModels;
    }

    @Override
    public UserModel getUser(String login) {
        UserDto user = userService.getUser(login);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String login, UserDto userDto) {
        UserDto user = userService.updateUser(login, userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String login) {
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }

}
