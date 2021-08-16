package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.config.TestConfig;
import com.epam.homeworkspring.controller.assembler.GroupAssembler;
import com.epam.homeworkspring.controller.model.GroupModel;
import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.service.GroupService;
import com.epam.homeworkspring.util.GroupTestDataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.epam.homeworkspring.util.GroupTestDataUtil.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GroupController.class)
@Import(TestConfig.class)
public class GroupControllerTest {
    @MockBean
    private GroupService groupService;
    @MockBean
    private GroupAssembler groupAssembler;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getGroupTest() throws Exception {
        GroupDto groupDto = GroupTestDataUtil.createGroupDto();
        GroupModel groupModel = new GroupModel(groupDto);

        when(groupService.getGroup(ID)).thenReturn(groupDto);
        when(groupAssembler.toModel(groupDto)).thenReturn(groupModel);

        mockMvc.perform(get("/api/v1/groups/" + ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID));
    }

    @Test
    void createGroupTest() throws Exception {
        GroupDto groupDto = GroupTestDataUtil.createGroupDto();
        GroupModel groupModel = new GroupModel(groupDto);

        when(groupService.createGroup(groupDto)).thenReturn(groupDto);
        when(groupAssembler.toModel(groupDto)).thenReturn(groupModel);

        mockMvc.perform(post("/api/v1/groups")
                        .content(asJsonString(groupDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(ID));
    }

    @Test
    void updateGroupTest() throws Exception {
        GroupDto groupDto = GroupTestDataUtil.createGroupDto();
        GroupModel groupModel = new GroupModel(groupDto);

        when(groupService.updateGroup(ID, groupDto)).thenReturn(groupDto);
        when(groupAssembler.toModel(groupDto)).thenReturn(groupModel);

        mockMvc.perform(put("/api/v1/groups/" + ID)
                        .content(asJsonString(groupDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ID));
    }

    @Test
    void deleteGroupTest() throws Exception {
        mockMvc.perform(delete("/api/v1/groups/" + ID))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
