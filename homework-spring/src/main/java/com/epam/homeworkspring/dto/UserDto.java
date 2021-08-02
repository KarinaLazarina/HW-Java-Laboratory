package com.epam.homeworkspring.dto;

import com.epam.homeworkspring.dto.group.OnCreate;
import com.epam.homeworkspring.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    private String lastName;

//    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    @Min(value = 18, message = "User age should be grater than 18")
    private Integer age;

    @Null(message = "Field should be empty", groups = OnUpdate.class)
    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    @Email
    private String login;

    @Null(message = "Field should be empty", groups = OnUpdate.class)
    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    private String password;

    @Null(message = "Field should be empty", groups = OnUpdate.class)
    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    private String repeatPassword;
}
