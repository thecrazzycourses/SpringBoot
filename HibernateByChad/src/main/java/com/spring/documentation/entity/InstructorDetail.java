package com.spring.documentation.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String youtubeChannel;
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail")
    @JsonIgnore
    private Instructor instructor;

}
