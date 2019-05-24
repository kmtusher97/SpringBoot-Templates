package com.one2many.spring.Demo.One.to.Many.Project.model;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    private Long departmentId;

    private String departmentName;

    private String departmentCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
