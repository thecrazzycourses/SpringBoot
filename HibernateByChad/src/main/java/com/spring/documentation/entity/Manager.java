package com.spring.documentation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "MANAGER")
public class Manager extends User {

    private String project;
}
