package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import lombok.extern.slf4j.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/instructor-detail")
@BasePathAwareController
@Slf4j
public class InstructorDetailApi {

    private final InstructorDetailRepository instructorDetailRepository;

    public InstructorDetailApi(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable String id) {
        Optional<InstructorDetail> instructorDetail = instructorDetailRepository.findById(Long.parseLong(id));
        return new ResponseEntity(instructorDetail.get(), HttpStatus.FOUND);
    }
}
