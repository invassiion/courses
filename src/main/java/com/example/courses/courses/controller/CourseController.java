package com.example.courses.courses.controller;

import com.example.courses.courses.dto.CourseRequestDTO;
import com.example.courses.courses.dto.CourseResponseDTO;
import com.example.courses.courses.routes.CourseRoutes;
import com.example.courses.courses.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseService courseService;

    @PostMapping(CourseRoutes.CREATE)
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO requestDTO) {
        CourseResponseDTO responseDTO = courseService.createCourse(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(CourseRoutes.UPDATE)
    public ResponseEntity<Void> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO requestDTO) {
        courseService.updateCourse(id, requestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping(CourseRoutes.BY_ID)
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long id) {
        CourseResponseDTO responseDTO = courseService.getCourseById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(CourseRoutes.SEARCH)
    public ResponseEntity<List<CourseResponseDTO>> searchCourses(@RequestParam String title) {
        List<CourseResponseDTO> responseDTOS  = courseService.searchCoursesByTitle(title);
        return ResponseEntity.ok(responseDTOS);
    }

    @DeleteMapping(CourseRoutes.DELETE)
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }


}
