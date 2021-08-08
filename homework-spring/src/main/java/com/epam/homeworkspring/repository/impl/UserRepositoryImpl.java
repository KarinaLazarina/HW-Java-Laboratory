package com.epam.homeworkspring.repository.impl;

import com.epam.homeworkspring.exception.UserNotFoundException;
import com.epam.homeworkspring.model.User;
import com.epam.homeworkspring.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
//public class UserRepositoryImpl implements UserRepository {
//    private final List<User> list = new ArrayList<>();
//
//    @Override
//    public User getUser(String login) {
//        return list.stream()
//                .filter(user -> user.getLogin().equals(login))
//                .findFirst()
//                .orElseThrow(UserNotFoundException::new);
//    }
//
//    @Override
//    public User createUser(User user) {
//        list.add(user);
//        return user;
//    }
//
//    @Override
//    public User updateUser(String login, User newUser) {
//        if (list.removeIf(user -> user.getLogin().equals(login))) {
//            list.add(newUser);
//        } else throw new UserNotFoundException();
//        return newUser;
//    }
//
//    @Override
//    public void deleteUser(String login) {
//        list.removeIf(user -> user.getLogin().equals(login));
//    }
//}
