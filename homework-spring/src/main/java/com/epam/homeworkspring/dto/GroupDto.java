package com.epam.homeworkspring.dto;

import com.epam.homeworkspring.dto.group.OnCreate;
import com.epam.homeworkspring.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDto {
    @Null(message = "Field should be empty", groups = {OnUpdate.class, OnCreate.class})
    private int id;

    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    private String title;

    @Null(message = "Field should be empty", groups = OnUpdate.class)
    @NotBlank(message = "Field can't be empty", groups = OnCreate.class)
    private String kindOfActivity;

    @Min(value = 1)
    private int maxCountOfUsers;
}
