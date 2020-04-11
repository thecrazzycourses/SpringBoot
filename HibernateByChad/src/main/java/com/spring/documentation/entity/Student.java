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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    /**
     * Student can have multiple courses
     * We are defining this relationship on student side so coursewill be inverse
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private List<Course> courses;

    /**
     * Set
     * Order will not be preserved and dont allow duplicates
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "file_name")
    private Set<String> images = new HashSet<>();

    /**
     * List
     * Order will be preserved and allow duplicates
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "subject")
    @OrderColumn
    @Column(name = "subject_name")
    private List<String> subjects = new ArrayList<>();

    /**
     * Map
     * Order will not be preserved and dont allow key duplicates but allow value duplicates
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "sport")
    @MapKeyColumn(name = "sport_key")
    @Column(name = "sport_value")
    private Map<String, String > sports = new HashMap<>();

    /**
     * Sorted Map
     * Order will not be preserved and dont allow key duplicates but allow value duplicates
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "laptop")
    @MapKeyColumn(name = "laptop_key")
    @Column(name = "laptop_value")
    @OrderBy
    private SortedMap<String, String> laptops = new TreeMap<>();

    @Embedded
    private Address studentAddress;

    @Enumerated(EnumType.STRING)
    private Status status;
}
