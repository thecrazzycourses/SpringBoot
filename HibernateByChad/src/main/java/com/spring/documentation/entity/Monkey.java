package com.spring.documentation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Monkey extends Animal{

    private String hands;
}
