package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
@BasePathAwareController
public class StudentApi {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentApi(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Optional<Student> byId = studentRepository.findById(Long.parseLong(id));
        return new ResponseEntity(byId.get(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Student> all = studentRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity findAll(@PathVariable String id) {
        Optional<Course> byId = courseRepository.findById(Long.parseLong(id));
        List<Student> all = studentRepository.findAllByCourses(byId.get());
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id) {

        Optional<Student> byId = studentRepository.findById(Long.parseLong(id));

        // create images
        Set<String> images = new HashSet<>();
        images.add("Pic_1.jpg");
        images.add("Pic_2.jpg");
        images.add("Pic_3.jpg");
        images.add("Pic_4.jpg");
        byId.get().setImages(images);

        // create subjects
        List<String> subjects = new ArrayList<>();
        subjects.add("1. Computers");
        subjects.add("2. Algorithms");
        subjects.add("3. Datastructures");
        subjects.add("4. Compiler");
        byId.get().setSubjects(subjects);

        // create sports
        Map<String, String> sports = new HashMap<>();
        sports.put("Cricket", "Need Bat and Ball");
        sports.put("Volleyball", "Need Volleyball");
        sports.put("BasketBall", "Need BasketBall");
        sports.put("Badminton", "Need Racket and Shuttle");
        byId.get().setSports(sports);

        studentRepository.save(byId.get());

        return byId.get();

    }
}
