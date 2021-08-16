package com.epam.homeworkspring.service;

import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.exception.GroupAlreadyExistsException;
import com.epam.homeworkspring.exception.GroupNotFoundException;
import com.epam.homeworkspring.model.Group;
import com.epam.homeworkspring.repository.GroupRepository;
import com.epam.homeworkspring.service.impl.GroupServiceImpl;
import com.epam.homeworkspring.util.GroupTestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.epam.homeworkspring.util.GroupTestDataUtil.ID;
import static com.epam.homeworkspring.util.GroupTestDataUtil.TITLE;
import static com.epam.homeworkspring.util.UserTestDataUtil.TEST_LOGIN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GroupServiceTest {
    @InjectMocks
    private GroupServiceImpl groupService;

    @Mock
    private GroupRepository groupRepository;

    @Test
    void getGroupTest(){
        Group group = GroupTestDataUtil.createGroup();
        when(groupRepository.findById(ID)).thenReturn(Optional.of(group));

        GroupDto groupDto = groupService.getGroup(ID);

        assertThat(groupDto, allOf(
                hasProperty("title", equalTo(group.getTitle())),
                hasProperty("kindOfActivity", equalTo(group.getKindOfActivity()))
        ));

    }

    @Test
    void getGroupWheUserNotFoundTest(){
        when(groupRepository.findById(ID)).thenReturn(Optional.empty());
        assertThrows(GroupNotFoundException.class, () -> groupService.getGroup(ID));
    }

    @Test
    void createGroupTest(){
        Group group = GroupTestDataUtil.createGroup();
        GroupDto groupDto = GroupTestDataUtil.createGroupDto();
        when(groupRepository.save(ArgumentMatchers.any())).thenReturn(group);

        GroupDto savedGroupDto = groupService.createGroup(groupDto);

        assertThat(savedGroupDto, allOf(
                hasProperty("title", equalTo(group.getTitle())),
                hasProperty("kindOfActivity", equalTo(group.getKindOfActivity()))
        ));
    }

    @Test
    void createGroupWhenGroupAlreadyExistsTest(){
        GroupDto groupDto = GroupTestDataUtil.createGroupDto();
        when(groupRepository.existsByTitle(TITLE)).thenReturn(true);

        assertThrows(GroupAlreadyExistsException.class, () -> groupService.createGroup(groupDto));
    }


    @Test
    void updateGroupWheUserNotFoundTest(){
        GroupDto groupDto = GroupTestDataUtil.createGroupDto();
        when(groupRepository.findById(ID)).thenReturn(Optional.empty());
        assertThrows(GroupNotFoundException.class, () -> groupService.updateGroup(ID, groupDto));
    }


    @Test
    void updateGroupTest(){
        Group group = GroupTestDataUtil.createGroup();
        GroupDto groupDto = GroupTestDataUtil.createGroupDto();
        when(groupRepository.findById(ID)).thenReturn(Optional.of(group));
        when(groupRepository.save(ArgumentMatchers.any())).thenReturn(group);

        GroupDto savedGroupDto = groupService.updateGroup(ID, groupDto);

        assertThat(savedGroupDto, allOf(
                hasProperty("title", equalTo(group.getTitle())),
                hasProperty("kindOfActivity", equalTo(group.getKindOfActivity()))
        ));
    }

    @Test
    void deleteGroupTest(){
        Group group = GroupTestDataUtil.createGroup();
        when(groupRepository.findById(ID)).thenReturn(Optional.of(group));

        groupService.deleteGroup(group.getId());

        verify(groupRepository, times(1)).delete(group);
    }


    @Test
    void deleteGroupWheUserNotFoundTest(){
        when(groupRepository.findById(ID)).thenReturn(Optional.empty());
        assertThrows(GroupNotFoundException.class, () -> groupService.deleteGroup(ID));
    }


}
