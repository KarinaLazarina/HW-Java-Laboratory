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
    public GroupDto getGroup(int id) {
        return groupService.getGroup(id);
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        return groupService.createGroup(groupDto);
    }

    @Override
    public GroupDto updateGroup(int id, GroupDto groupDto) {
        return groupService.updateGroup(id, groupDto);
    }

    @Override
    public ResponseEntity<Void> deleteGroup(int id) {
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
