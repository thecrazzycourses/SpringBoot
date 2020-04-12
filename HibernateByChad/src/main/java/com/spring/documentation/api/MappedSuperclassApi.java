package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@BasePathAwareController
@RequestMapping("/mapped-superclass")
public class MappedSuperclassApi {

    /**
     * High Performance with Normalized Database
     * Data Integrity with Not Null
     * No direct support for Super Class we nee to write HQL which result in many joins
     * 
     */

    private final LogUserRepository logUserRepository;

    public MappedSuperclassApi(LogUserRepository logUserRepository) {
        this.logUserRepository = logUserRepository;
    }

    @PostMapping
    public String singleTableInheritance() {

        LogUser logUser = new LogUser();
        logUser.setName("Logged User 1");
        logUser.setCreatedAt(new Date());
        logUser.setUpdatedAt(new Date());

        logUserRepository.save(logUser);

        return "mapped-superclass inheritance created";
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<LogUser> all = logUserRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }
}
