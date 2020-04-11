package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/reviews")
@BasePathAwareController
public class ReviewApi {

    private final ReviewRepository reviewRepository;
    private final CourseRepository courseRepository;

    public ReviewApi(ReviewRepository reviewRepository, CourseRepository courseRepository) {
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Optional<Review> byId = reviewRepository.findById(Long.parseLong(id));
        return new ResponseEntity(byId.get(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Review> all = reviewRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }
}
