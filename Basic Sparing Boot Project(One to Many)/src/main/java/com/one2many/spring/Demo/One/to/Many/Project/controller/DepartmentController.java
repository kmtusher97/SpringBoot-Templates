package com.one2many.spring.Demo.One.to.Many.Project.controller;

import com.one2many.spring.Demo.One.to.Many.Project.model.Department;
import com.one2many.spring.Demo.One.to.Many.Project.model.Faculty;
import com.one2many.spring.Demo.One.to.Many.Project.services.DepartmentServices;
import com.one2many.spring.Demo.One.to.Many.Project.services.FacultyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentServices departmentServices;

    @Autowired
    FacultyServices facultyServices;

    @GetMapping(value = "/allDepts")
    public ModelAndView showAllDepartments() {
        ModelAndView modelAndView = new ModelAndView("Departments");

        List<Department> departmentList = departmentServices.getAllDepartment();

        modelAndView.addObject("departments", departmentList);

        return modelAndView;
    }


    @GetMapping(value = "/addDepartment")
    public ModelAndView addNewDepartment() {
        ModelAndView modelAndView = new ModelAndView("DepartmentForm");

        Department department = new Department();

        modelAndView.addObject("department", department);

        return modelAndView;
    }

    @PostMapping(value = "/saveDept")
    public ModelAndView saveDepartment(@ModelAttribute("department") Department department) {
        Faculty faculty = facultyServices.getFacultyById(department.getFaculty().getFacultyId());
        department.setFaculty(faculty);

        departmentServices.saveOrUpdateDepartment(department);

        return new ModelAndView("redirect:/allDepts");
    }


    @GetMapping(value = "/editDept/{id}")
    public ModelAndView editDepartment(@PathVariable("id") Long id) {
        Department department = departmentServices.getDepartmentById(id);

        ModelAndView modelAndView = new ModelAndView("DepartmentForm");

        modelAndView.addObject("department", department);

        return modelAndView;
    }

    @GetMapping(value = "/deleteDept/{id}")
    public ModelAndView deleteDepartment(@PathVariable("id") Long id) {
        departmentServices.deleteDepartmentById(id);

        return new ModelAndView("redirect:/allDepts");
    }
}
