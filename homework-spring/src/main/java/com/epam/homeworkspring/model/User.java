package com.epam.homeworkspring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    private String password;
    private int groupId;
}
