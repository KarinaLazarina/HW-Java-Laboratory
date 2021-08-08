package com.epam.homeworkspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "groupOfUsers")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @Column(unique = true, nullable = false)
    private String title;
    private String kindOfActivity;
    private int maxCountOfUsers;
}
