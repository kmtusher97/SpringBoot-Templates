package com.one2many.spring.Demo.One.to.Many.Project.controller;

import com.one2many.spring.Demo.One.to.Many.Project.model.Faculty;
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
public class FacultyController {

    @Autowired
    FacultyServices facultyServices;

    @GetMapping(value = "/allFaculties")
    public ModelAndView showAllFaculties() {
        ModelAndView modelAndView = new ModelAndView("Faculties");

        List<Faculty> facultyList = facultyServices.getAllFaculties();

        modelAndView.addObject("faculties", facultyList);

        return modelAndView;
    }


    @GetMapping(value = "/addFaculty")
    public ModelAndView addNewFaculty() {
        ModelAndView modelAndView = new ModelAndView("FacultyForm");

        Faculty faculty = new Faculty();

        modelAndView.addObject("faculty", faculty);

        return modelAndView;
    }


    @PostMapping(value = "/saveFaculty")
    public ModelAndView saveFaculty(@ModelAttribute("faculty") Faculty faculty) {
        facultyServices.saveOrUpdateFaculty(faculty);

        return new ModelAndView("redirect:/allFaculties");
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editFaculty(@PathVariable("id") Long facultyId) {
        Faculty faculty = facultyServices.getFacultyById(facultyId);

        ModelAndView modelAndView = new ModelAndView("FacultyForm");

        modelAndView.addObject("faculty", faculty);

        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteFaculty(@PathVariable("id") Long facultyId) {
        facultyServices.deleteFacultyById(facultyId);

        return new ModelAndView("redirect:/allFaculties");
    }
}
