package com.epam.homeworkspring;

import com.epam.homeworkspring.dto.GroupDto;
import com.epam.homeworkspring.dto.UserDto;
import com.epam.homeworkspring.service.GroupService;
import com.epam.homeworkspring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@Slf4j
@SpringBootApplication
public class HomeworkSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkSpringApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demoUser(UserService userService,
//                                      @Value("${app.user.password}") String password,
//                                      @Value("${app.user.email}") String login) {
//        return args -> {
//            UserDto userDto = UserDto.builder()
//                    .firstName("TestUserF")
//                    .lastName("TestUserL")
//                    .age(18)
//                    .login(login)
//                    .password(password)
//                    .repeatPassword(password)
////                    .groupId(1)
//                    .build();
//            log.info("Creating default user with login: {}", login);
//            userService.createUser(userDto);
//        };
//    }
//
//    @Bean
//    @Primary
//    public CommandLineRunner demoGroup(GroupService groupService) {
//        return args -> {
//            GroupDto groupDto = GroupDto.builder()
//                    .title("Group1")
//                    .kindOfActivity("sport")
//                    .maxCountOfUsers(3)
//                    .build();
//            log.info("Creating default group with title: {}", groupDto.getTitle());
//            groupService.createGroup(groupDto);
//        };
//    }
}
