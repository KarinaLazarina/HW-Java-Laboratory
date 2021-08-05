package com.epam.homeworkspring.repository;

import com.epam.homeworkspring.model.Group;

public interface GroupRepository {
    Group getGroup(String title);

    Group createGroup(Group group);

    Group updateGroup(String title, Group group);

//    List<User> getUsersOfGroup(String title);

    void deleteGroup(String title);

}
