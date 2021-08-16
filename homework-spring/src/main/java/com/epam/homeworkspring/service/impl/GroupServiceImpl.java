package com.epam.homeworkspring.service.impl;

import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.exception.GroupAlreadyExistsException;
import com.epam.homeworkspring.exception.GroupNotFoundException;
import com.epam.homeworkspring.model.Group;
import com.epam.homeworkspring.repository.GroupRepository;
import com.epam.homeworkspring.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public GroupDto getGroup(int id) {
        log.info("Searching for group with id = " + id);

        Group group = groupRepository.findById(id)
                .orElseThrow(GroupNotFoundException::new);

        log.info("Find group " + group.getTitle());
        return mapGroupToGroupDto(group);
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        log.info("Creating group {}", groupDto.getTitle());
        if(groupRepository.existsByTitle(groupDto.getTitle())){
            throw new GroupAlreadyExistsException();
        }

        Group group = groupRepository.save(mapGroupDtoToGroup(groupDto));
        log.info("Creat group {} with id = {}",
                group.getTitle(), group.getId());
        return mapGroupToGroupDto(group);
    }

    @Override
    public GroupDto updateGroup(int id, GroupDto groupDto) {
        log.info("Updating group with id = {}", id);

        Group persistedGroup = groupRepository.findById(id)
                .orElseThrow(GroupNotFoundException::new);

        String title = groupDto.getTitle();
        if (Objects.nonNull(title)) {
            persistedGroup.setTitle(title);
        }
        int maxCountOfUsers = groupDto.getMaxCountOfUsers();
        if (maxCountOfUsers == 0) {
            persistedGroup.setMaxCountOfUsers(maxCountOfUsers);
        }

        Group storedGroup = groupRepository.save(persistedGroup);
        log.info("Group {} with id = {} successfully updated",
                storedGroup.getTitle(),
                storedGroup.getId());
        return mapGroupToGroupDto(storedGroup);
    }

    @Override
    public void deleteGroup(int id) {
        Group group = groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
       groupRepository.delete(group);

       log.info("Group with id = {} successfully deleted", id);
    }

    private GroupDto mapGroupToGroupDto(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .title(group.getTitle())
                .kindOfActivity(group.getKindOfActivity())
                .maxCountOfUsers(group.getMaxCountOfUsers())
                .build();
    }

    private Group mapGroupDtoToGroup(GroupDto groupDto) {
        return Group.builder()
                .id(groupDto.getId())
                .title(groupDto.getTitle())
                .kindOfActivity(groupDto.getKindOfActivity())
                .maxCountOfUsers(groupDto.getMaxCountOfUsers())
                .build();
    }
}
