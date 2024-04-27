package com.example.courses.lesson.controller;

import com.example.courses.lesson.dto.LessonRequestDTO;
import com.example.courses.lesson.dto.LessonResponseDTO;
import com.example.courses.lesson.routes.LessonRoutes;
import com.example.courses.lesson.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LessonController {

    private final LessonService lessonService;

    @PostMapping(LessonRoutes.CREATE)
    public ResponseEntity<LessonResponseDTO> createLesson(@RequestBody LessonRequestDTO requestDTO) {
        LessonResponseDTO responseDTO = lessonService.createLesson(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(LessonRoutes.UPDATE)
    public ResponseEntity<Void> updateLesson(@PathVariable Long id, @RequestBody LessonRequestDTO requestDTO){
        lessonService.updateLesson(id, requestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping(LessonRoutes.BY_ID)
    public ResponseEntity<LessonResponseDTO> getLessonBiId(@PathVariable Long id, @RequestBody LessonRequestDTO requestDTO) {
        LessonResponseDTO responseDTO = lessonService.getLessonById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(LessonRoutes.SEARCH)
    public ResponseEntity<List<LessonResponseDTO>> searchLessons(@RequestParam String title) {
        List<LessonResponseDTO> responseDTOS = lessonService.searchLessonsByTitle(title);
        return ResponseEntity.ok(responseDTOS);
    }

    @DeleteMapping(LessonRoutes.DELETE)
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok().build();
    }






}
