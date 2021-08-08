package com.epam.homeworkspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Column(unique = true, nullable = false)
    private String login;
    private String password;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "group_id")
//    private Group group;
}
