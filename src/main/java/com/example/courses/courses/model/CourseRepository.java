package com.example.courses.courses.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    List<CourseEntity> findByTitleContainingIgnoreCase(String title);
    Optional<CourseEntity> findByTitle(String title);
}
