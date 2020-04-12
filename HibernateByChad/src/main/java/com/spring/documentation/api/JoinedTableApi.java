package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@BasePathAwareController
@RequestMapping("/joined-table")
public class JoinedTableApi {

    private final SchoolRepository schoolRepository;
    private final TeacherRepository teacherRepository;
    private final PrincipalRepository principalRepository;

    public JoinedTableApi(SchoolRepository schoolRepository, TeacherRepository teacherRepository, PrincipalRepository principalRepository) {
        this.schoolRepository = schoolRepository;
        this.teacherRepository = teacherRepository;
        this.principalRepository = principalRepository;
    }

    @PostMapping
    public String singleTableInheritance() {

        Teacher teacher = new Teacher();
        teacher.setName("Delhi Public School");
        teacher.setEmail("dps@gmail.com");
        teacher.setDepartment("Science");

        Principal principal = new Principal();
        principal.setName("Dron Public School");
        principal.setEmail("drop@gmail.com");
        principal.setExperience("10 years");

        teacherRepository.save(teacher);
        principalRepository.save(principal);

        return "joined-table inheritance created";
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<School> all = schoolRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Optional<School> byId = schoolRepository.findById(Long.parseLong(id));
        return new ResponseEntity(byId.get(), HttpStatus.FOUND);
    }

    @GetMapping("/teacher")
    public ResponseEntity findAllEmployee() {
        List<Teacher> all = teacherRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/principal")
    public ResponseEntity findAllManager() {
        List<Principal> all = principalRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }
}
