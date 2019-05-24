package com.one2many.spring.Demo.One.to.Many.Project.services;

import com.one2many.spring.Demo.One.to.Many.Project.model.Department;

import java.util.List;

public interface DepartmentServices {

    List<Department> getAllDepartment();

    Department getDepartmentById(Long id);

    void saveOrUpdateDepartment(Department department);

    void deleteDepartmentById(Long id);
}
