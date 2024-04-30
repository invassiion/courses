package com.example.courses.lesson.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository  extends JpaRepository<LessonEntity, Long> {
    List<LessonEntity> findByTitleContainingIgnoreCase(String title);
    List<LessonEntity> findByCourseId(Long courseId);
    Optional<LessonEntity> findByTitle(String title);
}
