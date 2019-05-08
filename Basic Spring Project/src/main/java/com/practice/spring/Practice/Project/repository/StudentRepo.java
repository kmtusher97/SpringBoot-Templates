package com.practice.spring.Practice.Project.repository;

import com.practice.spring.Practice.Project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
