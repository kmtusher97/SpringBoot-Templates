package com.one2many.spring.Demo.One.to.Many.Project.repository;

import com.one2many.spring.Demo.One.to.Many.Project.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
