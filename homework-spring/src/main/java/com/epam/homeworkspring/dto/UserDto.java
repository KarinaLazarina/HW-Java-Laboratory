package com.epam.homeworkspring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String password;
    private String repeatPassword;
}
