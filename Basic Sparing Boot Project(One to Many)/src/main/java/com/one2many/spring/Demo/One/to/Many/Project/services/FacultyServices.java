package com.one2many.spring.Demo.One.to.Many.Project.services;

import com.one2many.spring.Demo.One.to.Many.Project.model.Faculty;

import java.util.List;

public interface FacultyServices {

    List<Faculty> getAllFaculties();

    Faculty getFacultyById(Long id);

    void saveOrUpdateFaculty(Faculty faculty);

    void deleteFacultyById(Long id);
}
