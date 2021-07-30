package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    public UserDto getUser(@PathVariable String login) {
        return userService.getUser(login);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    public UserDto updateUser(@PathVariable String login, @RequestBody UserDto userDto) {
        return userService.updateUser(login, userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{login}")
    public void deleteUser(@PathVariable String login) {
        userService.deleteUser(login);
//        return ResponseEntity.noContent().build();
    }

}
