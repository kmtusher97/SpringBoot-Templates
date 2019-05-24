package com.one2many.spring.Demo.One.to.Many.Project.services;

import com.one2many.spring.Demo.One.to.Many.Project.model.Department;
import com.one2many.spring.Demo.One.to.Many.Project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DepartmentServicesImplementation implements DepartmentServices {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public void saveOrUpdateDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
}
