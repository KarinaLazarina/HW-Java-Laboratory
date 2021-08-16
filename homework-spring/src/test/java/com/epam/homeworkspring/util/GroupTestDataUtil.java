package com.epam.homeworkspring.util;

import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.model.Group;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupTestDataUtil {
    public static final String TITLE = "Title";
    public static final String KIND_OF_ACTIVITY = "SPORT";
    public static final int MAX_COUNT_OF_USERS = 3;
    public static final int ID = 1;

    public static Group createGroup(){
        return Group.builder()
                .id(ID)
                .title(TITLE)
                .kindOfActivity(KIND_OF_ACTIVITY)
                .maxCountOfUsers(MAX_COUNT_OF_USERS)
                .build();
    }

    public static GroupDto createGroupDto(){
        return GroupDto.builder()
                .id(ID)
                .title(TITLE)
                .kindOfActivity(KIND_OF_ACTIVITY)
                .maxCountOfUsers(MAX_COUNT_OF_USERS)
                .build();
    }
}
