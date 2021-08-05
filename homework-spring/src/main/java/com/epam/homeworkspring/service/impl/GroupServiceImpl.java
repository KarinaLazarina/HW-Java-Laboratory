package com.epam.homeworkspring.service.impl;

import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.model.Group;
import com.epam.homeworkspring.repository.GroupRepository;
import com.epam.homeworkspring.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public GroupDto getGroup(String title) {
        Group group = groupRepository.getGroup(title);

        log.info("Get group " + title);
        return mapGroupToGroupDto(group);
    }

    @Override
    public GroupDto createGroup(GroupDto group) {
        groupRepository.createGroup(mapGroupDtoToGroup(group));

        log.info("Create group " + group.getTitle());
        return group;
    }

    @Override
    public GroupDto updateGroup(String title, GroupDto groupDto) {
        Group group = groupRepository.getGroup(title);
        Group newGroup = mapGroupDtoToGroup(groupDto);

        newGroup.setKindOfActivity(group.getKindOfActivity());

        log.info("Update group " + title);
        return mapGroupToGroupDto(groupRepository.updateGroup(title, newGroup));
    }

    @Override
    public void deleteGroup(String title) {
        groupRepository.deleteGroup(title);
        log.info("Delete group " + title);
    }

    private GroupDto mapGroupToGroupDto(Group group) {
        return GroupDto.builder()
                .title(group.getTitle())
                .kindOfActivity(group.getKindOfActivity())
                .maxCountOfUsers(group.getMaxCountOfUsers())
                .build();
    }

    private Group mapGroupDtoToGroup(GroupDto groupDto) {
        return Group.builder()
                .title(groupDto.getTitle())
                .kindOfActivity(groupDto.getKindOfActivity())
                .maxCountOfUsers(groupDto.getMaxCountOfUsers())
                .build();
    }
}
