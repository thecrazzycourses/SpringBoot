package com.spring.documentation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class LogUser extends Logging{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
}
