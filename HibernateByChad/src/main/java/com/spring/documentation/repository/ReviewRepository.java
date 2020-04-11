package com.spring.documentation.repository;

import com.spring.documentation.entity.*;
import org.springframework.data.jpa.repository.*;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
