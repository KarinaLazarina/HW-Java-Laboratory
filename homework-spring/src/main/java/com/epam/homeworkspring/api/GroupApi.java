package com.epam.homeworkspring.api;

import com.epam.homeworkspring.controller.model.GroupModel;
import com.epam.homeworkspring.dto.GroupDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Group of users Api")
@RequestMapping("/api/v1/groups")
public interface GroupApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Group title"),
    })
    @ApiOperation("Get group")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    GroupModel getGroup(@PathVariable int id);


    @ApiOperation("Create group")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    GroupModel createGroup(@RequestBody GroupDto groupDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Group title"),
    })
    @ApiOperation("Update group")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    GroupModel updateGroup(@PathVariable int id, @RequestBody GroupDto groupDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Group title"),
    })
    @ApiOperation("Delete group")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteGroup(@PathVariable int id);
}
