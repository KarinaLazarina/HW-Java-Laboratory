package com.epam.homeworkspring.controller;

import com.epam.homeworkspring.config.TestConfig;
import com.epam.homeworkspring.controller.assembler.UserAssembler;
import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.controller.model.UserModel;
import com.epam.homeworkspring.service.UserService;
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

import static com.epam.homeworkspring.util.UserTestDataUtil.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@Import(TestConfig.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @MockBean
    private UserAssembler userAssembler;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUserTest() throws Exception {
        UserDto userDto = createUserDto();
        UserModel userModel = new UserModel(userDto);

        when(userService.getUser(TEST_LOGIN)).thenReturn(userDto);
        when(userAssembler.toModel(userDto)).thenReturn(userModel);

        mockMvc.perform(get("/api/v1/users/" + TEST_LOGIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.login").value(TEST_LOGIN));
    }

    @Test
    void createUserTest() throws Exception {
        UserDto userDto = createUserDto();
        UserModel userModel = new UserModel(userDto);

        when(userService.createUser(userDto)).thenReturn(userDto);
        when(userAssembler.toModel(userDto)).thenReturn(userModel);

        mockMvc.perform(post("/api/v1/users")
                        .content(asJsonString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.login").value(TEST_LOGIN));
    }

    @Test
    void updateUserTest() throws Exception {
        UserDto userDto = createUserDtoForUpdate();
        UserDto updatedUserDto = createUpdatedUser();
        UserModel userModel = new UserModel(updatedUserDto);

        when(userService.updateUser(TEST_LOGIN, userDto)).thenReturn(updatedUserDto);
        when(userAssembler.toModel(updatedUserDto)).thenReturn(userModel);

        mockMvc.perform(put("/api/v1/users/" + TEST_LOGIN)
                        .content(asJsonString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(FIRST_NAME_UPDATED))
                .andExpect(jsonPath("$.login").value(TEST_LOGIN));

    }

    @Test
    void deleteUserTest() throws Exception {
        mockMvc.perform(delete("/api/v1/users/" + TEST_LOGIN))
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
