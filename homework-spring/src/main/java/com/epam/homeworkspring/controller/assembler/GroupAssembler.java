package com.epam.homeworkspring.controller.assembler;

import com.epam.homeworkspring.controller.GroupController;
import com.epam.homeworkspring.controller.model.GroupModel;
import com.epam.homeworkspring.dto.GroupDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GroupAssembler extends RepresentationModelAssemblerSupport<GroupDto, GroupModel> {
    public static final String GET_REL = "get_group";
    public static final String CREATE_REL = "create_group";
    public static final String UPDATE_REL = "update_group";
    public static final String DELETE_REL = "delete_group";

    public GroupAssembler() {
        super(GroupDto.class, GroupModel.class);
    }

    @Override
    public GroupModel toModel(GroupDto entity) {
        GroupModel groupModel = new GroupModel(entity);

        Link get = linkTo(methodOn(GroupController.class).getGroup(entity.getId())).withRel(GET_REL);
        Link post = linkTo(methodOn(GroupController.class).createGroup(entity)).withRel(CREATE_REL);
        Link update = linkTo(methodOn(GroupController.class).updateGroup(entity.getId(), entity)).withRel(UPDATE_REL);
        Link delete = linkTo(methodOn(GroupController.class).deleteGroup(entity.getId())).withRel(DELETE_REL);

        groupModel.add(get, post, update, delete);
        return groupModel;
    }

}
