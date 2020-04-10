package com.spring.documentation.repository;

import com.spring.documentation.entity.*;
import org.springframework.data.jpa.repository.*;

/**
 *  Spring Data Rest will be used with endpoint which dont require any business logic
 *  If there is requirement of siple CRUD operation then we can use spring data rest
 *
 *  Always extends JpaRepository as this extends Pagination and Crud Repo
 *
 *  Get /employees finalAll()
 *  Post /employees save()
 *  Get /employees/{id} findOne()
 *  Put /employees/{id} save() // Update with data in body
 *  Patch /employees/{id} save() // Update with data in body, only update take the changed value
 *  Delete /employees/{id} delete()
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
