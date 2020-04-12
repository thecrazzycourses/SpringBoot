package com.spring.documentation.api;

import com.spring.documentation.entity.*;
import com.spring.documentation.repository.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@BasePathAwareController
@RequestMapping("/table-per-class")
public class TablePerClassInheritanceApi {

    private final AnimalRepository animalRepository;
    private final MonkeyRepository monkeyRepository;
    private final DonkeyRepository donkeyRepository;

    public TablePerClassInheritanceApi(AnimalRepository animalRepository, MonkeyRepository monkeyRepository, DonkeyRepository donkeyRepository) {
        this.animalRepository = animalRepository;
        this.monkeyRepository = monkeyRepository;
        this.donkeyRepository = donkeyRepository;
    }

    @PostMapping
    public String singleTableInheritance() {

        Monkey monkey = new Monkey();
        monkey.setHands("2");
        monkey.setTail("yes");

        Donkey donkey = new Donkey();
        donkey.setLegs("4");
        donkey.setTail("yes");

        monkeyRepository.save(monkey);
        donkeyRepository.save(donkey);

        return "table-per-class inheritance created";
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Animal> all = animalRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Optional<Animal> byId = animalRepository.findById(Long.parseLong(id));
        return new ResponseEntity(byId.get(), HttpStatus.FOUND);
    }

    @GetMapping("/monkey")
    public ResponseEntity findAllEmployee() {
        List<Monkey> all = monkeyRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    @GetMapping("/donkey")
    public ResponseEntity findAllManager() {
        List<Donkey> all = donkeyRepository.findAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }
}
