//package com.epam.homeworkspring.repository.impl;
//
//import com.epam.homeworkspring.model.Group;
//import com.epam.homeworkspring.repository.GroupRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class GroupRepositoryImpl implements GroupRepository {
//    private final List<Group> groups = new ArrayList<>();
//
//    @Override
//    public Group getGroup(String title) {
//        return groups.stream()
//                .filter(group -> group.getTitle().equals(title))
//                .findFirst()
//                .orElseThrow(()->new RuntimeException("Group is not found"));
//    }
//
//    @Override
//    public Group createGroup(Group group) {
//        groups.add(group);
//        return group;
//    }
//
//    @Override
//    public Group updateGroup(String title, Group newGroup) {
//        if (groups.removeIf(group -> group.getTitle().equals(title))) {
//            groups.add(newGroup);
//        } else throw new RuntimeException("Group is not found");
//        return newGroup;
//    }
//
//    @Override
//    public void deleteGroup(String title) {
//        groups.removeIf(group -> group.getTitle().equals(title));
//    }
//}
