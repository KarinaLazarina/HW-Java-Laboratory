package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.api.GroupApi;
import com.epam.homeworkspring.controller.assembler.GroupAssembler;
import com.epam.homeworkspring.controller.model.GroupModel;
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
    private final GroupAssembler groupAssembler;

    @Override
    public GroupModel getGroup(int id) {
        GroupDto group = groupService.getGroup(id);
        return groupAssembler.toModel(group);
    }

    @Override
    public GroupModel createGroup(GroupDto groupDto) {
        GroupDto group = groupService.createGroup(groupDto);
        return groupAssembler.toModel(group);
    }

    @Override
    public GroupModel updateGroup(int id, GroupDto groupDto) {
        GroupDto group = groupService.updateGroup(id, groupDto);
        return groupAssembler.toModel(group);
    }

    @Override
    public ResponseEntity<Void> deleteGroup(int id) {
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
