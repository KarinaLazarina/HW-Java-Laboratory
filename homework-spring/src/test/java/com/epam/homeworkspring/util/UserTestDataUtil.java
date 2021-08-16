package com.epam.homeworkspring.util;

import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTestDataUtil {
    public static final String FIRST_NAME = "FirstName";
    public static final String FIRST_NAME_UPDATED = "FirstName2";
    public static final String LAST_NAME = "LastName";
    public static final int AGE = 18;
    public static final String TEST_LOGIN = "email@email.com";
    private static final String PASSWORD = "password";

    public static User createUser(){
        return User.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .age(AGE)
                .login(TEST_LOGIN)
                .password(PASSWORD)
                .build();
    }

    public static UserDto createUserDto(){
        return UserDto.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .age(AGE)
                .login(TEST_LOGIN)
                .password(PASSWORD)
                .repeatPassword(PASSWORD)
                .build();
    }

    public static UserDto createUserDtoForUpdate(){
        return UserDto.builder()
                .firstName(FIRST_NAME_UPDATED)
                .lastName(LAST_NAME)
                .age(AGE)
                .build();
    }

    public static UserDto createUpdatedUser(){
        return UserDto.builder()
                .firstName(FIRST_NAME_UPDATED)
                .lastName(LAST_NAME)
                .age(AGE)
                .login(TEST_LOGIN)
                .password(PASSWORD)
                .repeatPassword(PASSWORD)
                .build();
    }
}
