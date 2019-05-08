package com.practice.spring.Practice.Project.controller;


import com.practice.spring.Practice.Project.model.Student;
import com.practice.spring.Practice.Project.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentServices studentServices;

    @GetMapping(value = "/all")
    public ModelAndView getAllStudent() {
        ModelAndView modelAndView = new ModelAndView("StudentsView");

        List<Student> studentList = studentServices.getAllStudent();

        modelAndView.addObject("students", studentList);

        return modelAndView;
    }


    @GetMapping(value = "/new")
    public ModelAndView addNewStudent() {
        ModelAndView modelAndView = new ModelAndView("Edit");

        Student student = new Student();

        modelAndView.addObject("student", student);

        return modelAndView;
    }


    @PostMapping(value = "/save")
    public ModelAndView saveNewStudent(@ModelAttribute("student") Student studentNew) {
        studentServices.saveStudent(studentNew);

        return new ModelAndView("redirect:/all");
    }


    @GetMapping(value = "/edit/{roll}")
    public ModelAndView editStudent(@PathVariable("roll") Long roll) {
        Student student = studentServices.getStudentByRoll(roll);

        ModelAndView modelAndView = new ModelAndView("Edit");

        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @GetMapping(value = "/delete/{roll}")
    public ModelAndView deleteStudentByRoll(@PathVariable("roll") Long roll) {
        studentServices.deleteStudentByRoll(roll);

        return new ModelAndView("redirect:/all");
    }
}
