package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.dto.group.OnCreate;
import com.epam.homeworkspring.dto.group.OnUpdate;
import com.epam.homeworkspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    public UserDto getUser(@PathVariable String login,
                           HttpServletRequest request) {
        log.info("Path: " + request.getRequestURI());
        return userService.getUser(login);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto,
                              HttpServletRequest request){
        log.info("Path: " + request.getRequestURI());
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    public UserDto updateUser(@PathVariable String login,
                              @RequestBody @Validated(OnUpdate.class) UserDto userDto,
                              HttpServletRequest request)
    {
        log.info("Path: " + request.getRequestURI());
        return userService.updateUser(login, userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{login}")
    public void deleteUser(@PathVariable String login,
                           HttpServletRequest request) {
        log.info("Path: " + request.getRequestURI());
        userService.deleteUser(login);
    }

}
