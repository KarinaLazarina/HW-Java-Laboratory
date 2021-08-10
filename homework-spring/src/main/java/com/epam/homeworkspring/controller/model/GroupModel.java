package com.epam.homeworkspring.controller.model;

import com.epam.homeworkspring.dto.GroupDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class GroupModel extends RepresentationModel<GroupModel> {
    @JsonUnwrapped
    private GroupDto groupDto;
}
