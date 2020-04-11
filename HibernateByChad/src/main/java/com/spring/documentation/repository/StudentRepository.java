package com.spring.documentation.repository;

import com.spring.documentation.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByCourses(Course course);
}
