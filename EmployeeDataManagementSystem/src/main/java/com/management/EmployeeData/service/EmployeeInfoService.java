package com.management.EmployeeData.service;

import com.management.EmployeeData.model.EmployeeInfo;

import java.util.List;

public interface EmployeeInfoService {
  public List<EmployeeInfo> getAllEmployeeInfos();        // get all rows from the data table
  public EmployeeInfo getEmployeeInfo( int id );          // get individual row
  public void saveOrUpdate( EmployeeInfo employeeInfo );  // save a row
  public void deleteEmployeeInfo( int id );               // delete a row
}
