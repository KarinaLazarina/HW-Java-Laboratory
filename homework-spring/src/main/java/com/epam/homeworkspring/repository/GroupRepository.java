package com.epam.homeworkspring.repository;

import com.epam.homeworkspring.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    boolean existsByTitle(String title);
}
