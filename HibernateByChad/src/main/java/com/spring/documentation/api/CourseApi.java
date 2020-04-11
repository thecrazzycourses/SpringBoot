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

    public CourseApi(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
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

}
