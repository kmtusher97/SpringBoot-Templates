package com.management.EmployeeData.repository;

import com.management.EmployeeData.model.EmployeeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInfoRepository extends CrudRepository<EmployeeInfo, Integer> {

}
