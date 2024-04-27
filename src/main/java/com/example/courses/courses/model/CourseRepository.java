package com.example.courses.courses.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    List<CourseEntity> findByTitleContainingIgnoreCase(String title);
}
