package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.api.GroupApi;
import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GroupController implements GroupApi {
    private final GroupService groupService;

    @Override
    public GroupDto getGroup(String title) {
        return groupService.getGroup(title);
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        return groupService.createGroup(groupDto);
    }

    @Override
    public GroupDto updateGroup(String title, GroupDto groupDto) {
        return groupService.updateGroup(title, groupDto);
    }

    @Override
    public ResponseEntity<Void> deleteGroup(String title) {
        groupService.deleteGroup(title);
        return ResponseEntity.noContent().build();
    }
}
