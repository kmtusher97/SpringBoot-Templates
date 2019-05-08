package com.practice.spring.Practice.Project.services;

import com.practice.spring.Practice.Project.model.Student;
import com.practice.spring.Practice.Project.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServicesImple implements StudentServices {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentByRoll(Long roll) {
        return studentRepo.getOne(roll);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudentByRoll(Long roll) {
        studentRepo.deleteById(roll);
    }
}
