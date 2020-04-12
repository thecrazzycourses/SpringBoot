package com.spring.documentation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "EMPLOYEE")
public class Employee extends User {

    private String department;
}
