package com.epam.homeworkspring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Group {
    private int id;
    private String title;
    private String kindOfActivity;
    private int maxCountOfUsers;
}
