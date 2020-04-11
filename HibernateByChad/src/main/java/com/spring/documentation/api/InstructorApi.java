package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/instructor")
@BasePathAwareController
public class InstructorApi {

    private final InstructorRepository instructorRepository;

    public InstructorApi(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @PostMapping
    public ResponseEntity<Instructor> save() {

        // create reviews
        Review review1 = Review.builder().comment("Love this course").build();
        Review review2 = Review.builder().comment("This course is awesome").build();
        Review review3 = Review.builder().comment("Will give 5 star to this project").build();

        // create students
        Student student1 = Student.builder().firstName("Akash").lastName("Sharma").email("akash@gmail.com").build();
        Student student2 = Student.builder().firstName("Niras").lastName("Sharma").email("niras@gmail.com").build();

        // create courses
        Course javaCourse = Course.builder().title("Java").build();
        Course javaScriptCourse = Course.builder().title("Java Script").build();

        javaCourse.addReviews(review1);
        javaCourse.addReviews(review2);
        javaCourse.addReviews(review3);

        javaCourse.addStudent(student1);
        javaCourse.addStudent(student2);


        // create instructor detail
        InstructorDetail detail = InstructorDetail.builder()
                .youtubeChannel("Udemy")
                .hobby("Learning")
                .build();

        // create instructor
        Instructor instructor = Instructor.builder()
                .firstName("Rahul")
                .lastName("Choudhary")
                .email("thecrazzyrahul@gmail.com")
                .instructorDetail(detail)
                .build();

        instructor.addCourse(javaCourse);
        instructor.addCourse(javaScriptCourse);
        instructorRepository.save(instructor);

        return new ResponseEntity<>(instructor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable String id) {
        Optional<Instructor> instructor = instructorRepository.findById(Long.parseLong(id));
        return new ResponseEntity(instructor.get(), HttpStatus.FOUND);
    }

}
