package com.epam.homeworkspring.api;

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
    @GetMapping(value = "/{title}")
    GroupDto getGroup(@PathVariable String title);


    @ApiOperation("Create group")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    GroupDto createGroup(@RequestBody GroupDto groupDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Group title"),
    })
    @ApiOperation("Update group")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{title}")
    GroupDto updateGroup(@PathVariable String title, @RequestBody GroupDto groupDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", paramType = "path", required = true, value = "Group title"),
    })
    @ApiOperation("Delete group")
    @DeleteMapping(value = "/{title}")
    ResponseEntity<Void> deleteGroup(@PathVariable String title);
}
