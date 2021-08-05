package com.epam.homeworkspring.api;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.dto.group.OnCreate;
import com.epam.homeworkspring.dto.group.OnUpdate;
import com.epam.homeworkspring.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User Api")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    UserModel getUser(@PathVariable String login);

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    UserModel updateUser(@PathVariable String login,
                         @RequestBody @Validated(OnUpdate.class) UserDto userDto);

    //    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Delete user")
    @DeleteMapping(value = "/{login}")
    ResponseEntity<Void> deleteUser(@PathVariable String login);

}
