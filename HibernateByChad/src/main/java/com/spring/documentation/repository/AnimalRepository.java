package com.spring.documentation.repository;

import com.spring.documentation.entity.*;
import org.springframework.data.jpa.repository.*;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
