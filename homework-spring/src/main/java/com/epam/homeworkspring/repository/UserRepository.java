package com.epam.homeworkspring.repository;

import com.epam.homeworkspring.model.User;

public interface UserRepository {

    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);

}
