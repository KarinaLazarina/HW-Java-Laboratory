package com.epam.homeworkspring.service;

import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.model.Group;

public interface GroupService {
    GroupDto getGroup(int id);

    GroupDto createGroup(GroupDto groupDto);

    GroupDto updateGroup(int id, GroupDto groupDto);

    void deleteGroup(int id);
}
