package com.spring.documentation.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    private InstructorDetail instructorDetail;

    /**
     * One To Many Bi Directional : Instructor can have multiple Courses
     * Instructor --> OneToMany --> Courses
     * ByDefault its LAZY
     */
    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    private List<Course> courses;

    // convenience method for bi-direction relationship
    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setInstructor(this);
    }
}
