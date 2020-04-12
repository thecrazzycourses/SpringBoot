package com.spring.documentation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@MappedSuperclass
@Getter
@Setter
public abstract class Logging {

    private Date createdAt;
    private Date updatedAt;
}
