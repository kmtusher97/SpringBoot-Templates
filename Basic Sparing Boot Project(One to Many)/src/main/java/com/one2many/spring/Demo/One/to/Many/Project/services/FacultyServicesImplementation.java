package com.one2many.spring.Demo.One.to.Many.Project.services;

import com.one2many.spring.Demo.One.to.Many.Project.model.Faculty;
import com.one2many.spring.Demo.One.to.Many.Project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FacultyServicesImplementation implements FacultyServices {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.getOne(id);
    }

    @Override
    public void saveOrUpdateFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public void deleteFacultyById(Long id) {
        facultyRepository.deleteById(id);
    }
}
