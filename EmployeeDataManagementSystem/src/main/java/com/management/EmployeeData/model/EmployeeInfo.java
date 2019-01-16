package com.management.EmployeeData.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "employeeinfo" )
public class EmployeeInfo {       // Entity class for employeeinfo table

  @Id
  private int id;                 // primary key
  @Column(name = "name")
  private String name;
  @Column(name = "department")
  private String department;
  @Column(name = "mobileno")
  private String mobileno;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getMobileno() {
    return mobileno;
  }

  public void setMobileno(String mobileno) {
    this.mobileno = mobileno;
  }
}
