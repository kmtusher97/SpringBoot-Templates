package com.practice.spring.Practice.Project.services;

import com.practice.spring.Practice.Project.model.Student;

import java.util.List;

public interface StudentServices {

    List<Student> getAllStudent();

    Student getStudentByRoll(Long roll);

    void saveStudent(Student student);

    void deleteStudentByRoll(Long roll);
}
