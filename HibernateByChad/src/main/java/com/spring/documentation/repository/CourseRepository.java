package com.spring.documentation.repository;

import com.spring.documentation.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByInstructor(Instructor instructor);
}
