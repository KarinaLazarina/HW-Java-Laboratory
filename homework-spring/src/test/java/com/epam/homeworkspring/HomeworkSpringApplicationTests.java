package com.epam.homeworkspring;

import com.epam.homeworkspring.controller.model.GroupModel;
import com.epam.homeworkspring.controller.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeworkSpringApplicationTests {
    @Value("http://localhost:${local.server.port}/api/v1/")
    private String baseURL;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("${app.user.email}")
    private String email;

    @Test
    void getGroupTest() {
        GroupModel groupModel = testRestTemplate.getForObject(baseURL + "groups/2", GroupModel.class);
        System.out.println(groupModel.getGroupDto().getId());
        assertEquals(groupModel.getGroupDto().getId(), 2);
    }

    @Test
    void getUserTest() {
        UserModel userModel = testRestTemplate.getForObject(baseURL + "users/" + email, UserModel.class);
        assertEquals(userModel.getUserDto().getLogin(), email);
    }

}
