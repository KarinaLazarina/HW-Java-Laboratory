package com.epam.homeworkspring.service;

import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.model.Group;

public interface GroupService {
    GroupDto getGroup(String title);

    GroupDto createGroup(GroupDto groupDto);

    GroupDto updateGroup(String title, GroupDto groupDto);

    void deleteGroup(String title);
}
