package com.example.courses.lesson.service;

import com.example.courses.lesson.dto.LessonRequestDTO;
import com.example.courses.lesson.dto.LessonResponseDTO;
import com.example.courses.lesson.exception.LessonAlreadyExistException;
import com.example.courses.lesson.exception.LessonNotFoundException;
import com.example.courses.lesson.model.LessonEntity;
import com.example.courses.lesson.model.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonResponseDTO createLesson(LessonRequestDTO requestDTO) {
        Optional<LessonEntity> check = lessonRepository.findByTitle(requestDTO.getTitle());
        if (check.isPresent()) throw  new LessonAlreadyExistException();

        LessonEntity entity = lessonRepository.save(requestDTO.entity());
        return LessonResponseDTO.of(entity);

    }

    public LessonResponseDTO updateLesson(Long id, LessonRequestDTO requestDTO) {
     LessonEntity lesson = lessonRepository.findById(id).orElseThrow(LessonNotFoundException::new);
    lesson.setTitle(requestDTO.getTitle());
    lesson.setDescription(requestDTO.getDescription());

    lesson = lessonRepository.save(lesson);
    return LessonResponseDTO.of(lesson);
}

    public LessonResponseDTO getLessonById(Long id) {
       return LessonResponseDTO.of(lessonRepository.findById(id)
               .orElseThrow(LessonNotFoundException::new));
    }

    public List<LessonResponseDTO> searchLessonsByTitle(String title) {
        List<LessonEntity> lessonEntities = lessonRepository.findByTitleContainingIgnoreCase(title);

        return lessonEntities.stream()
                .map(LessonResponseDTO::of)
                .collect(Collectors.toList());
    }

    public String deleteLesson(Long id) {
        lessonRepository.deleteById(id);
        return HttpStatus.OK.name();
    }

    public List<LessonResponseDTO> search(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);

        ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("title",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("description",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<LessonEntity> example = Example.of(
                LessonEntity.builder()
                        .title(query)
                        .title(query)
                        .build(), ignoringExampleMatcher);
        return  lessonRepository
                .findAll(example, pageable)
                .stream()
                .map(LessonResponseDTO::of)
                .collect(Collectors.toList());
    }
}
