package com.management.EmployeeData.service;

import com.management.EmployeeData.model.EmployeeInfo;
import com.management.EmployeeData.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmplyeeInfoServiceImplementation implements EmployeeInfoService {

  @Autowired
  EmployeeInfoRepository employeeInfoRepository;

  @Override
  public List<EmployeeInfo> getAllEmployeeInfos() {
    return  (List<EmployeeInfo>) employeeInfoRepository.findAll();
  }

  @Override
  public EmployeeInfo getEmployeeInfo( int id ) {
    return employeeInfoRepository.findById( id ).get();
  }

  @Override
  public void saveOrUpdate( EmployeeInfo employeeInfo ) {
    employeeInfoRepository.save( employeeInfo );
  }

  @Override
  public void deleteEmployeeInfo( int id ) {
    employeeInfoRepository.deleteById( id );
  }
}
