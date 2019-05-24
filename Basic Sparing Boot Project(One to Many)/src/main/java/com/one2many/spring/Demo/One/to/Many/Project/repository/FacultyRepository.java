package com.one2many.spring.Demo.One.to.Many.Project.repository;

import com.one2many.spring.Demo.One.to.Many.Project.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
