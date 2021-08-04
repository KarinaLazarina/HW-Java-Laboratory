package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.controller.assembler.UserAssembler;
import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.dto.group.OnCreate;
import com.epam.homeworkspring.dto.group.OnUpdate;
import com.epam.homeworkspring.model.UserModel;
import com.epam.homeworkspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserAssembler userAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    public UserModel getUser(@PathVariable String login) {
        UserDto user = userService.getUser(login);
        return userAssembler.toModel(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto){
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    public UserModel updateUser(@PathVariable String login,
                              @RequestBody @Validated(OnUpdate.class) UserDto userDto)
    {
        UserDto user = userService.updateUser(login, userDto);
        return userAssembler.toModel(user);
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{login}")
    public ResponseEntity<Void> deleteUser(@PathVariable String login) {
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }

}
