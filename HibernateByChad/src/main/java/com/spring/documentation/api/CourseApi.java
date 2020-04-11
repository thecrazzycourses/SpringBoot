package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/courses")
@BasePathAwareController
public class CourseApi {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public CourseApi(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Optional<Course> byId = courseRepository.findById(Long.parseLong(id));
        return new ResponseEntity(byId.get(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Course> all = courseRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity findAllByInstructorId(@PathVariable String id) {
        Optional<Instructor> byId = instructorRepository.findById(Long.parseLong(id));
        List<Course> all = courseRepository.findAllByInstructor(byId.get());
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

}
